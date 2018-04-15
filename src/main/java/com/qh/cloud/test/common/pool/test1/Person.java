package com.qh.cloud.test.common.pool.test1;

/**
 * @Description Person 实体
 * @Date 2018年1月23日 下午4:40:55
 * @author QingHang
 * @version 1.0.0
 */
public class Person {

	private String name;

	private boolean isUse;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isUse() {
		return isUse;
	}

	public void setUse(boolean isUse) {
		this.isUse = isUse;
	}

	public void work() {
		System.out.println(name + " 在干活 ");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", isUse=" + isUse + "]";
	}
}
