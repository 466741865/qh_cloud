package com.qh.cloud.test.concurrent.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 测试线程C
 * @Date 2017年10月17日 上午11:20:30
 * @author QingHang
 * @version 1.0.0
 */
public class TestC extends BaseThreadUtils {

	public TestC(CountDownLatch latch) {
		super("Test C", latch);
	}

	@Override
	public void verifyService() {
		System.out.println("checking   " + this.getServiceName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(this.getServiceName() + "is up");
	}

}
