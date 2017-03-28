package com.qq986945193.javasetools.knowledge;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

import com.qq986945193.javasetools.daomin.DavidBean;
import com.sun.javafx.collections.MappingChange.Map;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * BeanUtils的一些用法详解
 *
 */
public class BeanUtilsIntroduce {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		setPropertyMethod();
	}

	/**
	 * 使用beanUtils设置javabean的属性
	 */
	private static void setPropertyMethod() throws IllegalAccessException, InvocationTargetException {
		// TODO Auto-generated method stub
		DavidBean bean = new DavidBean();
		//使用第三方库beanutils操作javabean的属性  支持8种基本类型自动转换
		BeanUtils.setProperty(bean, "name", "java");
		BeanUtils.setProperty(bean, "age", 12);
		BeanUtils.setProperty(bean, "marry", true);
		System.out.println(bean);
		//利用map进行设置javabean的属性
		HashMap map = new HashMap();
		map.put("name", "david");
		map.put("age", 99);
		map.put("marry", false);
		//用map结合填充bean属性时，map关键词和bean属性要一致
		BeanUtils.populate(bean, map);
		System.out.println(bean);
	}
}
