package com.qh.cloud.test.DesignPatterns.FactoryPatterns.abstractFactory;

/**
 * @Description 具体工厂2 生产2类产品
 * @Date 2018年2月12日 上午10:58:18
 * @author QingHang
 * @version 1.0.0
 */
public class ConcreteFactory2 extends AbstractFactory {

	// 生产 A类 2产品
	@Override
	AbstractProductA createProductA() {
		return new ProductA2();
	}

	// 生产 B类 2产品
	@Override
	AbstractProductB createProductB() {
		return new ProductB2();
	}

}
