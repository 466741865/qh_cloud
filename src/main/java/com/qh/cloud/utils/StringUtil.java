package com.qh.cloud.utils;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Pattern;

public class StringUtil {
	private static final Log logger = LogFactory.getLog(StringUtil.class);
	private static final Pattern decimalPattern = Pattern.compile("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+");
	private static final Pattern chinesePattern = Pattern.compile("[\u4e00-\u9fa5]");
    private static final Pattern doublePattern = Pattern.compile("^[0-9]+(.[0-9])?$");
    private static final Pattern integerPattern = Pattern.compile("^[0-9]*$");
	private StringUtil() {

	}

	public static String encode(String source, String from, String to) {
		byte[] bts;
		try {
			bts = source.getBytes(from);
			return new String(bts, to);
		} catch (UnsupportedEncodingException e) {
			logger.error("StringUtil异常",e);
			return null;
		}
	}

	public static boolean isEmpty(String str) {
		return (str == null) || ("".equals(str));
	}
	public static boolean isNull(String s) {
		return s == null || "".equals(s.trim()) || "null".equals(s.trim());
	}



	public static String join(String[] arr, String split) {
		if (arr != null && arr.length > 0) {
			StringBuilder stringBuilder = new StringBuilder();
			for (String s : arr) {
				stringBuilder.append(s).append(split);
			}
			stringBuilder.delete(stringBuilder.length() - split.length(),
					stringBuilder.length());
			return stringBuilder.toString();
		} else {
			return "";
		}
	}
	public static String join(Object[] arr, String split) {
		if (arr != null && arr.length > 0) {
			StringBuilder stringBuilder = new StringBuilder();
			for (Object s : arr) {
				stringBuilder.append(String.valueOf(s)).append(split);
			}
			stringBuilder.delete(stringBuilder.length() - split.length(),
					stringBuilder.length());
			return stringBuilder.toString();
		} else {
			return "";
		}
	}
	public static Properties parseProperties(String data , String split){
		Properties properties = new Properties();
		if(!StringUtil.isEmpty(split) && !StringUtil.isEmpty(data)){
			for (String dd : data.split(split)) {
				String[] d = dd.split("=");
				if(d.length==2){
					properties.put(d[0], d[1]);
				}
			}
		}
		return properties;
	}



	/**
	 * 判断字符串是否为空，不空返回，否则返回默认值
	 * 
	 * @param targetStr
	 *            目标字符串
	 * @param defaultStr
	 *            默认字符串
	 * @return 字符串
	 */
	public static String isEmpty(String targetStr, String defaultStr) {
		if (!StringUtils.isEmpty(targetStr)) {
			return targetStr;
		}
		return defaultStr;
	}

	public static boolean isDecimal(String num){
		return decimalPattern.matcher(num).matches();
	}

	/**
	 * 判断整数（int）
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		return integerPattern.matcher(str).matches();
	}

	/**
	 * 判断浮点数（double和float）
	 * @param str
	 * @return
	 */
	public static boolean isDouble(String str) {
		if (null == str || "".equals(str)) {
			return false;
		}
		return doublePattern.matcher(str).matches();
	}

    public static String getUUID(){
        UUID uuid= UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }

    /**
     * 判断字符串是否包含汉字
     * @param str
     * @return
     */
	public static boolean isContainChinese(String str) {
        if(Tools.isNull(str)) {
            return false;
        }
		return chinesePattern.matcher(str).find();
	}
}
