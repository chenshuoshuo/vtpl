/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-8-27 09:35:18                           */
/* Version:        1.5                                          */
/* Author:         RY                                           */
/* Description:    校区信息追加属性                             */
/*==============================================================*/

ALTER TABLE location_campus_info
ADD COLUMN is_display int4 DEFAULT 1;

COMMENT ON COLUMN location_campus_info.is_display IS '是否显示校区：is_display,1是,0否';

