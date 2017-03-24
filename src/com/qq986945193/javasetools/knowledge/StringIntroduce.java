package com.qq986945193.javasetools.knowledge;

public class StringIntroduce {
	public static void main(String[] args) {
		// 转义字符串两边含有双引号
		String str1 = "\"david\"";
		// 字符串中间含有双引号
		String str2 = "david \"is\" java";
		// 使用转义字符还可以使字符串包含其他字符
		String str3 = "\\david";

		System.out.println("字符串一：" + str1);
		System.out.println("字符串二：" + str2);
		System.out.println("字符串三：" + str3);
	}
}
