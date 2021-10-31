package com.lyy.dao.impl;

import com.lyy.dao.StudentDao;
import com.lyy.domain.Student;
import com.lyy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-31 14:31
 **/

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
        //获取SqlSession对象
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlId="com.lyy.dao.StudentDao"+"."+"selectStudents";
        //执行sql语句，使用SqlSession类的方法
        List<Student> students = sqlSession.selectList(sqlId);
        //关闭
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //获取SqlSession对象
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        String sqlId="com.lyy.dao.StudentDao"+"."+"insertStudent";
        //执行sql语句，使用SqlSession类的方法
        int insert = sqlSession.insert(sqlId,student);
        //提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
        return insert;
    }
}
