package com.qh.cloud.test.DesignPatterns.SingletonPatterns;

/**
 * @Description 单利模式 -- 懒汉式 （会有线程安全问题）
 * @Date 2017年8月3日 下午3:34:56
 * @author QingHang
 * @version 1.0.0
 */
public class LazySingleton {

	private LazySingleton() {
	}

	private static LazySingleton lazySingleton = null;

	// 此方法有 线程安全隐患
	public static LazySingleton getInstance() {
		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	// 解决方案
	// 1、同步
	public static synchronized LazySingleton getInstance1() {

		if (lazySingleton == null) {
			lazySingleton = new LazySingleton();
		}
		return lazySingleton;
	}

	// 2、双重检查锁定
	public static LazySingleton getInstance2() {
		if (lazySingleton == null) {
			synchronized (LazySingleton.class) {
				if (lazySingleton == null) {
					lazySingleton = new LazySingleton();
				}
			}
		}
		return lazySingleton;
	}

	// 3、静态内部类
	private static class LazyHolder {
		private static final LazySingleton INSTANCE = new LazySingleton();
	}

	public static final LazySingleton getInstance3() {
		return LazyHolder.INSTANCE;
	}

}
