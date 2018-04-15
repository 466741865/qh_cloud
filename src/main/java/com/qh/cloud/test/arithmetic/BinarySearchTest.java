package com.qh.cloud.test.arithmetic;

/**
 * @Description 二分查找
 * @Date 2017年6月27日 下午11:59:47
 * @author QingHang
 * @version 1.0.0
 */
public class BinarySearchTest {
	public static void main(String[] args) {

		System.out.println("==========折半=============");
		int[] numbers2 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int search = binarySearch(numbers2, 6);
		System.out.println("查询结果：：  " + search);

		int binarySearch2 = binarySearch2(numbers2, 6, 0, numbers2.length - 1);
		System.out.println("折半 递归查找结果：：" + binarySearch2);
	}

	/**
	 * @Description 二分查找 while 实现
	 * @param srcArray
	 * @param des
	 */
	public static int binarySearch(int[] srcArray, int des) {
		int low = 0;
		int high = srcArray.length - 1;
		while (low <= high) {
			int middle = (low + high) / 2;
			if (srcArray[middle] < des) {
				low = middle + 1;
			} else if (srcArray[middle] > des) {
				high = middle - 1;
			} else {
				return middle;
			}
		}
		return -1;
	}

	/**
	 * @Description 折半查找 递归实现
	 * @param srcArray
	 * @param des
	 * @param low
	 * @param high
	 * @return
	 */
	public static int binarySearch2(int[] srcArray, int des, int low, int high) {

		int middle = (low + high) / 2;

		if (low > high || des > srcArray[high] || des < srcArray[low]) {
			return -1;
		}
		if (srcArray[middle] == des) {
			return middle;
		} else if (srcArray[middle] > des) {
			return binarySearch2(srcArray, des, low, middle - 1);
		} else if (srcArray[middle] < des) {
			return binarySearch2(srcArray, des, middle + 1, high);
		}
		return middle;
	}

}
