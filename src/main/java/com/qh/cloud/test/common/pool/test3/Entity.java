package com.qh.cloud.test.common.pool.test3;

/**
 * Created by doulala on 2017/6/8.
 */
public class Entity {

	public Entity() {
	}

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void clear() {
		setId(null);

	}

	@Override
	public String toString() {
		return "Entity [id=" + id + "]";
	}
}
