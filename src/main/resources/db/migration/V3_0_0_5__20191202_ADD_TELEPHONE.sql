/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019/11/6 19:54:44                           */
/* Description:    用户信息添加电话号码                            */
/*==============================================================*/

alter table location_latest
	add if not exists telephone varchar(64);

comment on column location_latest.telephone is '电话号码';

alter table location_history_year
	add if not exists telephone varchar(64);

comment on column location_history_year.telephone is '电话号码';

alter table location_history_month
	add if not exists telephone varchar(64);

comment on column location_history_month.telephone is '电话号码';

alter table location_history_day
	add if not exists telephone varchar(64);

comment on column location_history_day.telephone is '电话号码';