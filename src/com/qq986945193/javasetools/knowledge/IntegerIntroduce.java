package com.qq986945193.javasetools.knowledge;

import org.junit.Test;

/**
 * 进制转换的一个小功能
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class IntegerIntroduce {

	/**
	 * 进制转换的功能	java中进行二进制，八进制，十六进制，十进制间进行相互转换      
	 */
	@Test
	public void fun1() {
		int num = 2043;
		//十进制转成十六进制：
		System.out.println(Integer.toHexString(num));
		//十进制转成八进制
		System.out.println(Integer.toOctalString(num));
		//十进制转成二进制
		System.out.println(Integer.toBinaryString(num));
		//十六进制转成十进制
		System.out.println(Integer.parseInt("8C",16));
		//System.out.println(Integer.valueOf("0x11",16).toString());
		//八进制转成十进制
		System.out.println(Integer.valueOf("776",8).toString());
		//二进制转十进制
		System.out.println(Integer.valueOf("0101",2).toString());
	}
}
