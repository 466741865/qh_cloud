package com.springAop.dongtaidaili;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * spring aop 动态代理
 * 环绕通知
 * 方法拦截器
 * @author QingHang
 * @date 2017年1月12日
 */
public class SurroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation i) throws Throwable {
		//前置横切逻辑
		System.out.println("方法："+i.getMethod()+"  被调用 在对象："+i.getThis()+"上，参数："+i.getArguments());
	
		//方法调用
		Object proceed = i.proceed();
		//后置横切逻辑
		System.out.println("返回值："+proceed);
		return proceed;
	}

}
