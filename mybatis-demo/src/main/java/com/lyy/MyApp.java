package com.lyy;

import com.lyy.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-10-30 18:15
 **/

public class MyApp {
    public static void main(String[] args) throws IOException {
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
        String sqlId="com.lyy.dao.StudentDao"+"."+"selectStudents";
        //7.执行sql语句，通过sqlId找到语句
        List<Student> studentList=sqlSession.selectList(sqlId);
        //8.输出结果
        studentList.forEach(stu -> System.out.println(stu));
        for (Student stu:studentList){
            System.out.println("查询的学生="+stu);
        }
       //关闭SqlSession对象
        sqlSession.close();
    }
}
