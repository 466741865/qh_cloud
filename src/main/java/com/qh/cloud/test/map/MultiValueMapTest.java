package com.qh.cloud.test.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

/**
 * MultiValueMap 一键对应多值
 * @Description:
 * @author QingHang
 * @date: 2017年2月22日
 */
public class MultiValueMapTest {

	public static void main(String[] args) {
		MultiValueMap<String, Object> mvm = new LinkedMultiValueMap<String, Object>();
		mvm.add("number", "1");
		mvm.add("number", "30");
		mvm.add("number", "dada");
		mvm.add("name", "wang");
		mvm.add("card", "12344");
		mvm.add("card", "65432");

		Collection mapcoll = null;
		mapcoll = mvm.get("number");
		Iterator ii = mapcoll.iterator();
		while (ii.hasNext()) {
			String mailValue = (String) ii.next();
			System.out.println(mailValue);
		}

		Map<String, String> map = new HashMap<>();
	}
}
