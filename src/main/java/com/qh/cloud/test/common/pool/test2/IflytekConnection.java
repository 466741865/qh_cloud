package com.qh.cloud.test.common.pool.test2;

import java.io.Serializable;

public class IflytekConnection implements Serializable {

	private static final long serialVersionUID = -4440482378535819771L;

	private String APP_ID;

	private String DEF_VOICE_NAME;

	private String DEF_SPEED;

	private String DEF_PITCH;

	private String DEF_VOLUME;

	public String getAPP_ID() {
		return APP_ID;
	}

	public void setAPP_ID(String aPP_ID) {
		APP_ID = aPP_ID;
	}

	public String getDEF_VOICE_NAME() {
		return DEF_VOICE_NAME;
	}

	public void setDEF_VOICE_NAME(String dEF_VOICE_NAME) {
		DEF_VOICE_NAME = dEF_VOICE_NAME;
	}

	public String getDEF_SPEED() {
		return DEF_SPEED;
	}

	public void setDEF_SPEED(String dEF_SPEED) {
		DEF_SPEED = dEF_SPEED;
	}

	public String getDEF_PITCH() {
		return DEF_PITCH;
	}

	public void setDEF_PITCH(String dEF_PITCH) {
		DEF_PITCH = dEF_PITCH;
	}

	public String getDEF_VOLUME() {
		return DEF_VOLUME;
	}

	public void setDEF_VOLUME(String dEF_VOLUME) {
		DEF_VOLUME = dEF_VOLUME;
	}

}
