package com.qh.cloud.test.thread.test;

/**
 * @Description 实现两个线程交替输出
 * @Date 2017年10月20日 下午3:04:00
 * @author QingHang
 * @version 1.0.0
 */
public class test {

	public static void main(String[] args) {
		test();
	}

	public static void test() {
		Object object = new Object();
		new Thread(new Runnable() {

			@Override
			public void run() {
				synchronized (object) {
					int i = 0;
					while (i++ < 10) {
						System.out.println("testA  在工作       " + i);
						try {
							object.notify();
							object.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				int i = 0;
				synchronized (object) {
					while (i++ < 10) {
						System.out.println("testB  正在工作          " + i);
						try {
							object.notify();
							object.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}

}
