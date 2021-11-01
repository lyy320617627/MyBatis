package com.lyy;

import com.lyy.dao.StudentDao;
import com.lyy.domain.Student;
import com.lyy.utils.MyBatisUtils;
import com.lyy.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:40
 **/

public class TestMybatis {
    @Test
    public void testSelectStudentById(){

        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1001);
        System.out.println(student);
    }
     @Test
    public void testSelectMulitParam(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
         List<Student> studentList = dao.selectMulitParam("李四", 20);
         for (Student stu:studentList){
             System.out.println("学生="+stu);
         }
         sqlSession.close();
     }
     @Test
    public void testSelectMulitObject(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
         QueryParam queryParam=new QueryParam();
         queryParam.setParamName("张三");
         queryParam.setParamAge(20);
         List<Student> studentList = dao.selectMulitObject(queryParam);
         for (Student stu:studentList){
             System.out.println("学生的信息="+stu);
         }
     }
     @Test
    public void testSelectMulitPosition(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
         List<Student> studentList = dao.selectMulitPosition("李四", 20);
         for (Student stu:studentList){
             System.out.println("查询到的学生信息="+stu);
         }
     }
     @Test
    public void testSelectMulitByMap(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
         StudentDao dao = sqlSession.getMapper(StudentDao.class);
         Map<String,Object> map=new HashMap<>();
         map.put("myname","张三");
         map.put("myage",20);
         List<Student> studentList = dao.selectMulitByMap(map);
         for (Student student:studentList){
             System.out.println("查询的学生信息="+student);
         }
     }
     @Test
    public void testSelectUser$order(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
         StudentDao dao = sqlSession.getMapper(StudentDao.class);
         List<Student> studentList = dao.selectUse$order("name");
         for (Student student:studentList){
             System.out.println("学生的信息="+student);
         }
         sqlSession.close();

     }
}
