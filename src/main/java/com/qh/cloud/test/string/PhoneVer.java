package com.qh.cloud.test.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description 手机号校验
 * @Date 2017年12月26日 下午3:55:44
 * @author QingHang
 * @version 1.0.0
 */
public class PhoneVer {

	public static void main(String[] args) {
		System.out.println(isMobile("13281890246"));
	}

	/**
	 * 手机号验证
	 * @author ：shijing 2016年12月5日下午4:34:46
	 * @param str
	 * @return 验证通过返回true
	 */
	public static boolean isMobile(String str) {
		Pattern p = null;
		Matcher m = null;
		boolean b = false;
		p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
		m = p.matcher(str);
		b = m.matches();
		return b;
	}

}
