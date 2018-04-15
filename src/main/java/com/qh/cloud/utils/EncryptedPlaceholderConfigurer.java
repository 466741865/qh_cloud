package com.qh.cloud.utils;

import java.util.Properties;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 解密 properties 配置文件中的密码
 * @Description: bean工厂后置处理器的实现 （用于加载配置文件中的信息）
 * @author QingHang
 * @date: 2017年2月24日
 */
public class EncryptedPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	public static final String PREFIX = "{{";

	@Override
	protected String convertPropertyValue(String originalValue) {
		if (originalValue.startsWith(PREFIX)) {
			logger.debug("Find encrypted value:" + originalValue);
			String newValue = originalValue.substring(2, originalValue.length() - 2);
			try {
				DESUtil DESUtil2 = new DESUtil("lqh");
				newValue = DESUtil2.decrypt(newValue);
				return newValue;
			} catch (Exception e) {
				logger.error("解密配置文件出现错误");
				e.printStackTrace();
			}
		}
		return originalValue;
	}
}
