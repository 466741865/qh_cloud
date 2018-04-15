package com.qh.cloud.test.common.pool.test2;

import org.apache.commons.pool2.BaseKeyedPooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class ConnectionFactory extends BaseKeyedPooledObjectFactory<String, IflytekConnection> {

	private String appId;

	public ConnectionFactory() {
		super();
	}

	public ConnectionFactory(String appId) {
		this.appId = appId;
	}

	private synchronized void initialize(String appId) {
		this.appId = appId;
	}

	@Override
	public IflytekConnection create(String appId) throws Exception {
		this.appId = appId;
		IflytekConnection connection = new IflytekConnection();
		connection.setAPP_ID(appId);
		return connection;
	}

	@Override
	public PooledObject<IflytekConnection> wrap(IflytekConnection value) {
		return new DefaultPooledObject<IflytekConnection>(value);
	}

	@Override
	public PooledObject<IflytekConnection> makeObject(String appId) throws Exception {
		return super.makeObject(appId);
	}

	@Override
	public void destroyObject(String key, PooledObject<IflytekConnection> p) throws Exception {
		super.destroyObject(key, p);
	}

	/**
	 * 检测一个对象是否有效
	 * @param connectionConfig 链接配置
	 * @param pooledObject 池对象
	 * @throws Exception
	 */
	@Override
	public void activateObject(String appId, PooledObject<IflytekConnection> pooledObject) throws Exception {
		super.activateObject(appId, pooledObject);
	}

	/**
	 * 归还对象时处理
	 * @param connectionConfig 链接配置
	 * @param pooledObject 池对象
	 * @throws Exception
	 */
	@Override
	public void passivateObject(String appId, PooledObject<IflytekConnection> pooledObject) throws Exception {
		super.passivateObject(appId, pooledObject);
	}
}
