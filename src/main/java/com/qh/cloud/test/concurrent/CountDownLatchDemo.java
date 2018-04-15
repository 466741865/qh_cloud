package com.qh.cloud.test.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.qh.cloud.test.concurrent.threads.BaseThreadUtils;
import com.qh.cloud.test.concurrent.threads.TestA;
import com.qh.cloud.test.concurrent.threads.TestB;
import com.qh.cloud.test.concurrent.threads.TestC;

/**
 * @Description java并发包下的 CountDownLatch
 * @Date 2017年10月17日 上午11:05:55
 * @author QingHang
 * @version 1.0.0
 */
public class CountDownLatchDemo {

	public static void main(String[] args) {
		checkExternalServices();
	}

	public static void checkExternalServices() {

		CountDownLatch latch = new CountDownLatch(3);
		List<BaseThreadUtils> serices = new ArrayList<>();
		serices.add(new TestA(latch));
		serices.add(new TestB(latch));
		serices.add(new TestC(latch));

		// 创建线程池 开启线程
		ExecutorService executors = Executors.newFixedThreadPool(serices.size());
		for (BaseThreadUtils thread : serices) {
			executors.execute(thread);
		}
		System.out.println("子线程已开启");
		// 让主线程等待，等待其余线程全部执行完，
		try {
			System.out.println("主线程开始等待");
			latch.await();
			System.out.println("主线程等待结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("继续执行操作");
	}
}
