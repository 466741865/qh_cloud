package com.qh.cloud.test.common.pool;

import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class ThreadTest {

	public static void main(String[] args) {
		// 工厂
		LpPoolFactory factory = new LpPoolFactory();

		// 资源池配置
		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
		poolConfig.setMinIdle(2);// 最小空闲资源数，默认值 0
		poolConfig.setMaxTotal(3);// 允许创建资源的最大数量，默认值 8
		poolConfig.setBlockWhenExhausted(true);// 当资源耗尽时，是否阻塞等待获取资源
		poolConfig.setMaxWaitMillis(9000000);// 获取资源时的等待时间，单位毫秒

		// 创建资源池
		GenericObjectPool<User> objectPool = new GenericObjectPool<User>(factory, poolConfig);
		for (int i = 0; i < 3; i++) {
			try {
				Thread.sleep(1000);
				// 获取资源对象
				User user = objectPool.borrowObject();
				// 将获取的资源对象，返还给资源池
				objectPool.returnObject(user);
				// 输出资源对象
				System.out.println(user);
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
