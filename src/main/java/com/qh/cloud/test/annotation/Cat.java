package com.qh.cloud.test.annotation;

/**
 * @Description 注解测试类
 * @Date 2017年11月12日 上午9:34:17
 * @author QingHang
 * @version 1.0.0
 */
public class Cat {

	private String name;

	@Validatelnt(minLength = 0, maxLength = 20)
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
