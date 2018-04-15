package com.qh.cloud.test.enums;

/**
 * 学段 枚举
 * @Description 学段 1：小学 ，2：初中 ，3：高中
 * @Date 2017年6月2日 上午11:39:13
 * @author QingHang
 * @version 1.0.0
 */
public enum StageEnum {
	PRIMARY_SCHOOL(1, "小学"), JUNIOR_MIDDLE_SCHOOL(2, "初中"), SENIOR_HIGH_SCHOOL(3, "高中");

	private int code;

	private String name;

	private StageEnum(int code, String name) {
		this.code = code;
		this.name = name;
	}

	public static String getName(int value) {
		for (StageEnum a : StageEnum.values()) {
			if (a.getCode() == value) {
				return a.getName();
			}
		}
		return null;
	}

	public static int getCodeByName(String name) {
		for (StageEnum a : StageEnum.values()) {
			if (a.getName().equals(name)) {
				return a.getCode();
			}
		}
		return 0;
	}

	public int getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

}
