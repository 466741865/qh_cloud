package com.qh.cloud.test.arithmetic;

/**
 * @author : QingHang
 * @version 1.0
 * @Description : 递归
 * @date : 2019/11/5 11:17
 **/
public class RecursionSort {


    public static void main(String[] args) {

        int num1 = stepNum(3);
        System.out.println("========n级台阶的走法："+num1);

    }


    /**
     * 有一个n级台阶，一步只能走一个台阶、或两个台阶，走到顶共有多少种走法
     *
     * @return
     */
    public static int stepNum(int n){

        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        return stepNum(n-1)+ stepNum(n - 2);
    }



}
