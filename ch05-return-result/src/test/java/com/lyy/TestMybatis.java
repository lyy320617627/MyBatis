package com.lyy;

import com.lyy.dao.StudentDao;
import com.lyy.domain.Student;
import com.lyy.utils.MyBatisUtils;
import com.lyy.vo.QueryParam;
import com.lyy.vo.ViewStudent;
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
    public void testSelectViewStudent(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        ViewStudent studentList = dao.ViewStudent( 1001);
        System.out.println("1001 student="+studentList);
        sqlSession.close();
    }
     @Test
    public void testSelectCount(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
         StudentDao dao = sqlSession.getMapper(StudentDao.class);
         int i = dao.selectCount();
         System.out.println("学生的总数量="+i);
     }
     /*
     返回map
     */
    @Test
    public void testSelectMap(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMapById(1001);

        System.out.println("map=="+map);
    }
    /*

    * */
    @Test
    public void testSelectAllStudent(){
        SqlSession sqlSession=MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> studentList = dao.selectAllStudents();
        for(Student stu:studentList){
        System.out.println("学生信息="+stu);

        }
    }
}
