package com.lyy.vo;

/**
 * @program: mybatis-course
 * @description:
 * @author: ly
 * @create: 2021-11-01 18:54
 **/

public class ViewStudent {
    private String name;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ViewStudent{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
