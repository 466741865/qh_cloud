package com.qh.cloud.test.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Description CountDownLatch 实现 线程等待
 * @Date 2018年3月28日 上午11:47:00
 * @author QingHang
 * @version 1.0.0
 */
public class ThreadWait {

	public static void main(String[] args) throws InterruptedException {
		int threadNum = 10;
		final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
		System.out.println("主线程开始等待");

		for (int i = 0; i < threadNum; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("子线程 ： " + Thread.currentThread().getName());
					countDownLatch.countDown();
				}
			}).start();
		}

		countDownLatch.await();
		System.out.println("主线程等待结束，开始执行");

	}
}
