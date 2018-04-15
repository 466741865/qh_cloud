package com.qh.cloud.test.DesignPatterns.FactoryPatterns.method;

import com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness.Bwm;
import com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness.Car;

/**
 * @Description bwm具体工厂
 * @Date 2018年2月12日 上午9:59:08
 * @author QingHang
 * @version 1.0.0
 */
public class BwmDriver extends Driver {

	@Override
	public Car driverCar() {
		return new Bwm();
	}

}
