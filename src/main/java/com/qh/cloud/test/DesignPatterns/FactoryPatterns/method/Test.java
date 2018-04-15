package com.qh.cloud.test.DesignPatterns.FactoryPatterns.method;

import com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness.Car;

public class Test {

	public static void main(String[] args) {

		// 生产benz
		Driver driver = new BenzDriver();
		Car car = driver.driverCar();
		car.running();

		// 生产Bwm
		Driver driver1 = new BwmDriver();
		Car car1 = driver1.driverCar();
		car1.running();
	}
}
