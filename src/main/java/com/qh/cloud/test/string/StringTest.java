package com.qh.cloud.test.string;

/**
 * @Description string 的测试类
 * @Date 2017年5月21日 下午1:12:49
 * @author QingHang
 * @version 1.0.0
 */
public class StringTest {

	public static void main(String[] args) {

		// =========String==============

		String str = "123456";

		// 转换成数组
		String[] strings = str.split("3");

		// 截取字符串
		str.substring(0, 2);

		// =========StringBuilder==============

		StringBuilder sb = new StringBuilder();
		sb.append("a");

		System.out.println("转换后的 串::: " + sb);

		// =========StringBuffer==============

		StringBuffer sbf = new StringBuffer();
		sbf.append("bb");

		System.out.println("转换的 串：： " + sbf);

		String fileName = "abc-def-001aaa";
		String[] split = fileName.split("-");
		for (String string : split) {
			System.out.println(string);
		}

		System.out.println(split.length);
		int indexOf = split[2].lastIndexOf('.');
		// System.out.println(split[2].substring(0, indexOf));

		// 获取后缀名
		String names = "1234sss.mp4";
		String fileNameSuffix = getFileNameSuffix(names);
		System.out.println("后缀名为：：：    " + fileNameSuffix);

		// ========================字符串比较

		String aa = ".jpg";
		String bb = ".JPG";
		System.out.println(aa.equalsIgnoreCase(bb));

		// ============================

		// String st = ",0,&0,,0&hahaha";
		// String[] split2 = st.split("&");
		// String shi = split2[0];
		// Integer second = IntoASecond(shi);
		// System.out.println("时长为：：" + second);

		String pathurl = "/mes_fan/zipPackage/mes_fan_64_457-1.0.0.beta";
		String[] split2 = pathurl.split("/");

		System.out.println(split2[split2.length - 1]);

		// 校验整型数据 ，直接点 抛异常
		String aaddd = "0.1";
		try {
			int num = Integer.parseInt(aaddd);
		} catch (Exception e) {
			System.out.println("转换异常");
		}

		String command = "/mes_fan/audio_command/da4a8f69c9a74b2fa7617c71e166a292.mp3";
		int lastIndexOf = command.lastIndexOf("/");
		String substring = command.substring(lastIndexOf, command.length());
		System.out.println(substring);

		boolean contains = command.contains("audio_command_temp");
		System.out.println(contains);

		// String trm = null;
		// System.out.println(trm.trim());

		long ls = 500;
		double dl = ls / 1000.0D;
		System.out.println("dl:" + dl);

		long duration = (long) Math.ceil(dl);
		System.out.println("最后的时间：" + duration);

		System.out.println("======================");

		String sss = "111_Tdadga-sdasda-jfasf_dsdaj_sda_1";
		String[] split3 = sss.split("_");
		System.out.println(split3[0]);
		String string = sss.substring(split3[0].length() + 1, sss.length());
		System.out.println(string);
		String string2 = string.substring(string.length() - 2, string.length());
		System.out.println(string2);
		String string3 = string.substring(0, string.length() - 2);
		System.out.println(string3);

	}

	/**
	 * @Description 获取后缀名
	 * @param fileName
	 * @return
	 */
	public static String getFileNameSuffix(String fileName) {
		String name = "";
		if (fileName != null && !fileName.isEmpty()) {
			int lastIndexOf = fileName.lastIndexOf('.');
			if (lastIndexOf > -1 && (lastIndexOf < (fileName.length()))) {
				name = fileName.substring(lastIndexOf, fileName.length());
			}
		}
		return name;
	}

	/**
	 * @Description 将时、分、秒、转换为秒
	 * @param timeStr 时、分、秒 拼接的串
	 * @return 返回总时长 单位 s， Integer类型
	 */
	public static Integer IntoASecond(String timeStr) {
		String[] strings = timeStr.split(",");
		Integer times = 0;
		if (!strings[0].trim().isEmpty()) {
			Integer t1 = Integer.parseInt(strings[0]);
			times = times + t1 * 60 * 60;
		}
		if (!strings[1].trim().isEmpty()) {
			Integer t2 = Integer.parseInt(strings[1]);
			times = times + t2 * 60;
		}
		if (!strings[2].trim().isEmpty()) {
			Integer t3 = Integer.parseInt(strings[2]);
			times = times + t3;
		}
		return times;
	}
}
