package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 ---- 初级会员折扣类
 * @Date 2017年8月4日 上午11:15:03
 * @author QingHang
 * @version 1.0.0
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double booksPrice) {
		System.out.println("对于初级会员没有折扣 ");
		return booksPrice;
	}

}
