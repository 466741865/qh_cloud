package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 ---- 价格类
 * @Date 2017年8月4日 上午11:30:18
 * @author QingHang
 * @version 1.0.0
 */
public class Price {

	// 拥有一个具体的策略对象
	private MemberStrategy memberStrategy;

	/**
	 * @Description 构造方法 传入一个具体的策略对象
	 * @param memberStrategy
	 */
	public Price(MemberStrategy memberStrategy) {
		this.memberStrategy = memberStrategy;
	}

	/**
	 * @Description 计算图书价格
	 * @param booksPrice 原价
	 * @return
	 */
	public double quote(double booksPrice) {
		return this.memberStrategy.calcPrice(booksPrice);
	}
}
