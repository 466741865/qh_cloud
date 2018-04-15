package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 ---- 高级会员折扣类
 * @Date 2017年8月4日 上午11:19:56
 * @author QingHang
 * @version 1.0.0
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对高级会员 的折扣为 20%");
		return booksPrice * 0.8;
	}

}
