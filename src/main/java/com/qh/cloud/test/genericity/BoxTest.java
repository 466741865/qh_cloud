package com.qh.cloud.test.genericity;

/**
 * @Description 泛型 测试 ，，泛型类
 * @Date 2017年7月13日 上午11:00:41
 * @author QingHang
 * @version 1.0.0
 */
public class BoxTest<T> {

	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

}
