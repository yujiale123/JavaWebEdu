package com.yjl.mapper.Impl;

import com.yjl.mapper.CourseMapper;
import com.yjl.entity.CourseDO;
import com.yjl.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
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

        StringBuffer stringBuffer = new StringBuffer("select * from course where 1=1 and is_del = ?");
        //创建List集合保存参数

        ArrayList<Object> list = new ArrayList<>(2);
        list.add(0);


        // 判断传入的参数是否为空
        if (null != courseName) {
            stringBuffer.append(" and course_name like  ?");
            courseName = "%" + courseName + "%";
            list.add(courseName);
        }
        if (null != status) {
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
}
