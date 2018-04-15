package com.qh.cloud.test.DesignPatterns.adapterPatterns;

/**
 * @Description 适配器模式 ： 220v电压
 * @Date 2018年3月13日 下午4:15:53
 * @author QingHang
 * @version 1.0.0
 */
public class Voltage220 {

	public int output220() {
		int src = 220;
		System.out.println("这是 " + src + " V");
		return src;
	}
}
