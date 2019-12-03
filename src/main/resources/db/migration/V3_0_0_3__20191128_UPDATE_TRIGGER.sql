/*==================================================================*/
/* DBMS name:      PostgreSQL 9.x                                   */
/* Created on:     2019-3-29 10:28:02                               */
/* Version:        3.0                                              */
/* Author:         WELLS                                            */
/* Description:    1.修改触发器函数，使用USERID判断
(当前设计不考虑手机和电脑同时在线，导致一个userid持有两个MAC，位置漂移的问题)*/
/*===================================================================*/

-- 初始化超级管理员
INSERT INTO public.location_trajectory_manager (userid, username, deptname, avatar, password, is_manager, posttime, org_codes, org_names)
VALUES ('B716B90DEC4A57F5', '超级管理员', null, null, '3d772151a166f03a1361a9bad44413ada942bfec', 1, current_timestamp , '', '')
ON conflict(userid) DO NOTHING ;

--更新触发器
CREATE OR REPLACE FUNCTION public.update_location_info()
  RETURNS pg_catalog.trigger AS
  $BODY$
    declare
      _table_name varchar; --表名
      _table_count int4; --表是否存在，1存在，0不存在
      _data_count int4; --数据是否存在，1存在，0不存在
      _sql varchar; --SQL语句
      _insert_sql_temp varchar; --数据插入SQL语句模板

      --数据表字段定义
      _userid VARCHAR(64):=null;
      _realname VARCHAR(64):=null;
      _gender VARCHAR(16):=null;
      _account_mac VARCHAR(64):=null;
      _org_code VARCHAR(64):=null;
      _org_name VARCHAR(255):=null;
      _lng FLOAT8:=null;
      _lat FLOAT8:=null;
      _floorid VARCHAR(64):=null;
      _location_time TIMESTAMP:=null;
      _in_door INT4:=null;
      _in_school INT4:=null;
      _usr_update_time TIMESTAMP:=null;
      _location_mode VARCHAR(50):=null;
      _zone_id VARCHAR(64):=null;
      _type VARCHAR(64):=null;
      _telephone VARCHAR(64):=null;
    begin
      select NEW.userid, NEW.realname, NEW.gender, NEW.account_mac, NEW.org_code, NEW.org_name, NEW.lng, NEW.lat, NEW.floorid, NEW.location_time, NEW.in_door, NEW.in_school, NEW.usr_update_time, NEW.location_mode ,NEW.zone_id ,NEW.type,NEW.telephone into
           _userid, _realname, _gender, _account_mac, _org_code, _org_name, _lng, _lat, _floorid, _location_time, _in_door, _in_school, _usr_update_time, _location_mode, _zone_id, _type, _telephone;

      if _lng is not null and _lat is not null and _location_time is not null then
        --原始数据分表存储
        select 'location_' || to_char(_location_time, 'yyyymmdd') into _table_name;
        select count(*) from pg_tables where tablename = _table_name into _table_count;
        if _table_count = 0 then
          _sql = 'create table  ' || _table_name || '  (
            userid               VARCHAR(64)          null,
            realname             VARCHAR(64)          null,
            gender               VARCHAR(16)          null,
            account_mac           VARCHAR(64)          null,
            org_code             VARCHAR(64)          null,
            org_name             VARCHAR(255)         null,
            lng                  FLOAT8               null,
            lat                  FLOAT8               null,
            floorid              VARCHAR(64)          null,
            location_time        TIMESTAMP            null,
            in_door              INT4                 null,
            in_school            INT4                 null,
            usr_update_time      TIMESTAMP            null,
            location_mode        VARCHAR(50)          null,
            zone_id              VARCHAR(64)          null,
            type                 VARCHAR(64)          null,
            telephone            VARCHAR(64)          null
            );

            create  index Index_' || _table_name || '_org_code on ' || _table_name || ' (
            org_code
            );

            create  index Index_' || _table_name || '_location_time on ' || _table_name || ' (
            location_time
            );

            create  index Index_' || _table_name || '_floorid on ' || _table_name || ' (
            floorid
            );

            create  index Index_' || _table_name || '_zone_id on ' || _table_name || ' (
            zone_id
            );

            create  index Index_' || _table_name || '_userid on ' || _table_name || ' (
            userid
            )';

           execute _sql;
        end if;

        _insert_sql_temp = 'insert into INSERT_TABLE_NAME (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, zone_id, type, usr_update_time, location_mode, telephone) values ('
          || (case when _userid is null then 'null' else '''' || _userid || '''' end) || ', '
          || (case when _realname is null then 'null' else '''' || _realname || '''' end) || ', '
          || (case when _gender is null then 'null' else '''' || _gender || '''' end) || ', '
          || '''' || _account_mac || ''', '
          || (case when _org_code is null then 'null' else '''' || _org_code || '''' end) || ', '
          || (case when _org_name is null then 'null' else '''' || _org_name || '''' end) || ', '
          || _lng || ', '
          || _lat || ', '
          || (case when _floorid is null then 'null' else _floorid end) || ', '
          || '''' || _location_time || ''', '
          || (case when _in_door is null then 2 else _in_door end) || ', '
          || (case when _in_school is null then 1 else _in_school end) || ', '
          || (case when _zone_id is null then 'null' else '''' || _zone_id || '''' end) || ', '
          || (case when _type is null then 'null' else '''' || _type || '''' end) || ', '
          || (case when _usr_update_time is null then 'null' else '''' || _usr_update_time || '''' end) || ', ';
          _insert_sql_temp = _insert_sql_temp || (case when _location_mode is null then 'null' else '''' || _location_mode || '''' end) || ', '
          || (case when _telephone is null then 'null' else '''' || _telephone || '''' end) || ')';
        raise notice 'insert_sql_temp:%', _insert_sql_temp;

        --检查是否存在该用户相同时间的定位信息
        _sql = 'select count(*) from ' || _table_name || ' where to_char(location_time, ''yyyy-mm-dd hh24:mi:ss'') = ''' || to_char(_location_time, 'yyyy-mm-dd hh24:mi:ss') || ''' and account_mac = ''' || _account_mac || '''';
        execute _sql into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', _table_name);
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;

        --日数据稀疏
        select count(*) from location_history_day where to_char(location_time, 'yyyy-mm-dd hh24:mi') = to_char(_location_time, 'yyyy-mm-dd hh24:mi') and userid = _userid  into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', 'location_history_day');
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;

        --月数据稀疏
        select count(*) from location_history_month where to_char(location_time, 'yyyy-mm-dd hh24') = to_char(_location_time, 'yyyy-mm-dd hh24') and userid = _userid into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', 'location_history_month');
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;

        --年数据稀疏
        select count(*) from location_history_year where to_char(location_time, 'yyyy-mm-dd') = to_char(_location_time, 'yyyy-mm-dd') and userid = _userid  into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', 'location_history_year');
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;
      end if;
      return null;
    end;
  $BODY$
LANGUAGE plpgsql VOLATILE
COST 100;

COMMENT ON FUNCTION public.update_location_info() IS '位置信息更新触发器：update_location_info';