package com.qh.cloud.test.DesignPatterns.adapterPatterns;

/**
 * @Description 适配器模式：测试类
 * @Date 2018年3月13日 下午4:26:00
 * @author QingHang
 * @version 1.0.0
 */
public class AdapterTest {

	public static void main(String[] args) {
		// classAdapter();
		objectAdatper();
	}

	/**
	 * 类适配器测试
	 */
	public static void classAdapter() {
		System.out.println("=========类适配器========");
		Mobile mobile = new Mobile();
		mobile.charging(new VoltageAdapter());
	}

	/**
	 * 对象适配器测试
	 */
	public static void objectAdatper() {
		System.out.println("==========对象适配器=============");
		VoltageAdapter2 voltageAdapter2 = new VoltageAdapter2(new Voltage220());
		Mobile mobile = new Mobile();
		mobile.charging(voltageAdapter2);

	}

}
