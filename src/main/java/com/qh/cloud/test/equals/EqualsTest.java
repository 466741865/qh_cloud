package com.qh.cloud.test.equals;

/**
 * @Description equals测试
 * @Date 2017年9月17日 下午6:56:24
 * @author QingHang
 * @version 1.0.0
 */
public class EqualsTest {

	public static void main(String[] args) {
		OverRideEquals overRideEquals = new OverRideEquals("aa");
		System.out.println(overRideEquals.equals("bb"));
	}

}
