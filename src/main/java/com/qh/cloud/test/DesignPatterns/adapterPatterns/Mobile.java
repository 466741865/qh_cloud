package com.qh.cloud.test.DesignPatterns.adapterPatterns;

/**
 * @Description 适配器模式： 客户端，，
 * @Date 2018年3月13日 下午4:23:38
 * @author QingHang
 * @version 1.0.0
 */
public class Mobile {

	// 充电
	public void charging(Voltage5 voltage5) {
		if (voltage5.output5V() == 5) {
			System.out.println("电压符合，开始充电");
		} else {
			System.out.println("电压不符，不能充电");
		}
	}
}
