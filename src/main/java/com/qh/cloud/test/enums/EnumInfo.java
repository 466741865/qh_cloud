package com.qh.cloud.test.enums;

/**
 * @Description 枚举测试类
 * @Date 2017年6月7日 下午1:47:26
 * @author QingHang
 * @version 1.0.0
 */
public class EnumInfo {

	public static void main(String[] args) {
		for (StageEnum s : StageEnum.values())
			System.out.println(s + ", name " + s.getName() + "  所在的声明顺序 ,ordinal:" + s.ordinal());

		int aa = StageEnum.JUNIOR_MIDDLE_SCHOOL.getCode();

	}
}
