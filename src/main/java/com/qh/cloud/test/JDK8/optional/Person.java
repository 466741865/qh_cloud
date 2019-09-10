package com.qh.cloud.test.JDK8.optional;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/2/11 17:17
 **/
public class Person {

    private String  name;

    private int age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    //之前
    public static String getUserName(Person user){
        return user.getName();
    }

    public static int compareByAge(Person a,Person b){
        return a.name.compareTo(b.name);
    }
}
