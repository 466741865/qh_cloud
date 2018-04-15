package com.qh.cloud.test.thread.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class DefaultThreadPool<Job extends Runnable> implements MyThreadPool<Job> {

	// 线程池维护工作者线程的最大数量
	private static final int MAX_WORKER_NUMBERS = 10;

	// 线程池维护工作者线程的默认值
	private static final int DEFAULT_WORKER_NUMBERS = 5;

	// 线程池维护工作者线程的最小数量
	private static final int MIN_WORKER_NUMBERS = 1;

	// 维护一个工作列表，里面加入客户端发起的工作
	private final LinkedList<Job> jobs = new LinkedList<>();

	// 工作者线程的列表
	private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

	// 工作者线程的数量
	private int workerNum;

	// 每个工作者线程编号生成
	private AtomicLong threadNum = new AtomicLong();

	public DefaultThreadPool() {
		this.workerNum = DEFAULT_WORKER_NUMBERS;
		initializeWorkers(this.workerNum);
	}

	public DefaultThreadPool(int num) {
		if (num > MAX_WORKER_NUMBERS) {
			this.workerNum = DEFAULT_WORKER_NUMBERS;
		} else {
			this.workerNum = num;
		}
		initializeWorkers(this.workerNum);
	}

	// 初始化每个工作者线程
	private void initializeWorkers(int num) {
		System.out.println("初始化工作者线程数：：" + num);
		for (int i = 0; i < num; i++) {
			Worker worker = new Worker();
			// 添加到工作者线程的列表
			workers.add(worker);
			// 启动工作者线程
			Thread thread = new Thread(worker);
			thread.start();
		}
	}

	@Override
	public void execute(Job job) {
		if (job != null) {
			// 根据线程的等待/通知机制 这里必须对jobs 加锁
			synchronized (jobs) {
				System.out.println("执行job ，新增到jobs队列中：：" + job.getClass().getName());
				jobs.addLast(job);
				jobs.notify();
			}
		}
	}

	// 关闭线程池 即关闭每个工作者线程
	@Override
	public void shutdown() {
		System.out.println("关闭工作者线程，，工作者线程数量： " + workers.size());
		for (Worker w : workers) {
			w.shutdown();
		}
	}

	// 增加工作者线程
	@Override
	public void addWorkers(int num) {
		// 加锁，即防止该线程还么增加完成，而下一个线程继续增加导致工作这线程超过最大值。

		synchronized (jobs) {
			if (num + this.workerNum > MAX_WORKER_NUMBERS) {
				num = MAX_WORKER_NUMBERS - this.workerNum;
			}
			initializeWorkers(num);
			this.workerNum += num;
		}
	}

	// 减少工作者线程
	@Override
	public void removeWorkers(int num) {
		synchronized (jobs) {
			if (num >= this.workerNum) {
				throw new IllegalArgumentException("超过了已有的线程数量");
			}
			for (int i = 0; i < num; i++) {
				Worker worker = workers.get(i);
				if (worker != null) {
					// 关闭该线程 ，并从列表中移除
					worker.shutdown();
					workers.remove(i);
				}
			}
			this.workerNum -= num;
		}
	}

	@Override
	public int getJobSize() {
		return workers.size();

	}

	// 定义工作者线程
	class Worker implements Runnable {

		// 表示 是否运行该worker
		private volatile boolean running = true;

		@Override
		public void run() {
			while (running) {
				Job job = null;
				// 线程的等待/通知机制
				synchronized (jobs) {

					// 若为空
					if (jobs.isEmpty()) {
						try {
							System.out.println("jobs 开始等待");
							jobs.wait();// 线程等待唤醒
						} catch (InterruptedException e) {
							// 感知到外部对该线程的中断操作，返回
							System.out.println("出现异常，执行：interrupt");
							Thread.currentThread().interrupt();
							return;
						}
					}

					// 否则 ，取一个job
					job = jobs.removeFirst();// 移除第一个
					System.out.println("取出队列中的第一个线程： " + job.getClass().getName());
				}
				if (job != null) {
					System.out.println("运行 线程：： " + job.getClass().getName());
					job.run();
				}
			}
		}

		// 终止线程
		public void shutdown() {
			running = false;
		}

	}

}
