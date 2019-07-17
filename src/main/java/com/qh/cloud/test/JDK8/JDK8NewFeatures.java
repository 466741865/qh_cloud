package com.qh.cloud.test.JDK8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

/**
 * @Description jdk8新特性
 * @Date 2017年5月3日 下午3:01:54
 * @author QingHang
 * @version 1.0.0
 */
public class JDK8NewFeatures {

	public static void main(String[] args) {

		LambdaExpression();


		System.out.println();



	}

	// lambda表达式
	public static void LambdaExpression() {
		// 最简单的形式中，一个lambda可以由用逗号分隔的参数列表、–>符号与函数体三部分表示
		// 输出： a b c
		Arrays.asList("a", "b", "c").forEach(e -> System.out.println(e));
		System.out.println("==================");

		// lambda的函数体会更加复杂，这时可以把函数体放到在一对花括号中
		// 输出： 1 1 2 2 3 3
		Arrays.asList("1", "2", "3").forEach(e -> {
			System.out.println(e);
			System.out.println(e);
		});
		System.out.println("==================");

		// Lambda可以引用类的成员变量与局部变量（如果这些变量不是final的话，
		// 它们会被隐含的转为final，这样效率更高）
		String separator = ",";
		Arrays.asList("a", "b", "c").forEach((String e) -> System.out.println(e + separator));

		System.out.println("==================");
		// Lambda可能会返回一个值。返回值的类型也是由编译器推测出来的。
		// 如果lambda的函数体只有一行的话，那么没有必要显式使用return语句。下面两个代码片段是等价的：
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));

		Arrays.asList("a", "b", "d").sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			return result;
		});

		System.out.println("==================");
		// lambda表达式可使用的变量
		// 将为列表中的字符串添加前缀字符串
		String lambda = "lambda: ";
		List<String> lists = Arrays.asList(new String[] { "Li", "Qing", "Hang" });
		List<String> collect = lists.stream().map(content -> {
			Long times = System.currentTimeMillis();
			return lambda + content + " ---- " + times;
		}).collect(Collectors.toList());

		// 遍历 数组
		collect.forEach(System.out::println);

		System.out.println("==================");

		List<Integer> nums = Lists.newArrayList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);

		System.out.println("sum is:" + nums.stream().filter(num -> num != null).distinct().mapToInt(num -> num * 2)
				.peek(System.out::println).skip(2).limit(4).sum());
	}





}
