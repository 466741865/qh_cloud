package com.qh.cloud.test.DesignPatterns.adapterPatterns;

/**
 * @Description 类适配器模式： 电压 适配器
 * @Date 2018年3月13日 下午4:19:02
 * @author QingHang
 * @version 1.0.0
 */
public class VoltageAdapter extends Voltage220 implements Voltage5 {

	@Override
	public int output5V() {
		int src = output220();
		System.out.println("适配器开始工作适配电压");
		int dst = src / 44;
		System.out.println("适配完成 ，输出电压：：" + dst);
		return dst;
	}
}
