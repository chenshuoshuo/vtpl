/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019-9-9 9:44:00                           */
/* Version:        3.0.0.2                                      */
/* Author:         CYG                                          */
/* Description:    系统配置添加gis地图token和ips接口地址                     */
/*==============================================================*/

alter table location_system_config
    add gis_map_token varchar(255);

comment on column location_system_config.gis_map_token is 'gis3.0地图token';

alter table location_system_config
    add ips_api varchar(255);

comment on column location_system_config.ips_api is 'CMIPS-M接口';

