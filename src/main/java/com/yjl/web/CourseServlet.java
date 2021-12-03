package com.yjl.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SimplePropertyPreFilter;
import com.yjl.base.BaseServlet;
import com.yjl.entity.CourseDO;
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


    /**
     * 查询课程信息
     *
     * @param request
     * @param response
     */
    public void listCourse(HttpServletRequest request, HttpServletResponse response) {
        //1、接受参数
        String name = request.getParameter("name");
        String status = request.getParameter("status");


        //2、业务处理
        List<CourseDO> courseDOList = courseService.listCourse(name, status);
        //使用SimplePropertyPreFilter指定转换的json字段
        SimplePropertyPreFilter filter = new SimplePropertyPreFilter(CourseDO.class, "id", "course_name", "price", "sort_num", "status");
        String result = JSON.toJSONString(courseDOList, filter);
        try {
            response.getWriter().println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
