package com.qh.cloud.test.time;

import java.util.Calendar;

/**
 * @Description 时间日期工具类
 * @Date 2017年10月24日 下午1:53:36
 * @author QingHang
 * @version 1.0.0
 */
public class TimeTest {
	public static void main(String[] args) {
		/**
		 * 获取的calendar实例的时间是当前时间
		 */
		// 得到Calendar的实例
		Calendar calendar = Calendar.getInstance();

		/**
		 * 获取 年 ，月 ，日
		 */
		System.out.println(calendar.get(Calendar.YEAR));
		// 默认从0-11
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));

		/**
		 * 获取时分秒
		 */
		// 24小时制
		System.out.println(calendar.get(Calendar.HOUR_OF_DAY));
		// 12小时制
		// System.out.println(calendar.get(Calendar.HOUR));
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));

		String date = String.valueOf(calendar.get(Calendar.YEAR)) + String.valueOf((calendar.get(Calendar.MONTH) + 1))
				+ calendar.get(Calendar.DATE);
		System.out.println(date);
	}
}
