package com.yjl.mapper;

import com.yjl.entity.CourseDO;

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
    List<CourseDO> listCourse(String courseName,String status) ;

    /**
     * 保存课程信息
     * @param course
     * @return
     */
    Integer saveCourse(CourseDO course);

    CourseDO getCourseById(Integer id);

    Integer updateStatusById(CourseDO course);
}
