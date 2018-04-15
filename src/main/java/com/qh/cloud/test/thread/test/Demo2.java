package com.qh.cloud.test.thread.test;

/**
 * @Description A线程等待 B执行完后 再执行 ,,join 的用法
 * @Date 2017年10月20日 上午10:29:39
 * @author QingHang
 * @version 1.0.0
 */
public class Demo2 {

	public static void main(String[] args) {
		demo2();
	}

	public static void demo2() {
		Thread threadA = new Thread(new Runnable() {

			@Override
			public void run() {
				printNumber("A");
			}
		});

		Thread threadB = new Thread(new Runnable() {

			@Override
			public void run() {

				System.out.println("B  开始等待  A  执行结束");
				try {
					threadA.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				printNumber("B");
			}
		});

		threadA.start();
		threadB.start();
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
