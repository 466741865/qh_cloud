package com.qh.cloud.test.thread.test;

/**
 * @Description 线程的交替输出
 * @Date 2017年10月20日 上午9:49:01
 * @author QingHang
 * @version 1.0.0
 */
public class Demo1 {

	public static void main(String[] args) {
		aAndBDemo();
	}

	public static void aAndBDemo() {
		Thread threadA = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread threadB = new Thread(new Runnable() {
			@Override
			public void run() {
				printNumber("B");
			}
		});

		// Thread threadC = new Thread(new Runnable() {
		// @Override
		// public void run() {
		// printNumber("C");
		// }
		// });

		threadA.start();
		threadB.start();
		// threadC.start();
	}

	public static void printNumber(String threadName) {
		int n = 0;
		while (n++ < 3) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(threadName + "threadName" + "    " + n);
			System.out.println();
		}
	}
}
