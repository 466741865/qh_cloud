package com.qh.cloud.test.guava;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * @Description Guava 的测试
 * @Date 2017年9月11日 下午12:03:11
 * @author QingHang
 * @version 1.0.0
 */
public class GuavaTest {

	public static void main(String[] args) {

		// Stopwatch stopwatch = new StopWatch().start();
		// List<String> list = new ArrayList<String>();
		// for (String string : list) {
		//
		// }
		// long times = stopwatch.elapsed(TimeUnit.NANOSECONDS);
		// System.out.println(times);

		List<String> list = new ArrayList<String>(10000);
		LocalTime start = LocalTime.now();
		for (String string : list) {

		}
		long time = ChronoUnit.MILLIS.between(start, LocalTime.now());
		System.out.println("耗时  " + time);
		// 拼接串
		System.out.println(Joiner.on("*").join("a", "b", "c"));

		List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(ints);

		ints = Lists.newArrayList(Collections2.filter(ints, new Predicate<Integer>() {

			@Override
			public boolean apply(Integer arg0) {
				if (arg0 > 3) {
					return false;
				}
				return true;
			}
		}));
		System.out.println(ints);
		ints.addAll(Arrays.asList(8, 9));
		System.out.println(ints);
		collectionCreate();
	}

	/**
	 * 集合的创建
	 */
	public static void collectionCreate(){
		//普通
		List<String> list = Lists.newArrayList();
		list = Lists.newArrayList("L","Q","H");
		System.out.println(list.toString());

		Set<String> set = Sets.newHashSet();
		set = Sets.newHashSet("L","Q","H");
		System.out.println(set.toString());

		Map<String,String> map = Maps.newHashMap();
		map.put("lqh","LQH");

		//不可变
		ImmutableList.of("L","Q","H");

	}

}
