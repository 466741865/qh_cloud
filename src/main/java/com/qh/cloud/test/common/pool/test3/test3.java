package com.qh.cloud.test.common.pool.test3;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;

public class test3 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		list.add("li");
		list.add("qing");
		list.add("hang");
	}

	public void getFactory(String appId) throws Exception {
		PooledFactory factory = new PooledFactory(appId);
		PooledObject object = factory.makeObject();
		GenericObjectPool<Entity> pool = new GenericObjectPool<>(factory);

	}
}
