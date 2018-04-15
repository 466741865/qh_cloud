package com.qh.cloud.model.vo;

/**
 * 返回数据类
 * 
 * @author QingHang
 * @date 2017年1月11日
 */
public class ResultData<T> {

	private T data;

	private boolean success = true;

	private String tipMsg;

	private int statusCode = 200;// 200 表示成功

	public ResultData() {
	}

	public ResultData(boolean success, String tipMsg) {
		super();
		this.success = success;
		this.tipMsg = tipMsg;
	}

	public ResultData(T data, boolean success, String tipMsg) {
		super();
		this.data = data;
		this.success = success;
		this.tipMsg = tipMsg;
	}

	public ResultData(T data, boolean success, String tipMsg, int statusCode) {
		super();
		this.data = data;
		this.success = success;
		this.tipMsg = tipMsg;
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getTipMsg() {
		return tipMsg;
	}

	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	@Override
	public String toString() {
		return "ResultData [data=" + data + ", success=" + success + ", tipMsg=" + tipMsg + ", statusCode=" + statusCode
				+ "]";
	}
}
