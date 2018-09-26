/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-8-27 09:35:18                           */
/* Version:        1.5                                          */
/* Author:         RY                                           */
/* Description:    用户信息追加属性                             */
/*==============================================================*/


ALTER TABLE location_trajectory_manager
ADD COLUMN org_codes text,
ADD COLUMN org_names text;

COMMENT ON COLUMN location_trajectory_manager.org_codes IS '权限机构ID：org_codes';

COMMENT ON COLUMN location_trajectory_manager.org_names IS '权限机构名称：org_names';