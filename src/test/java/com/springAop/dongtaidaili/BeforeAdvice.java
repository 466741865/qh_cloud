package com.springAop.dongtaidaili;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

/**
 * spring aop 动态代理 前置通知
 * 
 * @author QingHang
 * @date 2017年1月12日
 */
public class BeforeAdvice implements MethodBeforeAdvice {

	/**
	 * @method 方法信息
	 * @args 参数
	 * @target 被代理的目标对象
	 */
	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.println("前置通知");
	}

}
