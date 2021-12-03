package com.yjl.service.Impl;

import com.yjl.mapper.CourseMapper;
import com.yjl.mapper.Impl.CourseMapperImpl;
import com.yjl.entity.CourseDO;
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
    public List<CourseDO> listCourse(String name,String status) {
        List<CourseDO> courseDOList = courseMapper.listCourse(name,status);
        return courseDOList;
    }
}
