package com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness;

/**
 * @Description 简单工厂
 * @Date 2018年2月11日 下午5:38:59
 * @author QingHang
 * @version 1.0.0
 */
public class SimplenessFactory {

	public static Car production(String carType) {

		Car car = null;
		if (carType.equals("benz")) {
			car = new Benz();
		} else if (carType.equals("bwm")) {
			car = new Bwm();
		}
		return car;
	}
}
