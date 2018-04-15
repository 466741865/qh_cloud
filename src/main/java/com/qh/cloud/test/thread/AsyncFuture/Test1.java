package com.qh.cloud.test.thread.AsyncFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description 异步获取执行结果 ： 使用回调
 * @Date 2018年3月28日 下午2:47:40
 * @author QingHang
 * @version 1.0.0
 */
public class Test1 {

	public static void main(String[] args) {
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5));

		for (int i = 0; i < 10; i++) {
			Test1Runnable runnable = new Test1Runnable(new Test1(), "线程  ：" + i);
			executor.execute(runnable);
			// System.out.println("执行第 "+i+" 个的 当前时间："+DateUtils.getCurrentDateTime());
			System.out.println("线程池中的线程数目：" + executor.getPoolSize() + "  队列中等待的数目： " + executor.getQueue().size()
					+ " 已执行完的任务数目：" + executor.getCompletedTaskCount());
		}

		executor.shutdown();
	}

	public static void receiveFileStr(String fileName, String readStr) {
		StringBuffer sb = new StringBuffer();
		sb.append(fileName + ":" + readStr);
		System.out.println(sb.toString());
	}
}
