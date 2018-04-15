package com.qh.cloud.test.integer;

/**
 * @Description integer 测试
 * @Date 2017年9月7日 下午5:09:20
 * @author QingHang
 * @version 1.0.0
 */
public class IntegerTest extends ClassLoader {

	public static void main(String[] args) {
		Integer integer = new Integer(100);

		Double double1 = new Double(100.0);

		vuleOfTest();
		inVlueTest();

	}

	/**
	 * @Description 装箱
	 */
	public static void vuleOfTest() {

		Integer i = 100;
		Integer i1 = 100;
		Integer ii = new Integer(100);
		Integer iii = new Integer(100);

		Integer a = new Integer(128);
		Integer b = new Integer(128);

		System.out.println("i 与   i1 比较" + (i == i1));
		System.out.println("i 与   ii 比较" + (i == ii));
		System.out.println("ii 与   iii 比较" + (Integer.valueOf(ii) == Integer.valueOf(iii)));
		System.out.println("a 与   b 比较" + (a == b));

	}

	/**
	 * @Description 拆箱
	 */
	public static void inVlueTest() {

		Integer aa = 130;
		int bb = aa;

		Integer cc = 130;
		int dd = cc;

		System.out.println("aa 与  cc   比较" + (aa == cc));
		System.out.println("bb 与  dd  比较" + (bb == dd));

	}

}
