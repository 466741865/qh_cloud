package com.qh.cloud.test.redis;

import redis.clients.jedis.Jedis;

public class redisDemo {

	private static final String IP = "192.168.6.170";

	private static final int PORT = 6379;

	public static void main(String[] args) {
		JedisUtil jedisUtil = JedisUtil.getInstance();
		Jedis jedis = jedisUtil.getJedis(IP, PORT);

		keyOperation(jedis);
	}

	/**
	 * @Description 键操作
	 * @param jedisUtil
	 */
	private static void keyOperation(Jedis jedis) {
		System.out.println("清空数据:" + jedis.flushDB());
		System.out.println("判断某个键是否存在：" + jedis.exists("lqh"));

	}
}
