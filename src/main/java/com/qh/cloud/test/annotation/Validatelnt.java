package com.qh.cloud.test.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 自定义注解
 * @Date 2017年11月12日 上午9:17:21
 * @author QingHang
 * @version 1.0.0
 */

// @Retention的分类：
// RetentionPolicy.RUNTIME ：运行时保留，这样就可以通过反射获取了。
// RetentionPolicy.CLASS ： 在class文件中保留。
// RetentionPolicy.SOURCE : 在原文件中保留。

// @Target 的分类：
// ElementType.CONSTRUCTOR : 构造器。
// ElementType.FIELD ：成员变量。
// ElementType.LOCAL_VARIABLE ： 局部变量。
// ElementType.PACKAGE : 包。
// ElementType.PARAMETER ： 参数
// ElementType.METHOD ： 方法
// ElementType.TYPE : 类、接扣（包括注解类型）或enum声明
@Retention(RetentionPolicy.RUNTIME) // 用于声明注解的生命周期，表示 注解会在什么时期 保留
@Target(ElementType.FIELD) // 用于描述注解的使用范围（可以用在什么地方，）
@Documented // 表示该注解会被作为被标注的公共API，例如：javadoc此类的工具文档
// @Inherited //表示是可以被继承的，
public @interface Validatelnt {

	int maxLength();

	int minLength();
}
