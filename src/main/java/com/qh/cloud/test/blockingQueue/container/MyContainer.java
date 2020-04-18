package com.qh.cloud.test.blockingQueue.container;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author QingHang
 * @Description : TODO
 * @Date 2020/4/11 21:50
 * @Version 1.0
 */
public class MyContainer<T> {

    final private LinkedList<T> list = new LinkedList<>();
    final private int max = 10;

    private int count = 0;

    private Lock lock = new ReentrantLock();
    private Condition producer = lock.newCondition();
    private Condition consumer = lock.newCondition();

    public void put(T t){
        try{
            lock.lock();
            while (list.size() == max){
                System.out.println("队列满了，等待："+t);
                producer.await();
            }
            System.out.println("生产："+t);
            list.add(t);
            count++;

            consumer.signal();
        }catch (Exception e){
            System.out.println("异常"+e);
        }finally {
            lock.unlock();
        }
    }

    public T get(){
        T t = null;
        try {

            lock.lock();

            while(list.size() == 0){
                System.out.println("队列空了，等待");
                consumer.await();
            }
            t = list.removeFirst();
            --count;
            System.out.println("消费："+t);
            producer.signal();

        }catch (Exception e){
            System.out.println("异常"+e);
        }finally {
            lock.unlock();
        }

        return t;

    }


    public static void main(String[] args) {
        MyContainer<String> mc = new MyContainer<>();
        //消费者
        for(int i = 0 ; i< 10; i++){

            new Thread(() ->{

                for(int j = 0; j < 5 ;j++){
                    System.out.println(mc.get());
                }
            },"c"+i).start();
        }


        try{
            TimeUnit.SECONDS.sleep(2);
        }catch (Exception e){
            e.printStackTrace();
        }


        for(int i = 0 ; i < 2; i++){
            new Thread(() -> {
                for(int j = 0 ; j < 25 ;j++ ){
                    mc.put(Thread.currentThread().getName()+j);
                }
            },"p"+i).start();
        }



    }


}
