package com.yjl.service.Impl;

import com.yjl.base.StatusCode;
import com.yjl.entity.CourseDO;
import com.yjl.mapper.CourseMapper;
import com.yjl.mapper.Impl.CourseMapperImpl;
import com.yjl.service.CourseService;
import com.yjl.utils.DateUtils;

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
    public List<CourseDO> listCourse(String courseName, String status) {
        List<CourseDO> courseDOList = courseMapper.listCourse(courseName, status);
        return courseDOList;
    }

    @Override
    public String saveCourse(CourseDO course) {
        String dateFormat = DateUtils.getDateFormat();
        course.setCreate_time(dateFormat);
        course.setUpdate_time(dateFormat);
        course.setStatus(1);
        Integer integer = courseMapper.saveCourse(course);
        String result = "";
        if (integer > 0) {
            result = StatusCode.SUCCESS.toString();
        } else {
            result = StatusCode.ERROR.toString();
        }
        return result;
    }

    @Override
    public CourseDO getCourseById(Integer id) {
        courseMapper.getCourseById(id);

        return null;
    }
}
