package com.qh.cloud.test.reflect;

/**
 * @Description 反射测试 类
 * @Date 2017年5月24日 上午11:55:25
 * @author QingHang
 * @version 1.0.0
 */
public class ReflectModel {

	private String str = "这是字符串 属性";

	private int dumber = 1001;

	public ReflectModel() {

	}

	public ReflectModel(String str, int dumber) {
		this.str = str;
		this.dumber = dumber;
	}

	public String strTest(String str) {
		System.out.println("这是输出字符串方法");

		return str + "::" + this.str;
	}

	public int intTest(int i) {
		System.out.println("这是输出 数字方法");
		return i + this.dumber;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public int getDumber() {
		return dumber;
	}

	public void setDumber(int dumber) {
		this.dumber = dumber;
	}

}
