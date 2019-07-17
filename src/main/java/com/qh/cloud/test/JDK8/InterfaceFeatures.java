package com.qh.cloud.test.JDK8;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/3/4 20:34
 **/
public interface InterfaceFeatures {

    default void NotAbstractMethod(){
        System.out.println("=======我是默认方法=======");
    }

     int  add();
    static void staticMethod(){

    }

}


class  aaaa implements InterfaceFeatures{

    @Override
    public int add() {
        return 0;
    }
}
