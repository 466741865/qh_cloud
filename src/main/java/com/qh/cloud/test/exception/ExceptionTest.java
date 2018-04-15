package com.qh.cloud.test.exception;

/**
 * @Description 异常测试类
 * @Date 2017年9月26日 下午3:58:50
 * @author QingHang
 * @version 1.0.0
 */
public class ExceptionTest {

	public void test1() {

		System.out.println("==========");

		int i = 1 / 0;
		System.out.println("------------");
	}

	public void test2() {

		System.out.println("+++++++++");

		throw new RuntimeException();

		// System.out.println("```````````");

	}

}
