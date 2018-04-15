package com.qh.cloud.test.blockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description 阻塞队列测试
 * @Date 2018年2月23日 下午2:07:02
 * @author QingHang
 * @version 1.0.0
 */
public class Test {

	public static void main(String[] args) {
		BlockQueue blockQueue = new BlockQueue(10);
		ExecutorService service = Executors.newFixedThreadPool(20);
		for (int i = 0; i < 10; i++) {
			Customer customer = new Customer(blockQueue);
			Productor productor = new Productor(blockQueue, i);
			service.execute(customer);
			service.execute(productor);
		}

		service.shutdown();

	}
}
