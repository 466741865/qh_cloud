package com.qh.cloud.test.common.pool.test1;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

/**
 * @Description 对象池工厂
 * @Date 2018年3月14日 上午11:45:33
 * @author QingHang
 * @version 1.0.0
 */
public class PersonFactory extends BasePooledObjectFactory<Person> {

	private ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>();

	public PersonFactory() {
		// 从配置文件读，初始化到map
		Person person1 = new Person();
		person1.setName("li");
		person1.setUse(false);
		map.put("1", person1);
		Person person2 = new Person();
		person2.setName("qing");
		person2.setUse(false);
		map.put("2", person2);
		Person person3 = new Person();
		person3.setName("hang");
		person3.setUse(false);
		map.put("3", person3);
	}

	@Override
	public Person create() throws Exception {
		// String name = new Random().nextInt(20) + "";
		// Person p = new Person();
		// p.setName(name);
		Person p = null;
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		for (Entry<String, Object> entry : map.entrySet()) {
			Person object = (Person) entry.getValue();
			object.toString();
			System.out.println("duixiang :" + entry.getValue());
			if (!object.isUse()) {
				p = object;
				object.setUse(true);
				System.out.println("创建对象：" + p.toString());
				map.remove(entry.getKey(), entry.getValue());
				break;
			}
		}
		return p;
	}

	@Override
	public PooledObject<Person> wrap(Person obj) {
		return new DefaultPooledObject<Person>(obj);
	}

	@Override
	public void passivateObject(PooledObject<Person> p) throws Exception {
		super.passivateObject(p);
		System.out.println("passivate Object: " + p.toString());
	}

	/**
	 * 功能描述：判断资源对象是否有效，有效返回 true，无效返回 false。
	 * @什么时候会调用此方法
	 * @1：从资源池中获取资源的时候，参数 testOnBorrow 或者 testOnCreate 中有一个 配置 为 true 时，则调用 factory.validateObject()
	 *                    方法
	 * @2：将资源返还给资源池的时候，参数 testOnReturn，配置为 true 时，调用此方法 3：资源回收线程，回收资源的时候，参数 testWhileIdle，配置为 true
	 *                    时，调用此方法
	 */
	// @Override
	// public boolean validateObject(PooledObject<Person> arg0) {
	// System.out.println("validate Object");
	// return true;
	// }

}
