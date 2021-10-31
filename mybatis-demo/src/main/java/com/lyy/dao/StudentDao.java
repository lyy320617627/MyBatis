package com.lyy.dao;

import com.lyy.domain.Student;

import java.util.List;

public interface StudentDao {
    //查询student表的所有的数据
    public List<Student> selectStudents();
//    插入方法

    /**
     *
     * @param student:表示要插入到数据库的数据
     * @return 表示执行insert操作后，影响数据库的行数
     */
    public int insertStudent(Student student);
}
