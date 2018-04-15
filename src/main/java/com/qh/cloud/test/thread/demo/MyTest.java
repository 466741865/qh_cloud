package com.qh.cloud.test.thread.demo;

public class MyTest {

	public static void main(String[] args) {

		MyThreadPool<Runnable> pool = new DefaultThreadPool<>(6);

		pool.execute(new Runnable() {
			@Override
			public void run() {
				System.out.println("执行线程。lqh。。");
			}
		});
	}
}
