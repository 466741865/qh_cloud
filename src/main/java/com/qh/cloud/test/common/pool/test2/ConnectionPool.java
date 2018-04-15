package com.qh.cloud.test.common.pool.test2;

import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.impl.GenericKeyedObjectPool;
import org.apache.commons.pool2.impl.GenericKeyedObjectPoolConfig;

public class ConnectionPool extends GenericKeyedObjectPool<String, IflytekConnection> {

	public ConnectionPool(KeyedPooledObjectFactory<String, IflytekConnection> factory) {
		super(factory);
	}

	public ConnectionPool(KeyedPooledObjectFactory<String, IflytekConnection> factory,
			GenericKeyedObjectPoolConfig config) {
		super(factory, config);
	}
}
