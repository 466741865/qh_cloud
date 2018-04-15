package com.qh.cloud.test.thread.AsyncFuture;

import java.util.concurrent.Callable;

/**
 * @Description 多线程执行
 * @Date 2018年3月28日 下午3:08:47
 * @author QingHang
 * @version 1.0.0
 */
public class Test2Callable implements Callable<Object> {

	private String threadName;

	public Test2Callable(String threadName) {
		this.threadName = threadName;
	}

	@Override
	public Object call() throws Exception {
		System.out.println(threadName + " 开始执行");
		Thread.sleep(2000);
		System.out.println(threadName + " 执行完成");
		return threadName + "执行结果";
	}
}
