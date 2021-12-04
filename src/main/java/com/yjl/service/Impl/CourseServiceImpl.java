package com.yjl.service.Impl;

import com.yjl.base.StatusCode;
import com.yjl.entity.CourseDO;
import com.yjl.mapper.CourseMapper;
import com.yjl.mapper.Impl.CourseMapperImpl;
import com.yjl.service.CourseService;
import com.yjl.utils.DateUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return courseMapper.getCourseById(id);
    }

    @Override
    public Map<String, Integer> updateStatusById(CourseDO course) {

        Integer row = courseMapper.updateStatusById(course);
        Map<String, Integer> map = new HashMap<>(1);

        if (row > 0) {
            if (course.getStatus() == 0) {
                map.put("status", 0);
            } else {
                map.put("status", 1);
            }
        }

        return map;
    }
}
