/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-8-6 20:08:44                            */
/* Version:        1.1                                          */
/* Author:         RY                                           */
/* Description:    可视化轨迹大数据平台数据库初版本             */
/*==============================================================*/

/*==============================================================*/
/* Table: location_campus_info                                  */
/*==============================================================*/
create table location_campus_info (
   campus_id            SERIAL               not null,
   school_id            INT4                 null,
   campus_name          VARCHAR(255)         null,
   campus_logo          VARCHAR(255)         null,
   left_down_lng        FLOAT8               null,
   left_down_lat        FLOAT8               null,
   right_top_lng        FLOAT8               null,
   right_top_lat        FLOAT8               null,
   is_default           INT4                 null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_CAMPUS_INFO primary key (campus_id)
);

comment on table location_campus_info is
'校区信息：location_campus_info';

comment on column location_campus_info.campus_id is
'校区ID：campus_id';

comment on column location_campus_info.school_id is
'学校ID：school_id';

comment on column location_campus_info.campus_name is
'校区名称：campus_name';

comment on column location_campus_info.campus_logo is
'校区LOGO：campus_logo';

comment on column location_campus_info.left_down_lng is
'左下经度：left_down_lng';

comment on column location_campus_info.left_down_lat is
'左下纬度：left_down_lat';

comment on column location_campus_info.right_top_lng is
'右上经度：right_top_lng';

comment on column location_campus_info.right_top_lat is
'右上纬度：right_top_lat';

comment on column location_campus_info.is_default is
'是否默认：is_default,1是,0否';

comment on column location_campus_info.orderid is
'排序：orderid';

comment on column location_campus_info.memo is
'备注：memo';

/*==============================================================*/
/* Table: location_h3c_view                                     */
/*==============================================================*/
create table location_h3c_view (
   view_id              SERIAL               not null,
   view_name            VARCHAR(255)         null,
   level                INT4                 null,
   sub_location_count   INT4                 null,
   lon                  FLOAT8               null,
   lat                  FLOAT8               null,
   scale                FLOAT8               null,
   scale_type           INT4                 null,
   floorid              VARCHAR(64)          null,
   building_code        VARCHAR(64)          null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_H3C_VIEW primary key (view_id)
);

comment on table location_h3c_view is
'位置视图（华三）表：location_h3c_view';

comment on column location_h3c_view.view_id is
'视图ID：view_id';

comment on column location_h3c_view.view_name is
'视图名称：view_name';

comment on column location_h3c_view.level is
'视图级别：level';

comment on column location_h3c_view.sub_location_count is
'下级视图个数：sub_location_count';

comment on column location_h3c_view.lon is
'原点经度：lon';

comment on column location_h3c_view.lat is
'原点纬度：lat';

comment on column location_h3c_view.scale is
'比例尺：scale';

comment on column location_h3c_view.scale_type is
'比例尺类型：0米，1英尺：scale_type';

comment on column location_h3c_view.floorid is
'楼层ID：floorid';

comment on column location_h3c_view.building_code is
'大楼ID：building_code';

comment on column location_h3c_view.orderid is
'排序：orderid';

comment on column location_h3c_view.memo is
'备注：memo';

/*==============================================================*/
/* Table: location_history_day                                  */
/*==============================================================*/
create table location_history_day (
   userid               VARCHAR(64)          null,
   realname             VARCHAR(64)          null,
   gender               VARCHAR(16)          null,
   account_mac          VARCHAR(64)          null,
   org_code             VARCHAR(64)          null,
   org_name             VARCHAR(255)         null,
   lng                  FLOAT8               null,
   lat                  FLOAT8               null,
   floorid              VARCHAR(64)          null,
   location_time        TIMESTAMP            null,
   usr_update_time      TIMESTAMP            null,
   location_mode        VARCHAR(50)          null,
   in_door              INT4                 null,
   in_school            INT4                 null
);

comment on table location_history_day is
'定位信息-日数据表：location_history_day';

