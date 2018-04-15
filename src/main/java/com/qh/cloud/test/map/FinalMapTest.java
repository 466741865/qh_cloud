package com.qh.cloud.test.map;

import java.util.Map;

import com.google.common.collect.Maps;

public class FinalMapTest {

	private static final Map<String, String> map = Maps.newHashMap();

	public static void main(String[] args) throws Exception {
		map.put("dfd", "dfdfd");

		System.out.println(map);
	}

}
