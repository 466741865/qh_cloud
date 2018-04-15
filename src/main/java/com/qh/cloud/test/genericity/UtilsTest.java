package com.qh.cloud.test.genericity;

/**
 * @Description 泛型测试，泛型方法
 * @Date 2017年7月13日 上午11:10:26
 * @author QingHang
 * @version 1.0.0
 */
public class UtilsTest {

	/**
	 * 声明一个泛型方法很简单，只要在返回类型前面加上一个类似<K, V>的形式就行了：
	 * @Description 比较 对象中的值是否相等
	 * @param p1
	 * @param p2
	 * @return
	 */
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {

		return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
	}

	/**
	 * 单纯的使用泛型除了short, int, double, long, float, byte, char等原始类型，其他的类并不一定能使用操作符> 编译器报错，
	 * @Description 使用 边界符 来解决 参数类型 局限性的问题
	 * @Description 查询某个泛型数组中大于某个特定元素的个数
	 * @param array
	 * @param elem
	 * @return
	 */
	public static <T extends Comparable<T>> int countGreaterThan(T[] array, T elem) {
		int count = 0;
		for (T e : array)
			if (e.compareTo(elem) > 0)
				++count;
		return count;
	}
}
