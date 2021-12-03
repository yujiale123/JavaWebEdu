package com.yjl.service.Impl;

import com.yjl.mapper.CourseMapper;
import com.yjl.mapper.Impl.CourseMapperImpl;
import com.yjl.pojo.Course;
import com.yjl.service.CourseService;

import java.util.List;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/03
 */
public class CourseServiceImpl implements CourseService {


    CourseMapper courseMapper = new CourseMapperImpl();

    /**
     * @return
     */
    @Override
    public List<Course> listCourse() {
        List<Course> courseList = courseMapper.listCourse();
        return courseList;
    }
}
