package com.qh.cloud.test.forTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 增强for循环 foreach 测试
 * @Date 2017年6月5日 上午10:39:56
 * @author QingHang
 * @version 1.0.0
 */
public class ForEachTest {

	public static void main(String[] args) {
		List<String> list1 = null;

		System.out.println("开始遍历list");
		// 当list为null时 会抛空指针异常
		for (String string : list1) {
			System.out.println("数组中数据" + string);
		}

		List<String> list2 = new ArrayList<>();

		for (;;) {

			System.out.println("for ceshi");
		}

	}

}
