package com.qh.cloud.test.common.pool.test3;

import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class DemoEntity {

	private ConcurrentHashMap<String, Entity> map = new ConcurrentHashMap<>();

	private static DemoEntity demoEntity = new DemoEntity();

	PooledFactory factory = new PooledFactory(); // 创建PooledObjectFactory

	GenericObjectPool<Entity> pool = new GenericObjectPool<Entity>(factory); // 创建对象池

	private DemoEntity() {
	}

	private static DemoEntity getInstace() {
		return demoEntity;
	}

}
