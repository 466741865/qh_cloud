package com.qh.cloud.test.MD5;

import com.qh.cloud.utils.MD5Util;

/**
 * @Description MD5 测试类
 * @Date 2017年7月24日 下午5:01:24
 * @author QingHang
 * @version 1.0.0
 */
public class MD5Utils {

	public static void main(String[] args) {
		String pwd = "gdkj2017!";
		String string = MD5Util.MD5Encode(pwd);
		System.out.println(string);
	}

}
