package com.qh.cloud.common.exceptions;

/**
 * @Description 自定义异常
 * @Date 2017年5月11日 下午5:51:43
 * @author QingHang
 * @version 1.0.0
 */
public class CloudException extends RuntimeException {

	private static final long serialVersionUID = -803265746996923662L;

	/**
	 * 错误码
	 */
	private String errorCode;

	/**
	 * 消息是否为属性文件中的ekey
	 */
	private boolean propertiesKey = true;

	/**
	 * @Description 构造一个基本的异常：只有错误信息
	 * @param message 消息
	 */
	public CloudException(String message) {
		super(message);
	}

	/**
	 * @Description 构造一个基本的异常：包含：错误码、消息
	 * @param errorCode 错误码
	 * @param message 消息
	 */
	public CloudException(String errorCode, String message) {
		this(errorCode, message, true);
	}

	/**
	 * @Description 构造一个基本异常，包含异常信息，异常类
	 * @param message 信息描述
	 * @param cause 根异常类（可以存入任何异常）
	 */
	public CloudException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @Description 构造一个基本的异常：包含错误码、异常信息、异常类
	 * @param errorCode 错误码
	 * @param message 异常信息
	 * @param cause 根异常类（可以存入任何异常）
	 */
	public CloudException(String errorCode, String message, Throwable cause) {
		this(errorCode, message, cause, true);
	}

	/**
	 * 构造一个基本异常：包含错误编码、信息、消息是否为属性文件中的Key
	 * @param errorCode 错误编码
	 * @param message 信息描述
	 * @param propertiesKey 消息是否为属性文件中的Key
	 */
	public CloudException(String errorCode, String message, boolean propertiesKey) {
		super(message);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	/**
	 * @Description 构造一个基本异常.
	 * @param errorCode 错误编码
	 * @param message 信息描述
	 * @param cause
	 * @param propertiesKey 消息是否为属性文件中的Key
	 */
	public CloudException(String errorCode, String message, Throwable cause, boolean propertiesKey) {
		super(message, cause);
		this.setErrorCode(errorCode);
		this.setPropertiesKey(propertiesKey);
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public boolean isPropertiesKey() {
		return propertiesKey;
	}

	public void setPropertiesKey(boolean propertiesKey) {
		this.propertiesKey = propertiesKey;
	}

}
