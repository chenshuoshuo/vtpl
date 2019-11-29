/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019/11/6 19:54:44                           */
/* Description:    一卡通设备表和记录                             */
/*==============================================================*/
drop table if exists location_ecard_use_record;
drop table if exists location_ecard_device;


/*==============================================================*/
/* Table: location_ecard_device                           */
/*==============================================================*/
create table location_ecard_device (
   device_code          VARCHAR(255)         not null,
   device_name          VARCHAR(255)         null,
   install_campus       VARCHAR(255)         null,
   install_building     VARCHAR(255)         null,
   install_room         VARCHAR(255)         null,
   device_lng           FLOAT8               null,
   device_lat           FLOAT8               null,
   gis_leaf             INT4                 null,
   order_id             INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_LOCATION_ECARD_DEVICE primary key (device_code)
);

comment on table location_ecard_device is
'一卡通设备信息：location_ecard_device';

comment on column location_ecard_device.device_code is
'设备唯一编码：device_code';

comment on column location_ecard_device.device_name is
'设备名称：device_name';

comment on column location_ecard_device.install_campus is
'安装校区：install_campus';

comment on column location_ecard_device.install_building is
'安装大楼：install_building';

comment on column location_ecard_device.install_room is
'安装房间：install_room';

comment on column location_ecard_device.device_lng is
'安装位置经度：device_lng';

comment on column location_ecard_device.device_lat is
'安装位置纬度：device_lat';

comment on column location_ecard_device.gis_leaf is
'地图楼层：gis_leaf';

comment on column location_ecard_device.order_id is
'排序：order_id';

comment on column location_ecard_device.memo is
'备注：memo';

/*==============================================================*/
/* Table: location_ecard_use_record                       */
/*==============================================================*/
create table location_ecard_use_record (
   record_code          VARCHAR(255)         not null,
   device_code          VARCHAR(255)         null,
   ecard_no             VARCHAR(255)         null,
   user_code            VARCHAR(255)         null,
   use_time             TIMESTAMP            null,
   constraint PK_LOCATION_ECARD_USE_RE primary key (record_code)
);

comment on table location_ecard_use_record is
'一卡通使用记录：location_ecard_use_record';

comment on column location_ecard_use_record.record_code is
'流水号：record_code';

comment on column location_ecard_use_record.device_code is
'设备唯一编码：device_code';

comment on column location_ecard_use_record.ecard_no is
'一卡通账号：ecard_no';

comment on column location_ecard_use_record.user_code is
'人员学工号：user_code';

comment on column location_ecard_use_record.use_time is
'使用时间：use_time';

alter table location_ecard_use_record
   add constraint FK_ECARD_USE_REF_DEVICE foreign key (device_code)
      references location_ecard_device (device_code)
      on delete cascade on update cascade;

