package com.springAop.dongtaidaili;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 动态代理 测试
 * 
 * @author QingHang
 * @date 2017年1月12日
 */
public class Test {

	/**
	 * 未封装 代理工厂
	 * @return void 
	 * @throws
	 */
	@org.junit.Test
	public void Test() {
		// 实例化spring 代理工厂
		ProxyFactory factory = new ProxyFactory();
		// 设置被代理对象
		factory.setTarget(new Math());

		// 添加通知 横切逻辑
		factory.addAdvice(new BeforeAdvice());
		factory.addAdvice(new AfterAdvice());
		factory.addAdvice(new SurroundAdvice());

		// 从代理工厂中获得代理对象
		Math math = (Math) factory.getProxy();

		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);

	}
	
	
	/**
	 * 封装 代理工厂
	 * @return void 
	 * @throws
	 */
	@org.junit.Test
	public void test01(){
		//从代理工厂中获取代理对象
		Math math = (Math) DynamicProxy.getProxy(new Math());
		
		int n1 = 100, n2 = 5;
		math.add(n1, n2);
		math.sub(n1, n2);
		math.mut(n1, n2);
		math.div(n1, n2);
	}
	
	
	
	
	
	
	
	

}
