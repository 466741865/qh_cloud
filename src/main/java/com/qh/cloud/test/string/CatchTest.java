package com.qh.cloud.test.string;

import com.qh.cloud.utils.ContantStr;

public class CatchTest {

	public static void main(String[] args) {

		getUserKey(11, 34);

	}

	private static String getUserKey(Integer loginId, Integer pl) {
		String idString = null;
		switch (pl) {
			case 0:
				idString = ContantStr.FAN_USER_TOKEN_STRING + loginId;
				break;
			case 1:
				idString = ContantStr.FAN_USER_TOKEN_STRING + "WEB:" + loginId;
				break;
			default:
				idString = ContantStr.FAN_USER_TOKEN_STRING + loginId;
				break;
		}
		return idString;

	}
}