comment on column location_history_day.userid is
'用户ID：userid';

comment on column location_history_day.realname is
'用户姓名：realname';

comment on column location_history_day.gender is
'性别：gender';

comment on column location_history_day.account_mac is
'上网账号/mac：account_mac';

comment on column location_history_day.org_code is
'所在组织架构编码：org_code';

comment on column location_history_day.org_name is
'所在组织架构名称：org_name';

comment on column location_history_day.lng is
'位置经度：lng';

comment on column location_history_day.lat is
'位置纬度：lat';

comment on column location_history_day.floorid is
'位置楼层：floorid';

comment on column location_history_day.location_time is
'定位时间：location_time';

comment on column location_history_day.usr_update_time is
'用户信息更新时间：usr_update_time';

comment on column location_history_day.location_mode is
'定位方式：location_mode';

comment on column location_history_day.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_history_day.in_school is
'校内/校外：in_school，1校内，2校外';

/*==============================================================*/
/* Index: Index_day_userid                                      */
/*==============================================================*/
create  index Index_day_userid on location_history_day (
userid
);

/*==============================================================*/
/* Index: Index_day_time                                        */
/*==============================================================*/
create  index Index_day_time on location_history_day (
location_time
);

/*==============================================================*/
/* Index: Index_day_org_code                                    */
/*==============================================================*/
create  index Index_day_org_code on location_history_day (
org_code
);

/*==============================================================*/
/* Index: Index_day_floorid                                     */
/*==============================================================*/
create  index Index_day_floorid on location_history_day (
floorid
);

/*==============================================================*/
/* Table: location_history_month                                */
/*==============================================================*/
create table location_history_month (
   userid               VARCHAR(64)          null,
   realname             VARCHAR(64)          null,
   gender               VARCHAR(16)          null,
   account_mac          VARCHAR(64)          null,
   org_code             VARCHAR(64)          null,
   org_name             VARCHAR(255)         null,
   lng                  FLOAT8               null,
   lat                  FLOAT8               null,
   floorid              VARCHAR(64)          null,
   location_time        TIMESTAMP            null,
   usr_update_time      TIMESTAMP            null,
   location_mode        VARCHAR(50)          null,
   in_door              INT4                 null,
   in_school            INT4                 null
);

comment on table location_history_month is
'定位信息-月数据表：location_history_month';

comment on column location_history_month.userid is
'用户ID：userid';

comment on column location_history_month.realname is
'用户姓名：realname';

comment on column location_history_month.gender is
'性别：gender';

comment on column location_history_month.account_mac is
'上网账号/mac：account_mac';

comment on column location_history_month.org_code is
'所在组织架构编码：org_code';

comment on column location_history_month.org_name is
'所在组织架构名称：org_name';

comment on column location_history_month.lng is
'位置经度：lng';

comment on column location_history_month.lat is
'位置纬度：lat';

comment on column location_history_month.floorid is
'位置楼层：floorid';

comment on column location_history_month.location_time is
'定位时间：location_time';

comment on column location_history_month.usr_update_time is
'用户信息更新时间：usr_update_time';

comment on column location_history_month.location_mode is
'定位方式：location_mode';

comment on column location_history_month.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_history_month.in_school is
'校内/校外：in_school，1校内，2校外';

/*==============================================================*/
/* Index: Index_month_userid                                    */
/*==============================================================*/
create  index Index_month_userid on location_history_month (
userid
);

/*==============================================================*/
/* Index: Index_month_time                                      */
/*==============================================================*/
create  index Index_month_time on location_history_month (
location_time
);

/*==============================================================*/
/* Index: Index_month_org_code                                  */
/*==============================================================*/
create  index Index_month_org_code on location_history_month (
org_code
);

/*==============================================================*/
/* Index: Index_month_floorid                                   */
/*==============================================================*/
create  index Index_month_floorid on location_history_month (
floorid
);

