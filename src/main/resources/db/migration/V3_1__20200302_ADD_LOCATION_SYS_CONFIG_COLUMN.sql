/*==============================================================*/
/* Description:  运行配置增加疫情监控图标、是否开启人员对接参数                            */
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2020/3/2 11:15:09                            */
/*==============================================================*/

alter table location_system_config
   add epidemic_monitoring_icon varchar(255) null;
comment on column location_system_config.epidemic_monitoring_icon is '疫情监控图标';

alter table location_system_config
   add docking_open bool null;
comment on column location_system_config.docking_open is '是否开启人员对接参数';

