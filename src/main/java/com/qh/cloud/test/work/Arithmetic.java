package com.qh.cloud.test.work;

/**
 * @Description 工作中的小算法
 * @Date 2017年10月14日 上午10:45:01
 * @author QingHang
 * @version 1.0.0
 */
public class Arithmetic {

	public static void main(String[] args) {
		ticketPrice2(1.5, 0.5);

		threeDimensionalArray2();

	}

	/**
	 * @Description 计算票价的方法，两种票价相加 为5元有几种几种方式，，，实现一
	 * @param price1
	 * @param price2
	 */
	public static void ticketPrice(double price1, double price2) {
		int num1 = (int) (5 / price1) + 1;
		int num2 = (int) (5 / price2) + 1;
		for (int i = 0; i < num1; i++) {
			for (int j = 0; j < num2; j++) {
				double result = (price1 * i) + (price2 * j);
				if (result == 5) {
					System.out.println("组合方式：  price1 " + i + " 张，，price2 " + j + " 张");
				}
			}
		}
	}

	/**
	 * @Description 计算票价的方法，两种票价相加 为5元有几种几种方式，，，实现二
	 * @param price1
	 * @param price2
	 */
	public static void ticketPrice2(double price1, double price2) {
		int num = (int) ((5 / price1) + 1);
		for (int i = 0; i < num; i++) {
			double c = (5 - (price1 * i)) / price2;
			if (c == 0 || (c * 2) % 2 == 0) {
				System.out.println("组合方式：  price1 " + i + " 张，，price2 " + (int) c + " 张");
			}
		}
	}

	/**
	 * @Description 将1至27 个数存入三维数组中，不能重复
	 */
	public static void threeDimensionalArray() {
		int number = 1;
		int[][][] a1 = new int[3][3][3];
		for (int i = 0; i < 3; i++) {
			int[][] a2 = new int[3][3];
			for (int j = 0; j < 3; j++) {
				int[] a3 = new int[3];
				for (int k = 0; k < 3; k++) {
					a3[k] = number;
					number++;
				}
				a2[j] = a3;
			}
			a1[i] = a2;
		}
		print(a1);
	}

	/**
	 * @Description 将1至27 个数存入三维数组中，不能重复。。实现二
	 */
	public static void threeDimensionalArray2() {

		int[][][] a1 = new int[3][3][3];
		for (int number = 0; number < 27; number++) {
			for (int i = 0; i < 3; i++) {
				int[][] a2 = new int[3][3];
				for (int j = 0; j < 3; j++) {
					int[] a3 = new int[3];
					for (int k = 0; k < 3; k++) {
						a3[k] = number;
						number++;
					}
					a2[j] = a3;
				}
				a1[i] = a2;
			}
		}
		print(a1);
	}

	public static void print(int[][][] num2) {

		System.out.println("{");
		for (int i = 0; i < num2.length; i++) {
			System.out.print("{");
			for (int j = 0; j < num2[i].length; j++) {
				System.out.print("{");
				for (int k = 0; k < num2[i][j].length; k++) {
					System.out.print(" " + num2[i][j][k] + " ");
				}
				System.out.print("}");
			}
			System.out.print("}");
			System.out.println("");
		}
		System.out.print("}");
	}

}
