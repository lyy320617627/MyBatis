package com.lyy;

import com.lyy.dao.StudentDao;
import com.lyy.dao.impl.StudentDaoImpl;
import com.lyy.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:40
 **/

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        StudentDao dao=new StudentDaoImpl();
        List<Student> studentList= dao.selectStudents();
        /**
         *List<Student> studentList= dao.selectStudents();
         * 1.dao对象，类型是StudentDao，全限定名称：com.lyy.dao.StudentDao
         * 全限定名称：namespace是一样的
         * 2：方法名称，selectStudents：这个方法名称就是mapper文件中的id值
         * 3.通过dao中方法的返回值也可以确定Mybatis要调用的SqlSession的方法
         * 吐过返回值是list，调用的是SqlSession.selectList()方法
         * 吐过返回值是int，或是非list，看mapper文件中的标签 是<insert><update>就会调用SqlSession的insert方法，update等方法
         *mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息
         * mbatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象
         * 完成SqlSession调用方法，访问数据库
         *
         */
        for (Student stu:studentList){
            System.out.println(stu);
        }
    }
    @Test
    public void TestInsert(){
        StudentDao dao=new StudentDaoImpl();
        Student student=new Student();
        student.setAge(18);
        student.setName("lyy");
        student.setId(1008);
        student.setEmail("ly320@163.com");
        int i = dao.insertStudent(student);
        System.out.println(i);
    }
}
