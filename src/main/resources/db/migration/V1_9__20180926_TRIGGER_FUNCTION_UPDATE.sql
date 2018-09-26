/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-9-26 20:08:55                           */
/* Version:        1.9                                          */
/* Author:         RY                                           */
/* Description:    触发函数更新                                 */
/* Description:    分表存储增加用户信息更新时间、定位方式       */
/*==============================================================*/

CREATE OR REPLACE FUNCTION "public"."update_location_info"()
  RETURNS "pg_catalog"."trigger" AS $BODY$
declare
	_table_name varchar; --表名
	_table_count int4; --表是否存在，1存在，0不存在
    _data_count int4; --数据是否存在，1存在，0不存在
	_sql varchar; --SQL语句
 begin
		if NEW.lng is not null and NEW.lat is not null and NEW.location_time is not null then

                --原始数据分表存储
                select 'location_' || to_char(NEW.location_time, 'yyyymmdd') into _table_name;
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
									 location_mode        VARCHAR(50)          null
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

								create  index Index_' || _table_name || '_userid on ' || _table_name || ' (
								userid
								)';
					execute _sql;
				end if;
                --检查是否存在该用户相同时间的定位信息
                _sql = 'select count(*) from ' || _table_name || ' where to_char(location_time, ''yyyy-mm-dd hh24:mi:ss'') = ''' || to_char(NEW.location_time, 'yyyy-mm-dd hh24:mi:ss') || ''' and userid = ''' || NEW.userid || '''';
                execute _sql into _data_count;
                if _data_count = 0 then
    				_sql = 'insert into ' || _table_name || ' (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, usr_update_time, location_mode)
    						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.account_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
    						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ', ''' || NEW.usr_update_time || ''', ''' || NEW.location_mode || ''')';
    				raise notice '_sql:%',_sql;
						execute _sql;
                end if;

                --日数据稀疏
                select count(*) from location_history_day where to_char(location_time, 'yyyy-mm-dd hh24:mi') = to_char(NEW.location_time, 'yyyy-mm-dd hh24:mi')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_day (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, usr_update_time, location_mode)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.account_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ', ''' || NEW.usr_update_time || ''', ''' || NEW.location_mode || ''')';
			    	execute _sql;
                end if;

                --月数据稀疏
                select count(*) from location_history_month where to_char(location_time, 'yyyy-mm-dd hh24') = to_char(NEW.location_time, 'yyyy-mm-dd hh24')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_month (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, usr_update_time, location_mode)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.account_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ', ''' || NEW.usr_update_time || ''', ''' || NEW.location_mode || ''')';
			    	execute _sql;
                end if;

                --年数据稀疏
                select count(*) from location_history_year where to_char(location_time, 'yyyy-mm-dd') = to_char(NEW.location_time, 'yyyy-mm-dd')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_year (userid, realname, gender, account_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school, usr_update_time, location_mode)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.account_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ', ''' || NEW.usr_update_time || ''', ''' || NEW.location_mode || ''')';
			    	execute _sql;
                end if;

		 end if;
		 return null;
	end;$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;