package com.qh.cloud.test.finalTest;

/**
 * @Description final 测试类。
 * @Date 2017年11月12日 下午12:02:55
 * @author QingHang
 * @version 1.0.0
 */
public class Test {
	public static void main(String[] args) {

		UserModel model = new UserModel();
		model.setAge(1);
		model.setName("lqh");
		System.out.println("初始化：：" + model.toString());
		test1(model);
		System.out.println("调整后：：" + model.toString());
	}

	public static void test1(UserModel model) {
		model.setAge(18);
		model.setName("qinghang");
	}

}
