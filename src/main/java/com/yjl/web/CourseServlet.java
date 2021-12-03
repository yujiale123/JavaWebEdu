package com.yjl.web;

import com.alibaba.fastjson.JSON;
import com.yjl.base.BaseServlet;
import com.yjl.pojo.Course;
import com.yjl.service.CourseService;
import com.yjl.service.Impl.CourseServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/03
 */
@WebServlet("/course")
public class CourseServlet extends BaseServlet {


    CourseService courseService = new CourseServiceImpl();


    public void listCourse(HttpServletRequest request, HttpServletResponse response) {
        //1、接受参数

        //2、业务处理
        List<Course> courseList = courseService.listCourse();
        String result = JSON.toJSONString(courseList);
        try {
            response.getWriter().println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
