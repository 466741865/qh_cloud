package com.qh.cloud.test.JDK8;

import java.util.*;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/3/5 19:27
 **/
public class MethodReferenceTest {


    public static void main(String[] args) {

        Person [] persons = new Person[10];


        List<String> list1 = new ArrayList<>();
        list1.add("4");
        list1.add("2");
        list1.add("6");
        list1.add("1");


        //使用匿名类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        //方法引用几种类型

        //1、静态方法引用      组成语法格式：ClassName::staticMethodName
        String ss = "lqh";
        //使用lambda表达式
        Arrays.sort(persons, (o1, o2) -> o1.getName().compareTo(o2.getName()));


        //2、对象方法引用     .实例上的实例方法引用
        String[] stringsArray = {"Hello","World"};

     //使用lambda表达式和类型对象的实例方法
        Arrays.sort(stringsArray,(s1,s2)->s1.compareToIgnoreCase(s2));

     //引用的是类型对象的实例方法
        Arrays.sort(stringsArray, String::compareToIgnoreCase);


        //3、构造方法引用      组成语法格式：Class::new


    }


}


