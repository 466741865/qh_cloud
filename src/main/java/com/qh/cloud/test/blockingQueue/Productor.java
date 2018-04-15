package com.qh.cloud.test.blockingQueue;

/**
 * @Description 阻塞队列生产者
 * @Date 2018年2月23日 上午9:55:00
 * @author QingHang
 * @version 1.0.0
 */
public class Productor implements Runnable {

	private BlockQueue queue;

	private int sequence;

	public Productor(BlockQueue queue, int sequence) {
		this.queue = queue;
		this.sequence = sequence;
	}

	@Override
	public void run() {
		try {
			System.out.println("Thread Name：" + Thread.currentThread().getName() + " put ：" + sequence);
			queue.put(queue);
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("存入阻塞队列。");
		}
	}

}
