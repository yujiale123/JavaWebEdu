package com.yjl.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: JavaWeb-Edu
 * @author: yjl
 * @created: 2021/12/02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseSection implements Serializable {
    //课程章节id
    @JSONField(ordinal = 1)
    private int id;

    //课程id
    @JSONField(ordinal = 2)
    private int course_id;

    //章节名
    @JSONField(ordinal = 3)
    private String section_name;

    //章节描述
    @JSONField(ordinal = 4)
    private String description;

    //排序
    @JSONField(ordinal = 5)
    private long order_num;

    //章节状态，0:隐藏；1：待更新；2：已发布
    @JSONField(ordinal = 6)
    private long status;

    //创建时间
    @JSONField(ordinal = 7)
    private String create_time;

    //修改时间
    @JSONField(ordinal = 8)
    private String update_time;

    //是否删除 0-未删除，1-已删除
    @JSONField(ordinal = 9)
    private int isDel;

    @Override
    public String toString() {
        return "Course_Section{" +
                "id=" + id +
                ", course_id=" + course_id +
                ", section_name='" + section_name + '\'' +
                ", description='" + description + '\'' +
                ", order_num=" + order_num +
                ", status=" + status +
                ", create_time='" + create_time + '\'' +
                ", update_time='" + update_time + '\'' +
                ", isDel=" + isDel +
                '}';
    }

    @JSONField(serialize = false)
    private int last_operator_id; //最后操作者ID
    @JSONField(serialize = false)
    private int is_visible; //是否可见
    @JSONField(serialize = false)
    private String last_operator; //最后操作者
}
