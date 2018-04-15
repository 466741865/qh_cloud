package com.qh.cloud.test.exception;

/**
 * @Description try catch
 * @Date 2017年9月28日 下午8:30:54
 * @author QingHang
 * @version 1.0.0
 */
public class TryCatch {

	public static void main(String[] args) {
		test();
	}

	public static int test() {
		try {
			int i = 1 / 0;
			return 1;
		} catch (Exception e) {
			throw new Exception("这又有异常");
		} finally {
			System.out.println("需要解决");
			return 11;
		}
	}

}
