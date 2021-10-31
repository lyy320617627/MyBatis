package com.lyy;

import com.lyy.dao.StudentDao;
import com.lyy.domain.Student;
import com.lyy.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
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
        /**
         * 使用mybatis的动态代理机制，使用SqlSession.getMapper(dao接口)
         * getMapper能够获取dao接口对应的实现类对象.
         */
        SqlSession sqlSession= MyBatisUtils.getSqlSession();
        StudentDao dao=sqlSession.getMapper(StudentDao.class);
        //调用dao的方法，执行数据库的操作
        List<Student> students=dao.selectStudents();
        for (Student stu:students){
            System.out.println("学生="+stu);
        }

    }

}
