package com.qh.cloud.test.thread;

/**
 * @Description 线程 test 继承Thread类
 * @Date 2017年5月2日 下午4:00:45
 * @author QingHang
 * @version 1.0.0
 */
public class ThreadTest extends Thread {

	int i = 0;

	/**
	 * 重写run方法
	 */
	@Override
	public void run() {
		while (true) {
			if (!isInterrupted()) {
				System.out.println("线程id：" + getId() + "   线程名称：" + getName() + "：：：" + i);
			}
		}
	}

	public static void main(String[] args) {
		ThreadTest thread1 = new ThreadTest();
		thread1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread1.interrupt();// 线程中断

	}

}
