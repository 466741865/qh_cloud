package com.qh.cloud.test.arithmetic.binarytree;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : TODO
 * @date : 2019/6/27 9:21
 **/
public class main {


    public static void main(String[] args) {






    }

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
