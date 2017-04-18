package com.qq986945193.javasetools.knowledge;

import java.util.Arrays;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * array数组的一些用法介绍
 */
public class ArrayIntroduce {

	public static void main(String[] args) {
		ArraySort();
	}

	// 利用sort进行从大小排序
	private static void ArraySort() {
		int[] arrs = { 3, 2, 4, 6, 1 };
		Arrays.sort(arrs);
		System.out.println(Arrays.toString(arrs));
		for (int i : arrs) {
			System.out.println(i);
		}
	
	}

}
