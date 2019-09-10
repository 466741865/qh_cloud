package com.qh.cloud.test.exception;



import java.util.ArrayList;
import java.util.List;

/**
 * @Description 异常测试类
 * @Date 2017年9月26日 下午3:58:50
 * @author QingHang
 * @version 1.0.0
 */
public class ExceptionTest {

	public void test1() {

		System.out.println("==========");

		int i = 1 / 0;
		System.out.println("------------");
	}

	public void test2() {

		System.out.println("+++++++++");

		throw new RuntimeException();

		// System.out.println("```````````");

	}


	public static void main(String[] args) {

		System.out.println("+++111111++++++");
//		List<String> result = getTest();
		System.out.println("+++111111++++++");
	}



	public  static List<String> getTest(){
		List<String> list = new ArrayList<>();
		try{
			System.out.println("+++111111++++++");
			int i = 1 / 0;
		}catch (Exception e){
			System.out.println("+++3233333++++++");
		}
		return list;
	}

	public static void getLists(){
		List<String> list = new ArrayList<>();


	}


}
