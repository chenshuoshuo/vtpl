/*==============================================================*/
/* Description:  增加轨迹特殊监控表                             */
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2020/3/2 11:15:09                            */
/*==============================================================*/


drop table if exists ss_group;

drop table if exists  ss_marker;

drop table if exists  ss_person_docking;

drop table if exists  ss_person_docking_parameter;

drop table if exists  ss_person_docking_value;

/*==============================================================*/
/* Table: ss_group                                              */
/*==============================================================*/
create table ss_group (
   group_id             SERIAL               not null,
   docking_id           INT4                 null,
   group_name           VARCHAR(50)          null,
   color                VARCHAR(20)          null,
   update_time          TIMESTAMP            null,
   special_person_id    VARCHAR(50)[]        null,
   order_id             INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_SS_GROUP primary key (group_id)
);

comment on table ss_group is
'特殊监控分组信息：ss_group';

comment on column ss_group.group_id is
'分组ID：group_id';

comment on column ss_group.docking_id is
'对接方式ID：docking_id';

comment on column ss_group.group_name is
'分组名称：group_name';

comment on column ss_group.color is
'颜色代码：color';

comment on column ss_group.update_time is
'更新时间：update_time';

comment on column ss_group.special_person_id is
'监控人员信息：special_person_id';

comment on column ss_group.order_id is
'排序：order_id';

comment on column ss_group.memo is
'备注：memo';

/*==============================================================*/
/* Table: ss_marker                                             */
/*==============================================================*/
create table ss_marker (
   marker_id            SERIAL               not null,
   marker_name          VARCHAR(255)         null,
   module_id            INT4                 null,
   geom                 geometry             null,
   icon                 VARCHAR(1024)        null,
   polygon_name         VARCHAR(255)         null,
   update_time          TIMESTAMP            null,
   order_id             INT4                 null,
   memo                 VARCHAR(255)         null,
   constraint PK_SS_MARKER primary key (marker_id)
);

comment on table ss_marker is
'特殊监控标签信息：ss_marker';

comment on column ss_marker.marker_id is
'标签编号：marker_id';

comment on column ss_marker.marker_name is
'标签名称：marker_name';

comment on column ss_marker.module_id is
'所属模块：module_id';

comment on column ss_marker.geom is
'标签坐标：geom';

comment on column ss_marker.icon is
'标签图标：icon';

comment on column ss_marker.polygon_name is
'图层名称：polygon_name';

comment on column ss_marker.update_time is
'更新时间：update_time';

comment on column ss_marker.order_id is
'排序：order_id';

comment on column ss_marker.memo is
'备注：memo';

/*==============================================================*/
/* Table: ss_person_docking                                     */
/*==============================================================*/
create table ss_person_docking (
   docking_id           SERIAL               not null,
   docking_name         VARCHAR(100)         null,
   access_time          TIMESTAMP            null,
   constraint PK_SS_PERSON_DOCKING primary key (docking_id)
);

comment on table ss_person_docking is
'特殊监控人员信息对接方式：ss_person_docking';

comment on column ss_person_docking.docking_id is
'对接方式ID：docking_id';

comment on column ss_person_docking.docking_name is
'对接方式名称：docking_name';

comment on column ss_person_docking.access_time is
'接入时间：access_time';

/*==============================================================*/
/* Table: ss_person_docking_parameter                           */
/*==============================================================*/
create table ss_person_docking_parameter (
   parameter_code       SERIAL               not null,
   docking_id           INT4                 null,
   parameter_name       VARCHAR(100)         null,
   parameter_en_name    VARCHAR(100)         null,
   constraint PK_SS_PERSON_DOCKING_PARAMETER primary key (parameter_code)
);

comment on table ss_person_docking_parameter is
'人员信息对接参数：ss_person_docking_parameter';

comment on column ss_person_docking_parameter.parameter_code is
'参数ID：parameter_code';

comment on column ss_person_docking_parameter.docking_id is
'对接方式ID：docking_id';

comment on column ss_person_docking_parameter.parameter_name is
'参数名称：parameter_name';

comment on column ss_person_docking_parameter.parameter_en_name is
'英文名称：parameter_en_name';

/*==============================================================*/
/* Table: ss_person_docking_value                               */
/*==============================================================*/
create table ss_person_docking_value (
   parameter_code       INT4                 null,
   group_id             INT4                 null,
   parameter_value      VARCHAR(1024)        null
);

comment on table ss_person_docking_value is
'人员信息对接参数值：ss_person_docking_value';

comment on column ss_person_docking_value.parameter_code is
'参数ID：parameter_code';

comment on column ss_person_docking_value.group_id is
'分组ID：group_id';

comment on column ss_person_docking_value.parameter_value is
'参数值：parameter_value';

alter table ss_group
   add constraint FK_GROUP_REF_DOCKING foreign key (docking_id)
      references ss_person_docking (docking_id)
      on delete cascade on update cascade;

alter table ss_person_docking_parameter
   add constraint FK_PARAMETER_REF_DOCKING foreign key (docking_id)
      references ss_person_docking (docking_id)
      on delete cascade on update cascade;

alter table ss_person_docking_value
   add constraint FK_VALUE_REF_GROUP foreign key (group_id)
      references ss_group (group_id)
      on delete cascade on update cascade;

alter table ss_person_docking_value
   add constraint FK_VALUE_REF_PARAMETER foreign key (parameter_code)
      references ss_person_docking_parameter (parameter_code)
      on delete cascade on update cascade;

