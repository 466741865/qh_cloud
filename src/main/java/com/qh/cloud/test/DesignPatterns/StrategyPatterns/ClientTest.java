package com.qh.cloud.test.DesignPatterns.StrategyPatterns;

/**
 * @Description 策略模式 -- 入口
 * @Date 2017年8月4日 上午11:13:43
 * @author QingHang
 * @version 1.0.0
 */
public class ClientTest {

	public static void main(String[] args) {
		// 调用 计算价格的接口
		double price = calculatePrice(1, 300);

		System.out.println("图书的 最终价格为：：" + price);

	}

	/**
	 * @Description 根据会员类型 计算价格
	 * @param memberType
	 * @param originalPrice
	 * @return
	 */
	public static double calculatePrice(int memberType, double originalPrice) {
		// 折扣 抽象类
		MemberStrategy strategy = null;

		switch (memberType) {
			case 0:
				// 初级会员
				strategy = new PrimaryMemberStrategy();
				break;

			case 1:
				// 中级会员
				strategy = new IntermediateMemberStrategy();
				break;

			case 2:
				// 高级会员
				strategy = new AdvancedMemberStrategy();
				break;

			default:
				break;
		}
		if (strategy != null) {
			Price price = new Price(strategy);
			double presentPrice = price.quote(originalPrice);
			return presentPrice;
		}
		return originalPrice;
	}

}
