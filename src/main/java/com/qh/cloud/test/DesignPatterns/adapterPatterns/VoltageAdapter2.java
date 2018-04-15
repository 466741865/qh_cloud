package com.qh.cloud.test.DesignPatterns.adapterPatterns;

/**
 * @Description 对象适配器模式： 适配器
 * @Date 2018年3月13日 下午4:43:55
 * @author QingHang
 * @version 1.0.0
 */
public class VoltageAdapter2 implements Voltage5 {

	private Voltage220 voltage220;

	public VoltageAdapter2(Voltage220 voltage220) {
		this.voltage220 = voltage220;
	}

	@Override
	public int output5V() {
		int dst = 0;
		if (null != voltage220) {
			int src = voltage220.output220();
			System.out.println("对象适配器开始工作");
			dst = src / 44;
			System.out.println("对象适配器适配后的电压：" + dst);
		}
		return dst;
	}

}
