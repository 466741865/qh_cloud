package com.qh.cloud.test.random;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 随机数测试类
 * @Date 2017年9月27日 下午3:54:16
 * @author QingHang
 * @version 1.0.0
 */
public class RandomTest {
	static final AtomicInteger rc = new AtomicInteger();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			rc.getAndIncrement();
			int a = rc.get() % 3;
			System.out.println(a);
		}

	}

	private static void random() {
		int max = 100;
		int min = 0;
		Random random = new Random();
		int s = random.nextInt(max) % (max - min + 1) + min;
		System.out.println(s);
		int ss = (s + 3) % 3;
		System.out.println(ss);
	}
}
