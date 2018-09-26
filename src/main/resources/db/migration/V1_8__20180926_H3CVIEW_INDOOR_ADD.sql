/*==============================================================*/
/* DBMS name:      PostgreSQL 9.x                               */
/* Created on:     2018-9-26 19:56:26                           */
/* Version:        1.8                                          */
/* Author:         RY                                           */
/* Description:    华三视图信息追加室内室外属性                 */
/*==============================================================*/

ALTER TABLE location_h3c_view
ADD COLUMN in_door int4 DEFAULT 1;

COMMENT ON COLUMN location_h3c_view.in_door IS '室内/室外，1室内，2室外';