package com.qh.cloud.test.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 格式化时间工具类
 * @Date 2017年8月23日 下午2:16:09
 * @author QingHang
 * @version 1.0.0
 */
public class TimeFormat {

	public static void main(String[] args) {
		times(10);
		timesToStr(10);
		List<String> list = new ArrayList<>();
		list.add("5,5,5");
		list.add("5,5,5");
		list.add("hahahaha ");// 5,5,5&5,5,5&5
		System.out.println(list.toString());

		// 转成
		formatDurationToStr(299);
		formatDurationToNumber("00:04:59");
	}

	/**
	 * @Description
	 * @param time
	 * @return
	 */
	public static String times(Integer time) {
		// 1时1分1秒 = 1*60*60 + 1 * 60 +1 = 3661秒
		// 221秒 = 3分41秒 = 3*60+41
		String str = "41";
		int seconds = Integer.parseInt(str);
		int temp = 0;
		StringBuffer sb = new StringBuffer();
		temp = seconds / 3600;
		sb.append((temp < 10) ? "0" + temp + "时" : "" + temp + "时");

		temp = seconds % 3600 / 60;
		sb.append((temp < 10) ? "0" + temp + "分" : "" + temp + "分");

		temp = seconds % 3600 % 60;
		sb.append((temp < 10) ? "0" + temp + "秒" : temp + "秒");

		System.out.println(sb.toString());
		// System.out.println("此文件时长为:" + ls / 60000 + "分" + (ls / 1000 - ls / 60000 * 60) + "秒！");
		return null;
	}

	/**
	 * @Description 将总秒数 以 ,拼接成 时分秒 例 ： 0,0,10
	 * @param sceneTime
	 * @return
	 */
	public static String timesToStr(Integer sceneTime) {
		int temp;
		StringBuffer sb = new StringBuffer();
		temp = sceneTime / 3600;
		sb.append((temp < 10) ? temp + "," : "" + temp + ",");

		temp = sceneTime % 3600 / 60;
		sb.append((temp < 10) ? temp + "," : "" + temp + ",");

		temp = sceneTime % 3600 % 60;
		sb.append((temp < 10) ? temp : temp);

		System.out.println(sb.toString());
		return sb.toString();
	}

	public static String formatDurationToStr(Integer sceneTime) {
		String time = "00时00分00秒";
		if (sceneTime != null) {
			int temp = 0;
			StringBuffer sb = new StringBuffer();
			temp = sceneTime / 3600;
			sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");

			temp = sceneTime % 3600 / 60;
			sb.append((temp < 10) ? "0" + temp + ":" : "" + temp + ":");

			temp = sceneTime % 3600 % 60;
			sb.append((temp < 10) ? "0" + temp : temp);
			time = sb.toString();
		}
		System.out.println("总时长：：" + time);
		return time;
	}

	/**
	 * @Description 将时分秒转秒 例 00:00:00
	 * @param sceneTime 00:00:00
	 * @return 返回 总时长 秒
	 */
	public static long formatDurationToNumber(String sceneTime) {

		long totalTime = 0;
		String[] split = sceneTime.split(":");
		totalTime = totalTime + Integer.parseInt(split[0]) * 60 * 60;
		totalTime = totalTime + Integer.parseInt(split[1]) * 60;
		totalTime = totalTime + Integer.parseInt(split[2]);
		System.out.println("总时长为：：：：" + totalTime);
		return totalTime;
	}
}
