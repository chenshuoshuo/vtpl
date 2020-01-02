/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2020-1-7 11:46:15                            */
/* Description:    1.位置记录表添加民族、专业、班级、生源地字段      */
/*==============================================================*/

-- 添加班级字段
alter table location_history_day
    add if not exists class_code varchar(64);

comment on column location_history_day.class_code is '班级代码';

alter table location_history_month
    add if not exists class_code varchar(64);

comment on column location_history_month.class_code is '班级代码';

alter table location_history_year
    add if not exists class_code varchar(64);

comment on column location_history_year.class_code is '班级代码';

alter table location_latest
    add if not exists class_code varchar(64);

comment on column location_latest.class_code is '班级代码';

-- 添加专业字段
alter table location_history_day
    add if not exists major_code varchar(64);

comment on column location_history_day.major_code is '专业代码';

alter table location_history_month
    add if not exists major_code varchar(64);

comment on column location_history_month.major_code is '专业代码';

alter table location_history_year
    add if not exists major_code varchar(64);

comment on column location_history_year.major_code is '专业代码';

alter table location_latest
    add if not exists major_code varchar(64);

comment on column location_latest.major_code is '专业代码';

-- 添加民族字段
alter table location_history_day
    add if not exists nation varchar(64);

comment on column location_history_day.nation is '民族';

alter table location_history_month
    add if not exists nation varchar(64);

comment on column location_history_month.nation is '民族';

alter table location_history_year
    add if not exists nation varchar(64);

comment on column location_history_year.nation is '民族';

alter table location_latest
    add if not exists nation varchar(64);

comment on column location_latest.nation is '民族';

-- 添加生源地字段
alter table location_history_day
    add if not exists birthplace varchar(64);

comment on column location_history_day.birthplace is '生源地';

alter table location_history_month
    add if not exists birthplace varchar(64);

comment on column location_history_month.birthplace is '生源地';

alter table location_history_year
    add if not exists birthplace varchar(64);

comment on column location_history_year.birthplace is '生源地';

alter table location_latest
    add if not exists birthplace varchar(64);

comment on column location_latest.birthplace is '生源地';