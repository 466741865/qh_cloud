package com.qh.cloud.test.thread.alternateoutput;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.concurrent.locks.LockSupport;

/**
 * 问题： 两个线程交替输出，一个输出数字，一个输出字母
 * 解法：使用LockSupport控制交替输出
 */
public class LockSupportDemo {


    private static String ci = "12345678";
    private static String cc = "ABCDEFGH";
    static Thread t1 = null ,t2 = null;

    public static void main(String[] args) {
        char[] ai = ci.toCharArray();
        char[] ac = cc.toCharArray();
        t1 = new Thread(() -> {
            for(char c : ai){
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(() -> {

            for(char c : ac){
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");



        t1.start();
        t2.start();
    }

}
