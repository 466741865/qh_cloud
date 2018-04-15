package com.qh.cloud.test.common.pool.test1;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class MyPoolConfig extends GenericObjectPoolConfig {
	// 在构造方法中可以配置参数，一般会在spring的xml文件中配置bean的方式配置对象池信息
	public MyPoolConfig() {
		super();
	}
}
