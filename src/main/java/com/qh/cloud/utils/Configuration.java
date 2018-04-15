package com.qh.cloud.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * properties文件操作类
 * 
 * @author QingHang
 * @date 2017年1月11日
 */
public class Configuration {
	private static Logger logger = LoggerFactory.getLogger(Configuration.class);

	static Properties properties = new Properties();

	public static Configuration config = null;

	private Configuration() {
		try {
			InputStream inputStream = Configuration.class.getResourceAsStream("/properties/config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			logger.error("Fail to load properties file.file=/properties/config.properties", e);
		}
	}

	public synchronized static Configuration getInstance() {
		if (config == null) {
			config = new Configuration();
		}
		return config;
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

	public String getString(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public int getInt(String key) {
		return Integer.valueOf(properties.getProperty(key));
	}

	public int getInt(String key, String defaultValue) {
		return Integer.valueOf(properties.getProperty(key, defaultValue));
	}

	public double getDouble(String key) {
		return Double.valueOf(properties.getProperty(key));
	}

	public double getDouble(String key, String defaultValue) {
		return Double.valueOf(properties.getProperty(key, defaultValue));
	}

	public long getLong(String key) {
		return Long.parseLong(properties.getProperty(key));
	}

	public long getLong(String key, String defaultValue) {
		return Long.parseLong(properties.getProperty(key, defaultValue));
	}

	public boolean getBoolean(String key) {
		return Boolean.valueOf(properties.getProperty(key));
	}

	public boolean getBoolean(String key, String defaultValue) {
		return Boolean.valueOf(properties.getProperty(key, defaultValue));
	}
}