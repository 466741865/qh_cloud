package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 --- 抽象折扣类
 * @Date 2017年8月4日 上午11:14:24
 * @author QingHang
 * @version 1.0.0
 */
public interface MemberStrategy {

	/**
	 * @Description 策略方法 --- 计算图书的价格
	 * @param booksPrice
	 * @return
	 */
	public double calcPrice(double booksPrice);
}