/*==============================================================*/
/* Table: location_history_year                                 */
/*==============================================================*/
create table location_history_year (
   userid               VARCHAR(64)          null,
   realname             VARCHAR(64)          null,
   gender               VARCHAR(16)          null,
   account_mac          VARCHAR(64)          null,
   org_code             VARCHAR(64)          null,
   org_name             VARCHAR(255)         null,
   lng                  FLOAT8               null,
   lat                  FLOAT8               null,
   floorid              VARCHAR(64)          null,
   location_time        TIMESTAMP            null,
   usr_update_time      TIMESTAMP            null,
   location_mode        VARCHAR(50)          null,
   in_door              INT4                 null,
   in_school            INT4                 null
);

comment on table location_history_year is
'定位信息-年数据表：location_history_year';

comment on column location_history_year.userid is
'用户ID：userid';

comment on column location_history_year.realname is
'用户姓名：realname';

comment on column location_history_year.gender is
'性别：gender';

comment on column location_history_year.account_mac is
'上网账号/mac：account_mac';

comment on column location_history_year.org_code is
'所在组织架构编码：org_code';

comment on column location_history_year.org_name is
'所在组织架构名称：org_name';

comment on column location_history_year.lng is
'位置经度：lng';

comment on column location_history_year.lat is
'位置纬度：lat';

comment on column location_history_year.floorid is
'位置楼层：floorid';

comment on column location_history_year.location_time is
'定位时间：location_time';

comment on column location_history_year.usr_update_time is
'用户信息更新时间：usr_update_time';

comment on column location_history_year.location_mode is
'定位方式：location_mode';

comment on column location_history_year.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_history_year.in_school is
'校内/校外：in_school，1校内，2校外';

/*==============================================================*/
/* Index: Index_year_userid                                     */
/*==============================================================*/
create  index Index_year_userid on location_history_year (
userid
);

/*==============================================================*/
/* Index: Index_year_time                                       */
/*==============================================================*/
create  index Index_year_time on location_history_year (
location_time
);

/*==============================================================*/
/* Index: Index_year_org_code                                   */
/*==============================================================*/
create  index Index_year_org_code on location_history_year (
org_code
);

/*==============================================================*/
/* Index: Index_year_floorid                                    */
/*==============================================================*/
create  index Index_year_floorid on location_history_year (
floorid
);

/*==============================================================*/
/* Table: location_latest                                       */
/*==============================================================*/
create table location_latest (
   userid               VARCHAR(64)          not null,
   realname             VARCHAR(64)          null,
   gender               VARCHAR(16)          null,
   account_mac          VARCHAR(64)          null,
   org_code             VARCHAR(64)          null,
   org_name             VARCHAR(255)         null,
   lng                  FLOAT8               null,
   lat                  FLOAT8               null,
   floorid              VARCHAR(64)          null,
   location_time        TIMESTAMP            null,
   usr_update_time      TIMESTAMP            null,
   location_mode        VARCHAR(50)          null,
   in_door              INT4                 null,
   in_school            INT4                 null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_LATEST primary key (userid)
);

comment on table location_latest is
'用户最新位置信息：location_latest';

comment on column location_latest.userid is
'用户ID：userid';

comment on column location_latest.realname is
'用户姓名：realname';

comment on column location_latest.gender is
'性别：gender';

comment on column location_latest.account_mac is
'上网账号/mac：account_mac';

comment on column location_latest.org_code is
'所在组织架构编码：org_code';

comment on column location_latest.org_name is
'所在组织架构名称：org_name';

comment on column location_latest.lng is
'位置经度：lng';

comment on column location_latest.lat is
'位置纬度：lat';

comment on column location_latest.floorid is
'位置楼层：floorid';

comment on column location_latest.location_time is
'定位时间：location_time';

comment on column location_latest.usr_update_time is
'用户信息更新时间：usr_update_time';

comment on column location_latest.location_mode is
'定位方式：location_mode';

comment on column location_latest.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_latest.in_school is
'校内/校外：in_school，1校内，2校外';

