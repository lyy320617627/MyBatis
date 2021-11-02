package com.lyy;


import com.lyy.dao.StudentDao;
import com.lyy.domain.Student;
import com.lyy.utils.MyBatisUtils;
import jdk.nashorn.internal.runtime.linker.LinkerCallSite;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:40
 **/

public class TestMybatis {
    @Test
    public void testselectStudentIf(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> studentList = dao.selectStudentIf(student);
        for (Student stu:studentList){
            System.out.println("if==="+stu);
        }
    }
    @Test
    public void testselectStudentWhere(){
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student=new Student();
        student.setName("李四");
        student.setAge(20);
        List<Student> studentList = dao.selectStudentWhere(student);
        for (Student stu:studentList){
            System.out.println("if==="+stu);
        }
    }
    @Test
    public void testForEach(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Integer> list=new ArrayList<>();
        list.add(1001);
        list.add(1002);
        list.add(1003);
        List<Student> students=dao.selectForeachOne(list);
        for (Student stu:students){
            System.out.println("forOne=="+stu);
        }
    }
    @Test
    public void testForEachTwo(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        List<Student> students=new ArrayList<Student>();
        Student s1 = new Student();
        s1.setId(1001);
        students.add(s1);
        s1=new Student();
        s1.setId(1005);
        students.add(s1);
        List<Student> studentList = dao.selectForeachTwo(students);
        for (Student stu:students){
            System.out.println("forTwo=="+stu);
        }
    }
}
