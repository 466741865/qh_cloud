package com.qh.cloud.test.JDK8;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/3/4 20:40
 **/

@RequestMapping
public class Person {



    private int age;


    private String name;


    public int getSex() {
        return age;
    }

    public void setSex(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isMaxAge(int age1,int age2){
        return age1 >= age2;
    }
}
