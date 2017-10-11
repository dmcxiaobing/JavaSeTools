package com.qq986945193.javasetools.knowledge;

import org.junit.Test;

public class JavaSe {

	public static void main(String[] args) {
		// 计算商与余数
		System.out.println(34/10);
		System.out.println(30%10);
		// 计算取与分开的结果
		String urlString = "method=findByPage&pc=9";
		int index = urlString.lastIndexOf("&pc=");
		System.out.println(index);
		System.out.println(urlString.substring(0, index));
		
		String str = "a,b,c,,";
		String[] ary = str.split(",");
		// 预期大于 3，结果是 3
		System.out.println(ary.length);
	}
	
	
	
}
