package com.springAop.dongtaidaili;

import java.util.Random;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 用于完成计算方法执行时长的环绕通知
 * 
 * @author QingHang
 * @date 2017年1月12日
 */
public class TimeSpanAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// 被织入的横切内容 ，开始时间before
		long start = System.currentTimeMillis();
		//随机延时
		lazy();

		//方法调用
		Object proceed = invocation.proceed();
		
		//被织入的横切内容，结束时间
		Long span = System.currentTimeMillis() - start;
		System.out.println("共用时：   "+span);
		
		return proceed;
	}

	/**
	 * 模拟延时 @return void @throws
	 */
	private void lazy() {
		try {
			int nextInt = new Random().nextInt(500);
			Thread.sleep(nextInt);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
