package com.qh.cloud.test.DesignPatterns.FactoryPatterns.abstractFactory;

/**
 * @Description 抽象工厂
 * @Date 2018年2月12日 上午10:54:51
 * @author QingHang
 * @version 1.0.0
 */
abstract class AbstractFactory {

	// 生产1产品
	abstract AbstractProductA createProductA();

	// 生产2产品
	abstract AbstractProductB createProductB();
}
