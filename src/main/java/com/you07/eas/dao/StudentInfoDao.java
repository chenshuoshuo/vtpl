package com.you07.eas.dao;

import com.you07.common.BaseDao;
import com.you07.eas.model.StudentInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoDao extends BaseDao<StudentInfo>{

    @Select({
            "select * from eas_studentinfo"
    })
    @Results({
            @Result(column = "classcode",
                    property = "classInfo",
                    one = @One(
                            select = "com.you07.eas.dao.ClassInfoDao.selectByPrimaryKey"
                    )
            )
    })
    List<StudentInfo> listAll();

    @Select({
            "select * from eas_studentinfo where studentno = #{studentNo}"
    })
    @Results({
            @Result(column = "classcode",
                    property = "classInfo",
                    one = @One(
                            select = "com.you07.eas.dao.ClassInfoDao.selectByPrimaryKey"
                    )
            )
    })
    StudentInfo loadByStudentNo(@Param("studentNo") String studentNo);
}
