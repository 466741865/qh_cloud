package com.springAop.dongtaidaili;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 封装动态代理  类
 * @author QingHang
 * @date 2017年1月12日
 */
public abstract class DynamicProxy {

	public static Object getProxy(Object object){
		//实例化spring代理工厂
		ProxyFactory factory = new ProxyFactory();
		
		//设置被代理的对象
		factory.setTarget(object);
		
		//添加通知，横切逻辑
		factory.addAdvice(new TimeSpanAdvice());
		
		return factory.getProxy();
	}
}
