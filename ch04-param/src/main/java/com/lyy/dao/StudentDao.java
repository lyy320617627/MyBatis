package com.lyy.dao;

import com.lyy.domain.Student;
import com.lyy.vo.QueryParam;
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
     /**
      * 一个简单类型的参数：
      * 简单类型：mybatis把java的基本数据类型和String都叫做简单数据类型
      * 在mapper文件获取简单类型的一个参数的值，使用#{任意字符}
      */
     public Student selectStudentById(Integer id);
     /**
      * 多个参数：命名参数，在形参定义的1前面，加入@Param("自定义参数名称")
      */
     List<Student> selectMulitParam(@Param("myname") String name, @Param("myage")Integer age);
     /**
      * 多个参数，使用java对象作为接口中方法的参数
      *
      */
     List<Student> selectMulitObject(QueryParam param);
     /**
      * 多个参数--简单类型：按位置传值
      * mybatis3.4之前，使用#{0}，#{1}表示，版本3.4之后使用#{arg0}，#{arg1}
      */
     List<Student> selectMulitPosition(String name,Integer age);
     /**
      * 多个参数，使用mapper存放多个值
      */
     List<Student> selectMulitByMap(Map<String,Object> map);
     List<Student> selectUse$order(@Param("colName") String colName);

}
