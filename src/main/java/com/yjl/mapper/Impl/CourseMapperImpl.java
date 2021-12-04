package com.yjl.mapper.Impl;

import com.yjl.entity.CourseDO;
import com.yjl.mapper.CourseMapper;
import com.yjl.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/03
 */
public class CourseMapperImpl implements CourseMapper {
    /**
     * 查询课程列表信息
     *
     * @return
     */
    @Override
    public List<CourseDO> listCourse(String courseName, String status) {
        //1、创建QueryRunner方法
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        //2、编写sql
        StringBuffer stringBuffer = new StringBuffer("SELECT id,course_name,price,sort_num,STATUS FROM course WHERE 1=1 and is_del = ? ");
        //创建List集合保存参数
        ArrayList<Object> list = new ArrayList<>(2);
        list.add(0);
        // 判断传入的参数是否为空
        if (null != courseName && !courseName.equals("")) {
            stringBuffer.append(" and course_name like  ?");
            courseName = "%" + courseName + "%";
            list.add(courseName);
        }
        if (null != status && !status.equals("")) {
            stringBuffer.append(" and status =  ?");
            int i = Integer.parseInt(status);
            list.add(i);
        }
        //3、执行sql
        List<CourseDO> courseDOList = null;
        try {
            courseDOList = queryRunner.query(stringBuffer.toString(), new BeanListHandler<CourseDO>(CourseDO.class), list.toArray());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseDOList;
    }

    /**
     * 保存课程信息
     *
     * @param course
     * @return
     */
    @Override
    public Integer saveCourse(CourseDO course) {
        //1.创建QueryRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        //2.编写SQL
        String sql = "INSERT INTO course(\n" +
                "course_name,\n" +
                "brief,\n" +
                "teacher_name,\n" +
                "teacher_info,\n" +
                "preview_first_field,\n" +
                "preview_second_field,\n" +
                "discounts,\n" +
                "price,\n" +
                "price_tag,\n" +
                "share_image_title,\n" +
                "share_title,\n" +
                "share_description,\n" +
                "course_description,\n" +
                "course_img_url,\n" +
                "STATUS,\n" +
                "create_time,\n" +
                "update_time\n" +
                ")VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        //3.准备参数
        Object[] param = {course.getCourse_name(), course.getBrief(), course.getTeacher_name(), course.getTeacher_info(),
                course.getPreview_first_field(), course.getPreview_second_field(), course.getDiscounts(), course.getPrice(),
                course.getPrice_tag(), course.getShare_image_title(), course.getShare_title(), course.getShare_description(),
                course.getCourse_description(), course.getCourse_img_url(), course.getStatus(), course.getCreate_time(), course.getUpdate_time()};

        //4.执行插入操作
        int row = 0;
        try {

            row = qr.update(sql, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;

    }

    /**
     * 根据id查询课程信息
     *
     * @param id
     * @return
     */
    @Override
    public CourseDO getCourseById(Integer id) {
        CourseDO courseDO = new CourseDO();
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "SELECT \n" +
                "id,\n" +
                "course_name,\n" +
                "brief,\n" +
                "teacher_name,\n" +
                "teacher_info,\n" +
                "preview_first_field,\n" +
                "preview_second_field,\n" +
                "discounts,\n" +
                "price,\n" +
                "price_tag,\n" +
                "course_img_url,\n" +
                "share_image_title,\n" +
                "share_title,\n" +
                "share_description,\n" +
                "course_description,\n" +
                "STATUS\n" +
                "FROM course WHERE id = ?";
        try {
            courseDO = qr.query(sql, new BeanHandler<CourseDO>(CourseDO.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            courseDO = null;
        }
        return courseDO;
    }

    /**
     * 修改课程状态
     *
     * @param course
     * @return
     */
    @Override
    public Integer updateStatusById(CourseDO course) {
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        String sql = "UPDATE course SET STATUS = ? ,update_time = ? WHERE id = ?";
        Object[] param = {course.getStatus(), course.getUpdate_time(), course.getId()};
        Integer row = 0;
        try {
            row = queryRunner.update(sql, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return row;
    }


}
