/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2019-12-5 18:46:15                           */
/* Description:    1.一卡通设备、使用记录增加设备状态           */
/* Description:    2.为location_latest增加修改前定位时间检测    */
/*==============================================================*/

--一卡通设备表增加设备状态
alter table location_ecard_device
  add column device_status varchar(64);

comment on column location_ecard_device.device_status is '设备状态：device_status';

--一卡通使用记录表增加设备状态
alter table location_ecard_use_record
  add column device_status varchar(64);

comment on column location_ecard_use_record.device_status is '设备状态：device_status';

--创建定位时间检测函数
create or replace function update_location_check()
  returns trigger as $body$
begin
  if OLD.location_time is not null and NEW.location_time is not null and NEW.location_time < OLD.location_time then
    return null;
  else return NEW;
  end if;
end;
$body$
  language plpgsql volatile;

comment on function update_location_check() is '位置更新定位时间检查函数';

--为location_latest创建触发器
CREATE TRIGGER update_location_check_trigger BEFORE UPDATE OF location_time ON location_latest
  FOR EACH ROW
EXECUTE PROCEDURE update_location_check();
