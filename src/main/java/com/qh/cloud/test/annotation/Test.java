package com.qh.cloud.test.annotation;

import java.lang.reflect.Field;

public class Test {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		Cat cat = new Cat();
		cat.setName("lqh");
		cat.setAge(18);
		// 通过反射进行校验数据
		Class<? extends Cat> class1 = cat.getClass();
		Field[] declaredFields = class1.getDeclaredFields();
		if (declaredFields != null) {
			for (Field field : declaredFields) {
				Validatelnt annotation = field.getDeclaredAnnotation(Validatelnt.class);
				if (annotation != null) {
					field.setAccessible(true);
					int int1 = field.getInt(cat);
					if (int1 < annotation.minLength()) {
						System.out.println("11::" + int1);
					} else {
						System.out.println("22：；" + int1);
					}
				}

			}
		}
	}
}
