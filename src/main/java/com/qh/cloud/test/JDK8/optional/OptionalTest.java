package com.qh.cloud.test.JDK8.optional;

import java.util.Optional;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/2/12 17:20
 **/
public class OptionalTest {


    public static void main(String[] args) {


        //创建一个空的Optional对象
        Optional<Person> person1 = Optional.empty();

        //创建一个非空值的Optional
        Person p = new Person();
        Optional<Person> person2 = Optional.ofNullable(p);

        //创建一个允许空值的Optional
        Person pp = null;
        Optional<Person> person3 =  Optional.ofNullable(pp);

    }

    //之前的
    public String getPersonName(Person person){
        if(person != null){
            return person.getName();
        }
        return null;
    }

    //现在
    public String getPersonName2(Person person){
        Optional<String> name = Optional.ofNullable(person).map(Person::getName);
        return name.orElse(null);
    }


}
