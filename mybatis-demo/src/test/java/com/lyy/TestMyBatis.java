package com.lyy;

import com.lyy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-30 20:48
 **/

public class TestMyBatis {
    //测试方法，测试我们的功能
    @Test
    public void testInsert() throws IOException {
        //访问mubatis读取student数据
        //1.定义一个mybatis主配置文件的名称
        String config="mybatis.xml";
        //2.读取这个config表示的文件
        InputStream in= Resources.getResourceAsStream(config);
        //3.创建了SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        //4.创建SqlSessionFactory对象
        SqlSessionFactory factory=builder.build(in);
        //5.【重要】 获取SqlSession对象，从SqlSessionFactory中获取SqlSession
        SqlSession sqlSession=factory.openSession();
        //6.【重要】指定要执行的sql语句的标识。sql映射文件中的namespace+"."
        String sqlId="com.lyy.dao.StudentDao"+"."+"insertStudent";
        //7.执行sql语句，通过sqlId找到语句
        Student student=new Student();
        student.setId(1004);
        student.setName("朱珂");
        student.setEmail("zmk@163.com");
        student.setAge(20);
        int numbers=sqlSession.insert(sqlId,student);
        //mybatis默认是不提交事务的。所以在insert，update，delete后，需要手工提交事务
        sqlSession.commit();
        //8.输出结果
        System.out.println("执行insert结果："+numbers);
        //关闭SqlSession对象
        sqlSession.close();
    }
/*    @Test
    public void testINsert() throws IOException {
        String config="mybatis.xml";
        InputStream in=Resources.getResourceAsStream(config);
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        SqlSession sqlSession=factory.openSession();
        String sqlId="com.lyy.dao.StudentDao.insertStudent";
        Student student=new Student();
//        ...
        sqlSession.insert()

    }*/
    }

