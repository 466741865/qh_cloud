package com.qh.cloud.test.thread.test;

/**
 * @Description 线程wait notify的用法
 * @Date 2017年10月20日 上午11:01:26
 * @author QingHang
 * @version 1.0.0
 */
public class Demo3 {

	public static void main(String[] args) {
		demo3();
	}

	public static void demo3() {

		Object object = new Object();

		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (object) {
					System.out.println("A 1");
					try {
						object.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println("A 3");
				System.out.println("A 2");
			}

		});

		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (object) {
					System.out.println("B 1");
					System.out.println("B 2");
					System.out.println("B 3");
					object.notify();

				}
			}
		});

		threadA.start();
		threadB.start();
	}

}
