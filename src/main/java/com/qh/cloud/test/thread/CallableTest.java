package com.qh.cloud.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.context.annotation.PropertySource;

/**
 * @Description 通过Callable和Future创建线程
 * @Date 2017年5月2日 下午5:22:11
 * @author QingHang
 * @version 1.0.0
 */
@PropertySource("classpath:properties/config.properties")
public class CallableTest implements Callable<Integer> {

	public int result = 10;

	public CallableTest(int result) {
		this.result = result;
	}

	/**
	 * 线程执行体
	 */
	@Override
	public Integer call() throws Exception {
		// 需要执行的 代码块
		System.out.println("这是要执行的代码块：：" + result);
		return result;
	}

	public static void main(String[] args) {
		// 创建一个 缓存线程池，大小没有限制
		ExecutorService threadPoolTaskExecutor = Executors.newCachedThreadPool();
		Future<Integer> future = null;
		try {
			for (int i = 1; i <= 5; i++) {
				CallableTest ctt = new CallableTest(i);
				future = threadPoolTaskExecutor.submit(ctt);
				Integer integer = future.get();
				System.out.println("线程返回的额结果：:::::::::" + integer);
			}

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
