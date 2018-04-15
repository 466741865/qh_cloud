package com.qh.cloud.test.list;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 在特定位置插入元素，保证排序
 * @author QingHang
 */
public class ListInsert {
	public static void main(String[] args) {
		List<Integer> list = Lists.newArrayList(1, 2, 3, 5, 6);
		int j = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) > 4) {
				j = i;
				break;
			}
		}

		list.add(j, 4);
		System.out.println(list);

	}
}
