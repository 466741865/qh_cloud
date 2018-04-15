package com.qh.cloud.test.thread.AsyncFuture;

/**
 * @Description 测试1的结果
 * @Date 2018年3月28日 下午2:48:21
 * @author QingHang
 * @version 1.0.0
 */
public class Test1Runnable implements Runnable {

	private String name;

	private Test1 test;

	public Test1Runnable(Test1 test1, String threadName) {
		this.test = test1;
		this.name = threadName;
	}

	@Override
	public void run() {
		// 通知线程调用者run方法执行结果
		Test1.receiveFileStr(name, Thread.currentThread().getName());
	}
}
