package com.qq986945193.javasetools.knowledge;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * 
 * String的一些用法简介
 *
 */
public class StringIntroduce {

	public static void main(String[] args) {
		// 转义字符串两边含有双引号
		String str1 = "\"david\"";
		System.out.println("转义字符串两边含有双引号：" + str1);
		// 字符串中间含有双引号
		String str2 = "david\"is\"java";
		System.out.println("字符串中间含有双引号：" + str2);
		// 使用转义字符还可以使字符串包含其他字符
		String str3 = "\\david";
		System.out.println("使用转义字符还可以使字符串包含其他字符：" + str3);
		// 变量使用双引号包括
		String userName = "david";
		userName = "java";
		String str4 = '\"' + userName + '\"';
		System.out.println("变量使用双引号包括:" + str4);
	}
}
