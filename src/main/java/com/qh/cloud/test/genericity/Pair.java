package com.qh.cloud.test.genericity;

/**
 * @Description 泛型测试，泛型方法测试实体
 * @Date 2017年7月13日 上午11:12:50
 * @author QingHang
 * @version 1.0.0
 */
public class Pair<K, V> {

	private K key;

	private V value;

	public Pair(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
