package com.qh.cloud.test.JDK8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @Description Lambda test
 * @Date 2018年3月9日 上午10:47:58
 * @author QingHang
 * @version 1.0.0
 */
public class LambdaTest {

	public static void main(String[] args) {



		///===============lambda用法==================

		//  () -> {System.out.println();}
        //  参数      方法体

		Comparator<String> sortByName = (String s1, String s2) -> (s1.compareTo(s2));

		List<String> list = new ArrayList<>();
		list.add("li");
		list.add("qing");
		list.add("hang");
		list.add("hang");

		list.forEach((a) -> System.out.println(a));



	//
		list.forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		//
		list.forEach(t -> {
			if (t.equals("qing")) {
				System.out.println("这是第几个 " + "   " + t);
			}
		});

		//
		new Thread(()-> System.out.println("LQH"));


		///===============Stream用法==================

		// 转换成新的集合
		List<String> list2 = list.stream().distinct().collect(Collectors.toList());

		// 统计
		System.out.println(list.stream().filter(a -> a.equals("hang")).count());
          List<Integer> aa = new ArrayList<>();
		aa.add(1);
		aa.add(2);
		aa.add(1);
		aa.add(3);
		aa.add(14);
		aa.add(15);
		aa.add(11);
		System.out.println(aa.stream().filter(aaa ->aaa > 3).collect(Collectors.toList()));
		// 去重
		System.out.println(list.stream().distinct().count());

		//排序
		System.out.println(list.stream().sorted().collect(Collectors.toList()));

		// list.stream().map(a -> a.getA)

		Map<String, String> map = new HashMap<>();
		map.put("l", "li");
		map.put("q", "qing");
		map.put("h", "hang");



		List<Person> ppp = new ArrayList<>();
		Person p1 = new Person();
		p1.setSex(3);
		p1.setName("张三");
		ppp.add(p1);

		Person p2 = new Person();
		p2.setSex(2);
		p2.setName("张二");
		ppp.add(p2);

		Person p3 = new Person();
		p3.setSex(4);
		p3.setName("张四");
		ppp.add(p3);

		Person p4 = new Person();
		p4.setSex(2);
		p4.setName("李二");
		ppp.add(p4);

		Person p5 = new Person();
		p5.setSex(4);
		p5.setName("李四");
		ppp.add(p5);

		Person p6 = new Person();
		p6.setSex(3);
		p6.setName("李三");
		ppp.add(p6);

		System.out.println("====================");

		//取出某一个属性最为一个新的集合
		List<Integer> sex = ppp.stream().map(Person::getSex).collect(Collectors.toList());

		boolean isc = ppp.contains(p5);

		//翻转
		Collections.reverse(ppp);

		//根据某一属性值去重
		List<Person> unique = ppp.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(Person::getSex))), ArrayList::new));





		System.out.println("====================");



	}



	public static int add(int a,int b){
		return  a + b;
	}

}
