package com.qh.cloud.test.genericity;

import java.util.Arrays;
import java.util.List;

/**
 * @Description 泛型测试类 main方法
 * @Date 2017年7月13日 上午11:06:30
 * @author QingHang
 * @version 1.0.0
 */
public class TestMain {

	static List<Apple> apples = Arrays.asList(new Apple());

	static List<Fruit> fruit = Arrays.asList(new Fruit());

	// ================ 没有使用通配符 开始==========
	static class Reader<T> {
		T readExact(List<T> list) {
			return list.get(0);
		}
	}

	static void f1() {
		Reader<Fruit> fruitReader = new Reader<Fruit>();
		// Errors: List<Fruit> cannot be applied to List<Apple>.
		// 编译器会报错，因为List<Fruit>与List<Apple>之间并没有任何的关系。
		// Fruit f = fruitReader.readExact(apples);
	}
	// ================ 没有使用通配符 结束==========

	// ============ 使用 通配符测试 开始=============
	static class CovariantReader<T> {
		T readCovariant(List<? extends T> list) {
			return list.get(0);
		}
	}

	static void f2() {
		CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
		Fruit f = fruitReader.readCovariant(fruit);
		Fruit a = fruitReader.readCovariant(apples);
	}
	// ============ 使用 通配符测试 结束=============

	public static void main(String[] args) {
		// boxTest 类中 使用了 泛型，可以将T替换成 任意类型了，例如：
		BoxTest<Integer> in = new BoxTest<>();
		BoxTest<String> str = new BoxTest<>();
		BoxTest<Double> dub = new BoxTest<>();

		// 泛型方法测试
		// 后面省去泛型是 让Java1.7/1.8利用type inference，让Java自动推导出相应的类型参数：
		Pair<Integer, String> p1 = new Pair<>(1, "lqh");
		Pair<Integer, String> p2 = new Pair<Integer, String>(2, "cc");
		boolean result = UtilsTest.compare(p1, p2);
		System.out.println("两个对象是否相等判断结果：：" + result);

		// 边界符 测试
		String[] strs = { "d", "c", "a", "f", "k", "w" };
		int counts = UtilsTest.countGreaterThan(strs, "d");
		System.out.println("大于 d 的 个数：：：" + counts);

		// 通配符 测试
		f2();
	}

}
