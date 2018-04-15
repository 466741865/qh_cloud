package com.qh.cloud.test.DesignPatterns.FactoryPatterns.method;

import com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness.Benz;
import com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness.Car;

/**
 * @Description Benz具体工厂
 * @Date 2018年2月11日 下午5:55:00
 * @author QingHang
 * @version 1.0.0
 */
public class BenzDriver extends Driver {

	@Override
	public Car driverCar() {
		return new Benz();
	}

}
