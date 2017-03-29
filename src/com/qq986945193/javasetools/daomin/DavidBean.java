package com.qq986945193.javasetools.daomin;

/* @Author ：程序员小冰
* @新浪微博 ：http://weibo.com/mcxiaobing
* @GitHub: https://github.com/QQ986945193
* @CSDN博客: http://blog.csdn.net/qq_21376985
* @OsChina空间: https://my.oschina.net/mcxiaobing
*/
/**
 * 一个普通的javaBean
 */
public class DavidBean {
	private String name;
	private int age;
	private boolean marry;

	public DavidBean(String name, int age, boolean marry) {
		super();
		this.name = name;
		this.age = age;
		this.marry = marry;
	}

	public DavidBean(String name) {
		super();
		this.name = name;
	}

	public DavidBean() {
		super();
		System.out.println("我是无参构造方法");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isMarry() {
		return marry;
	}

	public void setMarry(boolean marry) {
		this.marry = marry;
	}

	@Override
	public String toString() {
		return "DavidBean [name=" + name + ", age=" + age + ", marry=" + marry + "]";
	}

}
