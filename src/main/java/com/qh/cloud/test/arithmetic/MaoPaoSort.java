package com.qh.cloud.test.arithmetic;

/**
 * @Description 排序算法
 * @Date 2017年5月4日 上午11:43:38
 * @author QingHang
 * @version 1.0.0
 */
public class MaoPaoSort {

	public static void main(String[] args) {

		System.out.println("==========冒泡=============");
		Integer[] numbers = { 22, 12, 88, 35, 64, 28, 50, 6 };
		print(numbers, "排序前");
		// 冒泡
		bubblingSort(numbers);
		// java8的Arrays 类 可以进行排序
		// Arrays.sort(numbers);
		print(numbers, "排序后");

	}

	/**
	 * @Description 打印数组
	 */
	public static void print(Integer[] ints, String describe) {

		System.out.println("这是  " + describe + "  的数组");
		System.out.print("[ ");
		for (int i : ints) {
			System.out.print(i + ",");
		}
		System.out.print(" ]");
		System.out.println();
	}

	/**
	 * @Description 冒泡排序
	 */
	public static void bubblingSort(Integer[] ints) {
		int temp = 0;
		int size = ints.length;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (ints[j] > ints[j + 1]) {
					temp = ints[j];
					ints[j] = ints[j + 1];
					ints[j + 1] = temp;
				}
			}
			print(ints, "排序中" + i);
		}

	}

}
