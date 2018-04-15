package com.qh.cloud.test.thread;

/**
 * 
 * @Description  实现Runnable 接口  
 * @Date 2017年5月2日 下午4:07:06
 * @author QingHang
 * @version 1.0.0
 */
public class RunnableTest implements Runnable{

	
	int i = 0;
	
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("线程id："+Thread.currentThread().getId() +"   线程名称："+Thread.currentThread().getName()+"：：："+i);
		}
	}
	
	public static void main(String[] args) {
    	RunnableTest rtt = new RunnableTest();  
        new Thread(rtt,"新线程1").start();  
        new Thread(rtt,"新线程2").start();  
	}
	
	
	
}
