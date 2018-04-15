package com.qh.cloud.test.common.pool.test2;

public class Test {

	public static void main(String[] args) {
		ConnectionPoolConfig connectionPoolConfig = new ConnectionPoolConfig();
		connectionPoolConfig.setMaxTotalPerKey(3);
		connectionPoolConfig.setMaxTotal(3);

		ConnectionFactory connectionFactory = new ConnectionFactory();
		String appId = "123456";
		try {
			connectionFactory.create(appId);
			ConnectionPool connectionPool = new ConnectionPool(connectionFactory, connectionPoolConfig);
			// 获取对象
			IflytekConnection iflytekConnection = connectionPool.borrowObject(appId);
			System.out.println("测试::" + iflytekConnection.getAPP_ID());
			IflytekConnection iflytekConnection1 = connectionPool.borrowObject(appId);
			System.out.println("再次获取：：" + iflytekConnection1.getAPP_ID());
			// 返还对象
			// connectionPool.returnObject(appId, iflytekConnection);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
