package com.qq986945193.javasetools.knowledge;

import org.junit.Test;

public class JavaSe {

	public static void main(String[] args) {
		System.out.println(34/10);
		System.out.println(30%10);
		String urlString = "method=findByPage&pc=9";
		int index = urlString.lastIndexOf("&pc=");
		System.out.println(index);
		System.out.println(urlString.substring(0, index));
	}
}
