package com.lyy.dao;

import com.lyy.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询student表的所有的数据
    public List<Student> selectStudents();
}
