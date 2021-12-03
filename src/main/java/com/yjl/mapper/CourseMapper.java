package com.yjl.mapper;

import com.yjl.entity.CourseDO;

import java.sql.SQLException;
import java.util.List;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/03
 */
public interface CourseMapper {
    /**
     * 查询课程列表
     *
     * @return
     */
    List<CourseDO> listCourse() throws SQLException;
}
