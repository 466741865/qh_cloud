package com.qh.cloud.test.blockingQueue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description 阻塞队列实现
 * @Date 2018年2月23日 上午9:56:54
 * @author QingHang
 * @version 1.0.0
 */
public class BlockQueue {

	// 队列，先进先出
	private Object[] queue;

	// get锁 注：ReentrantLock 是一个可重入互斥锁，功能类似于synchronized ，功能比其强大
	private static ReentrantLock getLock = new ReentrantLock();

	// put 锁
	private static ReentrantLock putLock = new ReentrantLock();

	// 是否可以get条件
	private static Condition notEmpty = getLock.newCondition();

	// 是否可以put条件
	private static Condition notFull = putLock.newCondition();

	// 队列容量
	private final int capacity;

	// get位置
	private AtomicInteger getIndex = new AtomicInteger(0);

	// put 的位置
	private AtomicInteger putIndex = new AtomicInteger(0);

	// 队列中元素个数
	private AtomicInteger count = new AtomicInteger(0);

	public BlockQueue(int capacity) {
		this.capacity = capacity;
		this.queue = new Object[capacity];
	}

	/**
	 * @Description 入队
	 * @param object
	 * @throws InterruptedException
	 */
	public void put(Object object) throws InterruptedException {
		// 获取put锁
		putLock.lockInterruptibly();
		try {
			// 若队列已满，则阻塞当前线程
			while (count.get() == capacity) {
				notFull.await();
			}
			// 获取put的位置，放入对象
			int index = putIndex.getAndIncrement();
			queue[index] = object;

			// 判断是否达到队列 尾端，是则从头开始
			if ((index + 1) == capacity) {
				putIndex.set(0);
			}

			// 队列个数 +1，+1前队列为空，+1后唤醒阻塞的get线程
			if (count.getAndIncrement() < 1) {
				signalNotEmpty();
			}
		} finally {
			putLock.unlock();
		}

	}

	/**
	 * @Description 出队
	 * @return
	 * @throws InterruptedException
	 */
	public Object get() throws InterruptedException {
		// 获得get锁
		getLock.lockInterruptibly();

		try {
			// 当前队列为空 ，则阻塞当前线程
			while (count.get() < 1) {
				notEmpty.await();
			}
			// 获得get对象的位置，拿取对象
			int index = getIndex.getAndIncrement();
			Object result = queue[index];
			queue[index] = null;

			// 达到队尾，从头开始
			if ((index + 1) == capacity) {
				getIndex.set(0);
			}

			// 队列对象个数 -1,-1 前队列已满，-1后唤醒阻塞队列put线程
			if (count.getAndDecrement() == capacity) {
				notFull.signalAll();
			}
			return result;
		} finally {
			// 释放锁
			getLock.unlock();
		}
	}

	/**
	 * @Description 唤醒 get线程
	 */
	private static void signalNotEmpty() {
		getLock.lock();
		try {
			notEmpty.signal();
		} finally {
			getLock.unlock();
		}
	}

	/**
	 * @Description 唤醒put线程
	 */
	private static void signalNotFull() {
		putLock.lock();
		try {
			notFull.signal();
		} finally {
			putLock.unlock();
		}
	}

}
