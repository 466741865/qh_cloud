package com.qh.cloud.test.list;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		list.add("111");
		list.add("222");
		list.add("333");

		System.out.println("初始化大小：：" + list.size() + "     元素：：" + list.toString());

		list.add(1, "000");
		System.out.println("初始化大小：：" + list.size() + "     元素：：" + list.toString());






		String sidss ="[\"141241221\",\"12312321321\",\"1234345\"]";
		List<String> sids = JSON.parseArray(sidss,String.class);
		System.out.println("============");

	}
}
