package com.qh.cloud.test.thread.test;

import java.util.concurrent.CountDownLatch;

/**
 * @Description CountdownLatch 的用法
 * @Date 2017年10月20日 上午11:50:46
 * @author QingHang
 * @version 1.0.0
 */
public class Demo4 {

	public static void main(String[] args) {
		int worker = 3;
		CountDownLatch latch = new CountDownLatch(worker);
		demo4(latch);
		demo41(latch);

	}

	public static void demo4(CountDownLatch latch) {

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("A 等待着 其他线程 执行");

				try {
					latch.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("A 等待结束，开始工作");
			}
		}).start();
	}

	public static void demo41(CountDownLatch latch) {
		for (char i = 'A'; i < 'D'; i++) {
			final String string = String.valueOf(i);
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println(string + " 开始工作");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(string + "完成=====");
					latch.countDown();
				}
			}).start();
		}
	}

}
