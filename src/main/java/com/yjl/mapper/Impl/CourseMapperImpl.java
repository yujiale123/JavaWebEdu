package com.yjl.mapper.Impl;

import com.yjl.mapper.CourseMapper;
import com.yjl.entity.CourseDO;
import com.yjl.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
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
    public List<CourseDO> listCourse() {
        //1、创建QueryRunner方法
        QueryRunner queryRunner = new QueryRunner(DruidUtils.getDataSource());
        //2、编写sql
        String sql = "select * from course where is_del = ?";
        //3、执行sql
        List<CourseDO> courseDOList = null;
        try {
            courseDOList = queryRunner.query(sql, new BeanListHandler<CourseDO>(CourseDO.class), 0);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return courseDOList;
    }
}