comment on column location_latest.orderid is
'排序：orderid';

comment on column location_latest.memo is
'备注：memo';

/*==============================================================*/
/* Index: Index_org_code                                        */
/*==============================================================*/
create  index Index_org_code on location_latest (
org_code
);

/*==============================================================*/
/* Index: Index_location_time                                   */
/*==============================================================*/
create  index Index_location_time on location_latest (
location_time
);

/*==============================================================*/
/* Index: Index_floorid                                         */
/*==============================================================*/
create  index Index_floorid on location_latest (
floorid
);

/*==============================================================*/
/* Table: location_system_config                                */
/*==============================================================*/
create table location_system_config (
   config_id            INT4                 not null,
   system_name          VARCHAR(255)         null,
   system_logo          VARCHAR(255)         null,
   lq_map_gis_url       VARCHAR(255)         null,
   amap_key             VARCHAR(255)         null,
   update_time          TIMESTAMP            null,
   constraint PK_LOCATION_SYSTEM_CONFIG primary key (config_id)
);

comment on table location_system_config is
'系统配置：location_system_config';

comment on column location_system_config.config_id is
'配置信息ID：config_id';

comment on column location_system_config.system_name is
'系统名称：system_name';

comment on column location_system_config.system_logo is
'系统LOGO：system_logo';

comment on column location_system_config.lq_map_gis_url is
'GIS3.0地址：lq_map_gis_url';

comment on column location_system_config.amap_key is
'高德地图KEY：amap_key';

comment on column location_system_config.update_time is
'更新时间：update_time';

/*==============================================================*/
/* Table: location_third_party                                  */
/*==============================================================*/
create table location_third_party (
   app_id               SERIAL               not null,
   app_name             VARCHAR(255)         null,
   app_org              VARCHAR(255)         null,
   app_key              VARCHAR(64)          null,
   access_time          TIMESTAMP            null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_THIRD_PARTY primary key (app_id)
);

comment on table location_third_party is
'第三方应用信息：location_third_party';

comment on column location_third_party.app_id is
'应用ID：app_id';

comment on column location_third_party.app_name is
'应用名称：app_name';

comment on column location_third_party.app_org is
'应用机构：app_org';

comment on column location_third_party.app_key is
'接入KEY：app_key';

comment on column location_third_party.access_time is
'接入时间：access_time';

comment on column location_third_party.orderid is
'排序：orderid';

comment on column location_third_party.memo is
'备注：memo';

/*==============================================================*/
/* Table: location_trajectory_manager                           */
/*==============================================================*/
create table location_trajectory_manager (
   userid               VARCHAR(64)          not null,
   username             VARCHAR(64)          null,
   deptname             VARCHAR(255)         null,
   avatar               VARCHAR(255)         null,
   password             VARCHAR(255)         null,
   is_manager           INT4                 null,
   posttime             TIMESTAMP            null,
   constraint PK_LOCATION_TRAJECTORY_MANAGER primary key (userid)
);

comment on table location_trajectory_manager is
'轨迹分析系统管理用户：location_trajectory_manager';

comment on column location_trajectory_manager.userid is
'用户ID：userid';

comment on column location_trajectory_manager.username is
'用户姓名：username';

comment on column location_trajectory_manager.deptname is
'用户部门：deptname';

comment on column location_trajectory_manager.avatar is
'头像：avatar';

comment on column location_trajectory_manager.password is
'登录密码：password';

comment on column location_trajectory_manager.is_manager is
'是否可以登录后台：is_manager,1是,0否';

comment on column location_trajectory_manager.posttime is
'添加时间：posttime';

/*==============================================================*/
/* Table: location_view_ruijie                                  */
/*==============================================================*/
create table location_view_ruijie (
   view_id              SERIAL               not null,
   view_name            VARCHAR(255)         null,
   floorid_ruijie       INT4                 null,
   floorid_lq           VARCHAR(16)          null,
   left_top_lon         FLOAT8               null,
   left_top_lat         FLOAT8               null,
   right_down_lon       FLOAT8               null,
   right_down_lat       FLOAT8               null,
   building_code        VARCHAR(64)          null,
   in_door              INT4                 null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_VIEW_RUIJIE primary key (view_id)
);

