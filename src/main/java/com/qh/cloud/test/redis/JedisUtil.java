package com.qh.cloud.test.redis;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description redis 工具类
 * @Date 2017年10月11日 下午5:09:38
 * @author QingHang
 * @version 1.0.0
 */
public class JedisUtil {

	private Logger logger = LoggerFactory.getLogger(JedisUtil.class);

	private JedisUtil() {
	}

	private static class RedisUtilHolder {
		private static final JedisUtil instance = new JedisUtil();
	}

	public static JedisUtil getInstance() {
		return RedisUtilHolder.instance;
	}

	private static Map<String, JedisPool> map = new HashMap<>();

	private static JedisPool getPool(String ip, int port) {

		String key = ip + ":" + port;
		JedisPool pool = null;
		if (!map.containsKey(key)) {
			JedisPoolConfig config = new JedisPoolConfig();
			config.setMaxTotal(-1);
			config.setMaxIdle(RedisConfig.MAX_IDLE);
			config.setMaxWaitMillis(RedisConfig.MAX_WAIT);
			config.setTestOnBorrow(true);
			config.setTestOnReturn(true);

			pool = new JedisPool(config, ip, port, RedisConfig.TIMEOUT);
			map.put(key, pool);
		} else {
			pool = map.get(key);
		}

		return pool;
	}

	/**
	 * @Description 获取jedis对象
	 * @param ip
	 * @param port
	 * @return
	 */
	public Jedis getJedis(String ip, int port) {
		Jedis jedis = null;
		int count = 0;
		do {
			try {
				jedis = getPool(ip, port).getResource();
			} catch (Exception e) {
				logger.error("get redis master1 failed!", e);
				getPool(ip, port).returnBrokenResource(jedis);
			}
		} while (jedis == null && count < RedisConfig.RETRY_NUM);
		return jedis;
	}

	/**
	 * @Description 关闭链接
	 * @param jedis
	 * @param ip
	 * @param port
	 */
	public void closeJedis(Jedis jedis, String ip, int port) {
		if (jedis != null) {
			getPool(ip, port).returnResource(jedis);
		}
	}

}
