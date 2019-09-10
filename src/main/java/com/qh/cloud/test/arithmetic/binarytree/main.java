package com.qh.cloud.test.arithmetic.binarytree;

import com.qh.cloud.utils.DateBuilder;

import java.util.Date;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/6/27 9:21
 **/
public class main {


    public static void main(String[] args) {

        String dayStr = "2019-07-25";
        Date nowDate = DateBuilder.convertStringToDate(dayStr);
        String dayStr1 = "2019-07-24";
        Date nowDate1 = DateBuilder.convertStringToDate(dayStr1);
        System.out.println(nowDate.after(nowDate1));



    }

    //折半查找
    public static Node search(int num , Node node){

        if(node == null){
            return null;
        }

        if(num == node.getDate()){
            return node;
        }else if(num < node.getDate()){

            return search(num,node.getLeftNode());

        }else if(num > node.getDate()){

            return search(num,node.getRigheNode());
        }
        return null;
    }



}
