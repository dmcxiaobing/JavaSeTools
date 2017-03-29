package com.qq986945193.javasetools.knowledge;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.qq986945193.javasetools.daomin.DavidBean;

import sun.net.www.content.text.plain;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * 反射的详解
 */
public class ReflectIntroduce {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		getClasssTen();
		getConsMethod();
	}

	// 反射类的构造方法,创建类的对象
	private static void getConsMethod() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Class clazz = Class.forName("com.qq986945193.javasetools.daomin.DavidBean");
		Constructor constructor = clazz.getConstructor(null);
		//得到类的对象
		DavidBean bean = (DavidBean) constructor.newInstance(null);
		bean.setName("reflect");
		System.out.println(bean.getName());
		
		DavidBean entity = (DavidBean) constructor.newInstance("entity");
		System.out.println(entity.getName());
		
	}

	// 通过反射，获得类的字节码
	private static void getClasssTen() throws ClassNotFoundException {
		Class className = Class.forName("com.qq986945193.javasetools.daomin.DavidBean");
		System.out.println(className);
		Class clazz = new DavidBean().getClass();
		System.out.println(clazz);
		Class clazz2 = DavidBean.class;
		System.out.println(clazz2);
	}

}
