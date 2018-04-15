package com.qh.cloud.test.common.pool.test2;

/**
 * 数据库链接实现 Created by alanzhang on 2017/12/28.
 */
public interface ConnectionProvider {
	/**
	 * 获得指定配置链接
	 * @param connectionConfig 链接配置
	 * @return
	 * @throws Exception
	 */
	IflytekConnection getConnection(String appId) throws Exception;

	/**
	 * 释放数据库链接
	 * @param connectionConfig 链接配置
	 * @param connection 释放链接
	 */
	void releaseConnection(String appId, IflytekConnection connection);

	/**
	 * 关闭链接
	 * @param connectionConfig 链接配置
	 * @param connection 关闭链接
	 */
	void closeConnection(String appId, IflytekConnection connection);
}
