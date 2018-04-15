package com.qh.cloud.test.recursion;

/**
 * @Description 大于0的 阶乘
 * @Date 2017年5月5日 下午4:29:50
 * @author QingHang
 * @version 1.0.0
 */
public class NumberFactorial {

	public static void main(String[] args) {

		int n = 5;
		int i = factorial(n);
		System.out.println("结果：：：" + i);
	}

	public static int factorial(int n) {
		int t = n - 1;
		if (t > 1) {
			int result = t * n;
			int sum = result + factorial(n - 1);
			System.out.println("此时的n的值：：" + n);
			System.out.println("计算：：：：：：：：" + t + " *" + n);
			return sum;
		} else {
			return n;
		}
	}
}
