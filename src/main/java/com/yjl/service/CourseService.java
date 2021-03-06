package com.yjl.service;

import com.yjl.entity.CourseDO;

import java.util.List;
import java.util.Map;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/03
 */
public interface CourseService {
    /**
     * 查询课程列表
     *
     * @return
     */
    public List<CourseDO> listCourse(String courseName,String status);

    String saveCourse(CourseDO course);

    CourseDO getCourseById(Integer id);

    Map<String, Integer> updateStatusById(CourseDO course);
}
