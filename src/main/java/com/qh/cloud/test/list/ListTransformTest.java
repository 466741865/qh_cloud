package com.qh.cloud.test.list;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.Lists;

/**
 * 测试当源list为null时，输出结果 结论：当源数据list为null时，会报空指针
 * @author weidd
 */
public class ListTransformTest {
	public static void main(String[] args) {
		List<Integer> list1 = null;

		List<Integer> list2 = Lists.transform(list1, new Function<Integer, Integer>() {
			public Integer apply(Integer arg0) {
				return arg0;
			}
		});

		System.out.println(list2);
	}
}
