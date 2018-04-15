package com.qh.cloud.test.concurrent.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @Description 基础线程
 * @Date 2017年10月17日 上午11:09:39
 * @author QingHang
 * @version 1.0.0
 */
public abstract class BaseThreadUtils implements Runnable {

	private CountDownLatch latch;

	private String serviceName;

	private boolean serviceUp;

	public BaseThreadUtils(String serviceName, CountDownLatch latch) {
		super();
		this.latch = latch;
		this.serviceName = serviceName;
		this.serviceUp = false;
	}

	@Override
	public void run() {
		try {
			verifyService();
			serviceUp = true;

		} catch (Exception e) {
			e.getMessage();
			serviceUp = false;
		} finally {
			if (latch != null) {
				latch.countDown();
			}
		}
	}

	// This methos needs to be implemented by all specific service checker
	public abstract void verifyService();

	public String getServiceName() {
		return serviceName;
	}

	public boolean isServiceUp() {
		return serviceUp;
	}

}
