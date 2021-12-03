package com.yjl.service;

import com.yjl.entity.CourseDO;

import java.util.List;

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
    public List<CourseDO> listCourse(String name,String status);
}
