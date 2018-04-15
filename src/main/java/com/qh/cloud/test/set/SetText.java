package com.qh.cloud.test.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * @Description set集合 测试类
 * @Date 2017年8月10日 下午5:33:59
 * @author QingHang
 * @version 1.0.0
 */
public class SetText {

	public static void main(String[] args) {

		HashSet<Integer> set = new HashSet<>();

		set.add(1);
		set.add(1);
		set.add(2);

		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Object o = it.next();
			System.out.println(o);
		}

		System.out.println("======= set 转   list============");
		List<Integer> list = new ArrayList<>();
		list.addAll(set);

		for (Integer integer : list) {
			System.out.println(integer);
		}
	}

}
