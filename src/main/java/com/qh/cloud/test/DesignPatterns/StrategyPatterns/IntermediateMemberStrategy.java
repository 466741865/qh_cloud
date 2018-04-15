package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 ---- 中级会员折扣类
 * @Date 2017年8月4日 上午11:18:26
 * @author QingHang
 * @version 1.0.0
 */
public class IntermediateMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {

		System.out.println("对中级会员的折扣为10%");
		return booksPrice * 0.9;
	}

}
