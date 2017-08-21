package com.qq986945193.javasetools.knowledge;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * Date的使用简单介绍
 */
public class DateIntroduce {
	/**
	 * 获取当前时间，精确到毫秒
	 */
	@Test
	public void getCurrentTimeMillion() {
		System.out.println(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()));
		// method 1
		Calendar nowtime = new GregorianCalendar();
		String strDateTime = "[" + String.format("%04d", nowtime.get(Calendar.YEAR)) + "/"
				+ String.format("%02d", nowtime.get(Calendar.MONTH)) + "/"
				+ String.format("%02d", nowtime.get(Calendar.DATE)) + " "
				+ String.format("%02d", nowtime.get(Calendar.HOUR)) + ":"
				+ String.format("%02d", nowtime.get(Calendar.MINUTE)) + ":"
				+ String.format("%02d", nowtime.get(Calendar.SECOND)) + "."
				+ String.format("%03d", nowtime.get(Calendar.MILLISECOND)) + "]";
		System.out.println(strDateTime);

		// method 2
		String msg = "";
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss.SSS");
		msg += "[" + sdf.format(date) + "]";

		System.out.println(msg);

	}
}
