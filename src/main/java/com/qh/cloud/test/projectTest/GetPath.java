package com.qh.cloud.test.projectTest;

import java.io.File;

/**
 * @Description 获取路径
 * @Date 2017年5月14日 下午1:43:56
 * @author QingHang
 * @version 1.0.0
 */
public class GetPath {

	public static void main(String[] args) {
		GetPath aa = new GetPath();
		File file = new File(aa.getClass().getResource("/").getPath());
		System.out.println(file.toString());
		String relativelyPath = System.getProperty("user.dir");
		System.out.println("项目路径： " + relativelyPath);
	}

	/**
	 * 获取工程的全路径
	 */
	public static void getProjectPath() {

	}
}
