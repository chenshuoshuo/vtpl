/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-8-22 20:08:44                           */
/* Version:        1.3                                          */
/* Author:         RY                                           */
/* Description:    校区信息追加高德坐标                         */
/*==============================================================*/


ALTER TABLE "public"."location_campus_info"
ADD COLUMN "amap_lng_lat" varchar(64);

COMMENT ON COLUMN "public"."location_campus_info"."amap_lng_lat" IS '校区坐标（高德）：amap_lng_lat';
