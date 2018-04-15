package com.qh.cloud.test.DesignPatterns.FactoryPatterns.abstractFactory;

/**
 * @Description 客户端
 * @Date 2018年2月12日 上午11:02:34
 * @author QingHang
 * @version 1.0.0
 */
public class Client {

	public static void main(String[] args) {
		// 获取生产 产品1的工厂
		AbstractFactory pf1 = FactoryMaker.getFactory("a");
		// 生产A类 1产品
		AbstractProductA productA1 = pf1.createProductA();
		// 生产 B类 1产品
		AbstractProductB productB1 = pf1.createProductB();

		// 获取生产 产品2的工厂
		AbstractFactory pf2 = FactoryMaker.getFactory("b");
		// 生产A类 2产品
		AbstractProductA productA2 = pf2.createProductA();
		// 生产 B类2产品
		AbstractProductB productB2 = pf2.createProductB();

	}
}
