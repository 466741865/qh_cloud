package com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness;

/**
 * @Description 具体产品类
 * @Date 2018年2月11日 下午5:37:04
 * @author QingHang
 * @version 1.0.0
 */
public class Bwm implements Car {

	@Override
	public void running() {
		System.out.println("这是  宝马");
	}

}
