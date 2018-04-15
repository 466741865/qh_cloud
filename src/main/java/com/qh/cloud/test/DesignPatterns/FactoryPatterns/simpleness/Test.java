package com.qh.cloud.test.DesignPatterns.FactoryPatterns.simpleness;

public class Test {

	public static void main(String[] args) {
		Car car = SimplenessFactory.production("benz");
		car.running();
	}
}
