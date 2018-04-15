package com.qh.cloud.test.list;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

public class SubListTest {
	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(1, 3, 4, 5, 2);

		System.out.println(list.subList(0, 3));

		List<String> lists = new ArrayList<String>();
	}
}
