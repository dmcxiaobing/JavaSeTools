package com.qq986945193.javasetools.knowledge;

import com.qq986945193.javasetools.daomin.DavidBean;

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
	public static void main(String[] args) throws ClassNotFoundException {
		getClasssTen();
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
