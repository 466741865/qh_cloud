package com.qh.cloud.test.common.pool.test;

import org.apache.commons.pool2.impl.GenericObjectPool;

public class test {

	public static void main(String[] args) {
		StringBufferFactory stringBufferFactory = new StringBufferFactory();
		StringBuffer buffer = new StringBuffer();
		buffer.append("li");
		buffer.append("qing");
		buffer.append("hang");

		stringBufferFactory.wrap(buffer);
		GenericObjectPool<StringBuffer> genericObjectPool = new GenericObjectPool<StringBuffer>(stringBufferFactory);
		genericObjectPool.setMinIdle(2);// 最小空闲资源数，默认值 0
		genericObjectPool.setMaxTotal(3);// 允许创建资源的最大数量，默认值 8
		genericObjectPool.setBlockWhenExhausted(true);// 当资源耗尽时，是否阻塞等待获取资源
		genericObjectPool.setMaxWaitMillis(9000000);// 获取资源时的等待时间，单位毫秒
		ReaderUtil readerUtil = new ReaderUtil(genericObjectPool);

	}

}
