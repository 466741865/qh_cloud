package com.qh.cloud.test.thread.AsyncFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @Description 获取多线程执行结果
 * @Date 2018年3月28日 下午3:04:28
 * @author QingHang
 * @version 1.0.0
 */
public class Test2 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("-====== start========");

		int taskSize = 20;
		// 线程池
		ExecutorService service = Executors.newCachedThreadPool();

		// 创建多个有返回值的任务
		List<Future> list = new ArrayList<>();

		for (int i = 0; i < taskSize; i++) {
			Test2Callable callable = new Test2Callable("线程 " + i);
			// 执行任务并获取Future对象
			Future<Object> future = service.submit(callable);
			list.add(future);
		}
		// 关闭线程池
		service.shutdown();

		System.out.println("开始获取线程结果");
		for (Future f : list) {
			System.out.println(f.get().toString());
		}
		System.out.println("==============end===============");
	}

}
