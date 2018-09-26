/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-8-22 20:08:44                           */
/* Version:        1.4                                          */
/* Author:         RY                                           */
/* Description:    系统配置追加属性                             */
/*==============================================================*/

ALTER TABLE location_system_config
ADD COLUMN top_bg_color varchar(16),
ADD COLUMN right_top_bg_color varchar(16),
ADD COLUMN right_bottom_bg_color varchar(16),
ADD COLUMN logo varchar(255),
ADD COLUMN water_mark_logo varchar(255),
ADD COLUMN gate_img varchar(255),
ADD COLUMN track_icon varchar(255),
ADD COLUMN location_icon varchar(255),
ADD COLUMN safety_icon varchar(255),
ADD COLUMN campus_switch_icon varchar(255),
ADD COLUMN contact varchar(255);

COMMENT ON COLUMN location_system_config.top_bg_color IS '系统top背景色：top_bg_color';

COMMENT ON COLUMN location_system_config.right_top_bg_color IS '右侧背景上部：right_top_bg_color';

COMMENT ON COLUMN location_system_config.right_bottom_bg_color IS '右侧背景色下部：right_bottom_bg_color';

COMMENT ON COLUMN location_system_config.logo IS '系统LOGO：logo';

COMMENT ON COLUMN location_system_config.water_mark_logo IS '水印LOGO：water_mark_logo';

COMMENT ON COLUMN location_system_config.gate_img IS '校门风景图：gate_img';

COMMENT ON COLUMN location_system_config.track_icon IS '轨迹查询应用图标：track_icon';

COMMENT ON COLUMN location_system_config.location_icon IS '位置查询应用图标：location_icon';

COMMENT ON COLUMN location_system_config.safety_icon IS '安全管理应用图标：safety_icon';

COMMENT ON COLUMN location_system_config.campus_switch_icon IS '校区切换图标：campus_switch_icon';

COMMENT ON COLUMN location_system_config.contact IS '权限分配联系人：contact';

