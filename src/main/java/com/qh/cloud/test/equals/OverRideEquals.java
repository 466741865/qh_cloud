package com.qh.cloud.test.equals;

public class OverRideEquals {

	private String aa;

	public OverRideEquals(String aa) {
		this.aa = aa;
	}

	@Override
	public boolean equals(Object obj) {
		return !aa.equals(obj);
	}

}
