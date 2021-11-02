package com.lyy.dao;


import com.lyy.domain.Student;

import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:03
 **/

public interface OrderDao {
    //动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);
    //where的使用
    List<Student> selectStudentWhere(Student student);
    //foreach的用法1
    List<Student> selectForeachOne(List<Integer> idlist);
    //foreach的用法2
    List<Student> selectForeachTwo(List<Student> stulist);
}
