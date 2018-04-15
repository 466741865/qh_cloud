package com.qh.cloud.test.thread.demo;

/**
 * @Description 简单的线程池接口
 * @Date 2018年2月10日 下午4:30:19
 * @author QingHang
 * @version 1.0.0
 * @param <Job>
 */
public interface MyThreadPool<Job extends Runnable> {

	// 执行一个任务（job） ，这个任务必须实现Runnable
	void execute(Job job);

	// 关闭线程池
	void shutdown();

	// 增加工作者线程，即用来执行任务的线程
	void addWorkers(int num);

	// 减少工作者线程，
	void removeWorkers(int num);

	// 获取正在等待的任务数
	int getJobSize();
}
