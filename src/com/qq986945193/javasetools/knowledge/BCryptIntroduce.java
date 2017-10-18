package com.qq986945193.javasetools.knowledge;

import com.qq986945193.javasetools.utils.BCryptUtils;

/**
 * Bcrypt的简单用法
 * 
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 */
public class BCryptIntroduce {
	public static void main(String[] args) {
		// 首次定义一个密码
		String password = "password";
		// 核心。通过调用BCrypt类的静态方法hashpw对password进行加密。第二个参数就是我们平时所说的加盐。
		String hashed = BCryptUtils.hashpw(password, BCryptUtils.gensalt());
		// 这个是所谓的加盐后，进行加密。
		//String hashed2 = BCryptUtils.hashpw(password, BCryptUtils.gensalt(12));
		// 输出加密后的字符串
		System.out.println(hashed);
		
		String Authenticator = "password";
		// 对用户后来输入的密码进行比较。如果能够匹配，返回true。
		if (BCryptUtils.checkpw(Authenticator, hashed))
			System.out.println("It matches");
		else
			System.out.println("It does not match");
	}
}
