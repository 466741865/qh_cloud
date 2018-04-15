package com.qh.cloud.test.common.pool.test1;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class test1 {
	public static void main(String[] args) throws Exception {
		// 实例化配置类
		MyPoolConfig myPoolConfig = new MyPoolConfig();
		// 设置最大工作人数
		myPoolConfig.setMaxTotal(3);
		myPoolConfig.setBlockWhenExhausted(true);// 当资源耗尽时，是否阻塞等待获取资源
		myPoolConfig.setMaxWaitMillis(7000);// 获取资源时的等待时间，单位毫秒
		// new 一个对象池。
		PersonFactory factory = new PersonFactory();
		GenericObjectPool<Person> personPool = new GenericObjectPool<>(factory, myPoolConfig);

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(5000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(6000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(8000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(10000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(12000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(new Runnable() {
			@Override
			public void run() {
				Person p;
				try {
					p = personPool.borrowObject();
					System.out.println("线程：" + Thread.currentThread().getName() + " 获取到对象:" + p.toString() + "，并开始工作");
					p.work();
					Thread.sleep(14000);
					personPool.returnObject(p);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();
	}
}
