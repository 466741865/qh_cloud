package com.qh.cloud.test.common.pool.test2;

/**
 * 数据库链接 Created by alanzhang on 2017/12/28.
 */
public class ConnectionProviderImpl implements ConnectionProvider {
	/**
	 * 数据库连接池
	 */
	private ConnectionPool connectionPool;

	public ConnectionProviderImpl(ConnectionPool connectionPool) {
		this.connectionPool = connectionPool;
	}

	public ConnectionProviderImpl() {
		super();
	}

	@Override
	public IflytekConnection getConnection(String appId) throws Exception {
		return this.connectionPool.borrowObject(appId);
	}

	@Override
	public void releaseConnection(String appId, IflytekConnection connection) {
		this.connectionPool.returnObject(appId, connection);
	}

	@Override
	public void closeConnection(String appId, IflytekConnection connection) {
		// TODO Auto-generated method stub
		this.connectionPool.returnObject(appId, connection);
	}

}
