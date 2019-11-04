/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019-3-29 10:28:02                           */
/* Version:        3.0                                          */
/* Author:         CYG                                          */
/* Description:    1.添加校区id                                 */
/* Description:    2.添加华为视图                               */
/*==============================================================*/


alter table location_h3c_view
    add zone_id varchar(16);

comment on column location_h3c_view.zone_id is '校区id：zone_id';

alter table location_view_ruijie
    add zone_id varchar(16);

comment on column location_view_ruijie.zone_id is '校区id：zone_id';

alter table location_h3c_up_ap
    add zone_id varchar(16);

comment on column location_h3c_up_ap.zone_id is '校区id：zone_id';

/*==============================================================*/
/* Table: location_history_day                                  */
/*==============================================================*/
create table hw_device_location
(
    device_mac  VARCHAR(64) null,
    device_name VARCHAR(64) null,
    campus      VARCHAR(64) null,
    building    VARCHAR(64) null,
    room        VARCHAR(64) null,
    indoor      INTEGER     null,
    lng         FLOAT8      null,
    lat         FLOAT8      null,
    orderid     INTEGER     null,
    floorid     VARCHAR(16) null,
    zone_id     VARCHAR(16) null,
    memo        VARCHAR(50) null,
    constraint PK_HW_DEVICE_LOCATION primary key (device_mac)
);

comment on table hw_device_location is
    '华为泛定位AP信息：hw_device_location';


comment on column hw_device_location.device_mac is
    '设备物理地址：device_mac';

comment on column hw_device_location.device_name is
    '设备名称：device_name';

comment on column hw_device_location.campus is
    '安装校区：campus';

comment on column hw_device_location.building is
    '安装大楼：building';

comment on column hw_device_location.room is
    '安装房间：room';

comment on column hw_device_location.indoor is
    '室内/室外，1室内，2室外';

comment on column hw_device_location.lng is
    '纬度：lng';

comment on column hw_device_location.lat is
    '纬度：lat';

comment on column hw_device_location.orderid is
    '排序：orderid';

comment on column hw_device_location.floorid is
    '楼层id：floorid';

comment on column hw_device_location.zone_id is
    '校区id：zone_id';

comment on column hw_device_location.memo is
    '备注：memo';