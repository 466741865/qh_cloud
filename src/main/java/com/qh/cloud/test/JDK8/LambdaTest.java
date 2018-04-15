package com.qh.cloud.test.JDK8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Description Lambda test
 * @Date 2018年3月9日 上午10:47:58
 * @author QingHang
 * @version 1.0.0
 */
public class LambdaTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("li");
		list.add("qing");
		list.add("hang");
		list.add("hang");

		// 用法1
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// 用法2
		list.forEach(t -> {
			if (t.equals("qing")) {
				System.out.println("这是第几个 " + "   " + t);
			}
		});
		// 转换成新的集合
		List<String> list2 = list.stream().distinct().collect(Collectors.toList());
		// 统计
		System.out.println(list.stream().filter(a -> a.equals("hang")).count());
		// 去重
		System.out.println(list.stream().distinct().count());

		// list.stream().map(a -> a.getA)

		Map<String, String> map = new HashMap<>();
		map.put("l", "li");
		map.put("q", "qing");
		map.put("h", "hang");

	}
}
