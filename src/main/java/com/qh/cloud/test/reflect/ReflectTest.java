package com.qh.cloud.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description 反射 的 相关方法
 * @Date 2017年5月24日 上午10:38:37
 * @author QingHang
 * @version 1.0.0
 */
public class ReflectTest {

	/**
	 * 反射中的类
	 * @Description java.lang.Class
	 * @Description java.lang.reflect.Constructor; java.lang.reflect.Field
	 * @Description java.lang.reflect.Method
	 * @Description java.lang.reflect.Modifier
	 */
	public static void main(String[] args) {
		// 调用第一种方法
		getClassReflect1();

		// 调用第二种方法
		getClassReflect2();

		// 调用第三种方法
		getClassReflect3();

	}

	// 第一种 通过 类名获得，
	public static Object getClassReflect1() {

		try {
			// 通过类名查找
			// 前提是 类已经加栽进了虚拟机，否则 使用全类名
			Class class1 = (Class) Class.forName("com.qh.cloud.test.reflect.ReflectModel");

			// 创建 class 所表示的类的一个新实例（对象）
			Object instance = class1.newInstance();// 调用了无参构造

			// 获取所有的属性
			Field[] fields = class1.getDeclaredFields();
			StringBuffer sb = new StringBuffer();// 存储属性
			// 通过追加的方法，将每个属性拼接到此字符串中
			// 最外边的public定义
			// class1.getModifiers() 获取类的修饰符
			sb.append(Modifier.toString(class1.getModifiers()) + " class " + class1.getSimpleName() + "{\n");
			// 里边的每一个属性
			for (Field field : fields) {
				sb.append("\t");// 空格
				sb.append(Modifier.toString(field.getModifiers()) + " ");// 获得属性的修饰符，例如public，static等等
				sb.append(field.getType().getSimpleName() + " ");// 属性的类型的名字
				sb.append(field.getName() + ";\n");// 属性的名字+回车
			}

			sb.append("}");

			System.out.println(sb);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	// 第二种 每个类都有 class属性
	public static Object getClassReflect2() {
		Class class2 = ReflectModel.class;
		Set<String> set = new HashSet<>();

		return null;
	}

	// 第三种 每个类都有一个getClass方法
	public static Object getClassReflect3() {
		ReflectModel model = new ReflectModel("lqh", 100);
		Class class3 = model.getClass();

		return null;
	}

}
