package com.lyy.dao;

import com.lyy.domain.Student;
import com.lyy.vo.QueryParam;
import com.lyy.vo.ViewStudent;
import javafx.beans.binding.ObjectExpression;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:03
 **/

public interface StudentDao {

     public Student selectStudentById(Integer id);
     List<Student> selectMulitParam(@Param("myname") String name, @Param("myage")Integer age);
      ViewStudent ViewStudent(@Param("sid") Integer id);
      int selectCount();
      //定义方法返回map
    Map<Object, Object> selectMapById(Integer id);
    /*
    使用resultMap定义映射关系
     */
     List<Student> selectAllStudents();
}
