package com.qh.cloud.test.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.qh.cloud.utils.DateUtils;

/**
 * 
 * @Description 线程池的使用
 * @Date 2017年5月3日 上午10:58:36
 * @author QingHang
 * @version 1.0.0
 */
public class ThreadPoolExecutorTest {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<Runnable>(5));
		
		for (int i = 0; i < 20; i++) {
			MyThread myThread = new MyThread(i);
			executor.execute(myThread);
//			System.out.println("执行第 "+i+" 个的 当前时间："+DateUtils.getCurrentDateTime());
			System.out.println("线程池中的线程数目："+executor.getPoolSize() +"  队列中等待的数目： "+
			executor.getQueue().size()+" 已执行完的任务数目："+executor.getCompletedTaskCount());
		}
		
		executor.shutdown();
		
	}
	
	
	

}



//任务线程
class MyThread implements Runnable{

	private int tastNum;
	
	public MyThread(int tastNum){
		this.tastNum = tastNum;
	}
	
	@Override
	public void run() {
		System.out.println("正在执行tast: "+tastNum+"  开始时间："+DateUtils.getCurrentDateTime());
		
		try {
			Thread.currentThread().sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("tast  "+tastNum+"  执行完毕"+"  结束时间："+DateUtils.getCurrentDateTime());
	}
	
}
