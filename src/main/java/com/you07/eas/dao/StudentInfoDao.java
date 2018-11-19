package com.you07.eas.dao;

import com.you07.common.BaseDao;
import com.you07.eas.model.StudentInfo;
import com.you07.util.DateUtils;
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

    @Select({
            "select s.* from eas_studentinfo s,eas_classinfo c,eas_major m where " +
                    "s.classcode=c.classcode and c.major_code=m.major_code " +
                    "and " +
                    "(TO_NUMBER( c.grade, '9999' ) + TO_NUMBER( m.major_last, '9999' )) >  #{schoolYear}"
    })
    @Results({
            @Result(column = "classcode",
                    property = "classInfo",
                    one = @One(
                            select = "com.you07.eas.dao.ClassInfoDao.selectByPrimaryKey"
                    )
            )
    })
    List<StudentInfo> getInSchool(@Param("schoolYear") Integer schoolYear);
}
