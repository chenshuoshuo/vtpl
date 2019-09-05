/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019-9-5 17:28:02                           */
/* Version:        3.1                                      */
/* Author:         CYG                                          */
/* Description:    删除校区四角坐标，支持多边形                     */
/*==============================================================*/

alter table location_campus_info drop column left_down_lng;

alter table location_campus_info drop column left_down_lat;

alter table location_campus_info drop column right_top_lng;

alter table location_campus_info drop column right_top_lat;

alter table location_campus_info
	add coordinates varchar ;
