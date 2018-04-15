package com.qh.cloud.test.DesignPatterns.SingletonPatterns;

/**
 * @Description 单例模式 -- 饿汉式 （不会有线程安全问题）
 * @Date 2017年8月3日 下午3:17:16
 * @author QingHang
 * @version 1.0.0
 */
public class EagerSingleton {

	private static final EagerSingleton eagerSingleton = new EagerSingleton();

	private EagerSingleton() {
	}

	// 静态工厂
	public static EagerSingleton getInstance() {
		return eagerSingleton;
	}

}