comment on table location_view_ruijie is
'位置视图（锐捷）表：location_view_ruijie';

comment on column location_view_ruijie.view_id is
'视图ID:view_id';

comment on column location_view_ruijie.view_name is
'视图名称：view_name';

comment on column location_view_ruijie.floorid_ruijie is
'楼层ID（锐捷）：floorid_ruijie';

comment on column location_view_ruijie.floorid_lq is
'楼层ID（灵奇）：floorid_lq';

comment on column location_view_ruijie.left_top_lon is
'左上经度：left_top_lon';

comment on column location_view_ruijie.left_top_lat is
'左上纬度：left_top_lat';

comment on column location_view_ruijie.right_down_lon is
'右下经度：right_down_lon';

comment on column location_view_ruijie.right_down_lat is
'右下纬度：right_down_lat';

comment on column location_view_ruijie.building_code is
'大楼ID（灵奇）：building_code';

comment on column location_view_ruijie.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_view_ruijie.orderid is
'排序：orderid';

comment on column location_view_ruijie.memo is
'备注：memo';


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
									 acount_mac           VARCHAR(64)          null,
									 org_code             VARCHAR(64)          null,
									 org_name             VARCHAR(255)         null,
									 lng                  FLOAT8               null,
									 lat                  FLOAT8               null,
									 floorid              VARCHAR(64)          null,
									 location_time        TIMESTAMP            null,
									 in_door              INT4                 null,
									 in_school            INT4                 null
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
                _sql = 'select count(*) from ' || table_name || ' where location_time = ' || NEW.location_time || ' and userid = ''' || NEW.userid || '';
                execute _sql into _data_count;
                if _data_count = 0 then
    				_sql = 'insert into ' || _table_name || ' (userid, realname, gender, acount_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school)
    						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.acount_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
    						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ')';
    				execute _sql;
                end if;

                --日数据稀疏
                select count(*) from location_history_day where to_char(location_time, 'yyyy-mm-dd hh24:mi') = to_char(NEW.location_time, 'yyyy-mm-dd hh24:mi')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_day (userid, realname, gender, acount_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.acount_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ')';
			    	execute _sql;
                end if;

                --月数据稀疏
                select count(*) from location_history_month where to_char(location_time, 'yyyy-mm-dd hh24') = to_char(NEW.location_time, 'yyyy-mm-dd hh24')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_month (userid, realname, gender, acount_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.acount_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ')';
			    	execute _sql;
                end if;

                --年数据稀疏
                select count(*) from location_history_year where to_char(location_time, 'yyyy-mm-dd') = to_char(NEW.location_time, 'yyyy-mm-dd')
                    and userid = NEW.userid into _data_count;
                if _data_count = 0 then
                    _sql = 'insert into location_history_year (userid, realname, gender, acount_mac, org_code, org_name, lng, lat, floorid, location_time, in_door, in_school)
						values ('''|| NEW.userid || ''', '''|| NEW.realname || ''', ''' || NEW.gender || ''', ''' || NEW.acount_mac || ''', ''' || NEW.org_code || ''', ''' || NEW.org_name
						|| ''', ' || NEW.lng || ', ' || NEW.lat || ', ''' || NEW.floorid || ''', ''' || NEW.location_time || ''', ' || NEW.in_door || ', ' || NEW.in_school || ')';
			    	execute _sql;
                end if;

		 end if;
		 return null;
	end;$BODY$
  LANGUAGE 'plpgsql' VOLATILE COST 100
;


CREATE TRIGGER "update_location_trigger" AFTER INSERT OR UPDATE OF "lng", "lat", "floorid", "location_time" ON "public"."location_latest"
FOR EACH ROW
EXECUTE PROCEDURE "update_location_info"();
