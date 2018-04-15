package com.qh.cloud.test.finalTest;

/**
 * @Description final model
 * @Date 2017年11月12日 下午12:03:36
 * @author QingHang
 * @version 1.0.0
 */
public class UserModel {

	private String name;

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

	@Override
	public String toString() {
		return "UserModel [name=" + name + ", age=" + age + "]";
	}
}
