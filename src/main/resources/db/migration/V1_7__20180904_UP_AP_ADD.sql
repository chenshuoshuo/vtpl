/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-09-04 09:12:14                          */
/* Version:        1.7                                          */
/* Author:         RY                                           */
/* Description:    增加泛定位AP信息数据表                       */
/*==============================================================*/

/*==============================================================*/
/* Table: location_h3c_up_ap                                    */
/*==============================================================*/
create table location_h3c_up_ap (
   ap_code              VARCHAR(64)          not null,
   campus_name          VARCHAR(64)          null,
   building_name        VARCHAR(255)         null,
   room_name            VARCHAR(255)         null,
   floor_id             VARCHAR(16)          null,
   in_door              INT4                 null,
   lng                  FLOAT8               null,
   lat                  FLOAT8               null,
   orderid              INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_H3C_UP_AP primary key (ap_code)
);

comment on table location_h3c_up_ap is
'泛定位AP信息：location_h3c_up_ap';

comment on column location_h3c_up_ap.ap_code is
'AP代码：ap_code';

comment on column location_h3c_up_ap.campus_name is
'校区名称：campus_name';

comment on column location_h3c_up_ap.building_name is
'大楼名称：building_name';

comment on column location_h3c_up_ap.room_name is
'房间名称：room_name';

comment on column location_h3c_up_ap.floor_id is
'楼层ID：floor_id';

comment on column location_h3c_up_ap.in_door is
'室内/室外：in_door，1室内，2室外';

comment on column location_h3c_up_ap.lng is
'AP经度：lng';

comment on column location_h3c_up_ap.lat is
'AP纬度：lat';

comment on column location_h3c_up_ap.orderid is
'排序：orderid';

comment on column location_h3c_up_ap.memo is
'备注：memo';