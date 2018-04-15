package com.qh.cloud.test.DesignPatterns.FactoryPatterns.abstractFactory;

/**
 * @Description 获取工厂的类
 * @Date 2018年2月12日 上午11:00:18
 * @author QingHang
 * @version 1.0.0
 */
public class FactoryMaker {

	private static AbstractFactory pf = null;

	// 根据需求获取不同的工厂
	static AbstractFactory getFactory(String choice) {
		if (choice.equals("a")) {
			pf = new ConcreteFactory1();
		} else if (choice.equals("b")) {
			pf = new ConcreteFactory2();
		}
		return pf;
	}

}
