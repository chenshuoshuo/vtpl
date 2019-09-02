/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019-3-29 10:28:02                           */
/* Version:        2.1                                          */
/* Author:         RY                                           */
/* Description:    1.增加数据清理函数                           */
/* Description:    2.定位数据增加校区ID                         */
/* Description:    3.修改触发器函数，解决null导致执行失败问题   */
/*==============================================================*/

--增加数据清理函数
CREATE OR REPLACE FUNCTION fun_vtpl_clean_data(_date int4)
  RETURNS void AS $BODY$
  DECLARE
    _table_date varchar[]; -- 日表数组
    _sql varchar; -- 删表SQL语句
  BEGIN
    --查询日表数组
    select array_agg(SUBSTR(tablename, 10)) from pg_tables where schemaname = 'public' and SUBSTR(tablename, 10) ~ '^[0-9]+$' into _table_date;

    --遍历删除日表
    FOR _index IN 1..ARRAY_LENGTH(_table_date, 1) LOOP
      if _table_date[_index]:: int < _date then
        _sql = 'drop table location_' || _table_date[_index];
        execute _sql;
      end if;
    END LOOP;

    --删除历史表的数据
    delete from location_history_day where location_time < to_timestamp(_date::varchar, 'yyyymmdd');
    delete from location_history_month where location_time < to_timestamp(_date::varchar, 'yyyymmdd');
    delete from location_history_year where location_time < to_timestamp(_date::varchar, 'yyyymmdd');

    RETURN;
  END
  $BODY$
LANGUAGE plpgsql VOLATILE
COST 100;

COMMENT ON FUNCTION fun_vtpl_clean_data(_date int4) IS '清除过期数据行数：fun_vtpl_clean_data';

--增加校区字段

ALTER TABLE location_latest ADD COLUMN zone_id varchar(64);
COMMENT ON COLUMN location_latest.zone_id IS '区域ID';

ALTER TABLE location_history_day ADD COLUMN zone_id varchar(64);
COMMENT ON COLUMN location_history_day.zone_id IS '区域ID';

ALTER TABLE location_history_month ADD COLUMN zone_id varchar(64);
COMMENT ON COLUMN location_history_month.zone_id IS '区域ID';

ALTER TABLE location_history_year ADD COLUMN zone_id varchar(64);
COMMENT ON COLUMN location_history_year.zone_id IS '区域ID';


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
    begin
      select NEW.userid, NEW.realname, NEW.gender, NEW.account_mac, NEW.org_code, NEW.org_name, NEW.lng, NEW.lat, NEW.floorid, NEW.location_time, NEW.in_door, NEW.in_school, NEW.usr_update_time, NEW.location_mode ,NEW.zone_id into
           _userid, _realname, _gender, _account_mac, _org_code, _org_name, _lng, _lat, _floorid, _location_time, _in_door, _in_school, _usr_update_time, _location_mode, _zone_id;

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
            zone_id              VARCHAR(64)          null
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

        _insert_sql_temp = 'insert into INSERT_TABLE_NAME (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, zone_id, usr_update_time, location_mode) values ('
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
          || (case when _usr_update_time is null then 'null' else '''' || _usr_update_time || '''' end) || ', ';

          _insert_sql_temp = _insert_sql_temp || (case when _location_mode is null then 'null' else '''' || _location_mode || '''' end) || ')';
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
        select count(*) from location_history_day where to_char(location_time, 'yyyy-mm-dd hh24:mi') = to_char(_location_time, 'yyyy-mm-dd hh24:mi') and account_mac = _account_mac into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', 'location_history_day');
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;

        --月数据稀疏
        select count(*) from location_history_month where to_char(location_time, 'yyyy-mm-dd hh24') = to_char(_location_time, 'yyyy-mm-dd hh24') and account_mac = _account_mac into _data_count;
        if _data_count = 0 then
          _sql = regexp_replace(_insert_sql_temp, 'INSERT_TABLE_NAME', 'location_history_month');
          raise notice '_sql:%',_sql;
          execute _sql;
        end if;

        --年数据稀疏
        select count(*) from location_history_year where to_char(location_time, 'yyyy-mm-dd') = to_char(_location_time, 'yyyy-mm-dd') and account_mac = _account_mac into _data_count;
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