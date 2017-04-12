package com.qq986945193.javasetools.utils;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * 进制转换的工具类 
 */
public class EncodingUtils {

	/**
	 * 将十进制数字转化为二进制
	 */
	public static String getBinaryString(int num) {
		return Integer.toBinaryString(num);
	}
	/**
	 * 将十进制数字转化为十六进制
	 */
	public static String getHexString(int num) {
		return Integer.toHexString(num);
	}
	
	/**
	 * 将十六进制字符串转化为十进制数字
	 */
	public static int getDecimalNum(String num) {
		return Integer.parseInt(num,16);
		
	}
}
