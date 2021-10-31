package com.lyy.dao;

import com.lyy.domain.Student;

import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:03
 **/

public interface StudentDao {
    List<Student> selectStudents();
    int insertStudent(Student student);
}
