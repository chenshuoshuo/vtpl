package com.you07.eas.dao;

import com.you07.common.BaseDao;
import com.you07.eas.model.TeacherInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherInfoDao extends BaseDao<TeacherInfo>{

    @Select({
            "select * from eas_teacherinfo"
    })
    @Results({
            @Result(column = "xsbmdm",
                    property = "departmentInfo",
                    one = @One(
                            select = "com.you07.eas.dao.DepartmentInfoDao.selectByPrimaryKey"
                    )
            )
    })
    List<TeacherInfo> listAll();

    @Select({
            "select * from eas_teacherinfo where teachercode = #{teacherCode}"
    })
    @Results({
            @Result(column = "xsbmdm",
                    property = "departmentInfo",
                    one = @One(
                            select = "com.you07.eas.dao.DepartmentInfoDao.selectByPrimaryKey"
                    )
            )
    })
    TeacherInfo loadByTeacherCode(@Param("teacherCode") String teacherCode);
}
