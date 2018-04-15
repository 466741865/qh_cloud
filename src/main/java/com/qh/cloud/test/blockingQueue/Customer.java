package com.qh.cloud.test.blockingQueue;

/**
 * @Description 阻塞队列 消费者
 * @Date 2018年2月23日 上午9:58:04
 * @author QingHang
 * @version 1.0.0
 */
public class Customer implements Runnable {

	private BlockQueue queue;

	public Customer(BlockQueue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			Object result = queue.get();
			System.out.println("Thread Name :" + Thread.currentThread().getName() + " get ：" + result);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("获取 对象出现异常。");
		}

	}

}
