package com.qh.cloud.test.DesignPatterns.FactoryPatterns.abstractFactory;

/**
 * @Description 具体工厂1 生产1类产品
 * @Date 2018年2月12日 上午10:56:01
 * @author QingHang
 * @version 1.0.0
 */
public class ConcreteFactory1 extends AbstractFactory {

	// 生产A类1产品
	@Override
	public AbstractProductA createProductA() {
		return new ProductA1();
	}

	// 生产B类1产品
	@Override
	public AbstractProductB createProductB() {
		return new ProductB1();
	}
}
