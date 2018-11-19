/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-11-14 14:02:03                           */
/* Version:        2.0                                         */
/* Author:         ZJ                                           */
/* Description:    location_latest添加account_id属性                            */
/*==============================================================*/

ALTER TABLE location_latest
ADD COLUMN account_id varchar(64) ;

COMMENT ON COLUMN location_latest.account_id IS '上网账号';

