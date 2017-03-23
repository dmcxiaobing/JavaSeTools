package com.qq986945193.javasetools.knowledge;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * 
 * @author David Zheng
 * 
 *         IO流的一些复制读取操作详解代码。IO知识点详解
 * 
 *         1.读文件的时候，文件目录一定要存在，否则会抛出异常，文件目录不存在。 2.写文件的时候，会自动创建文件。
 * 
 */
public class IoIntroduce {
    /**
     * ①字节流复制文件(FileInputStream/FileOutputStream和BufferedInputSream/
     * BufferedOutputStream/DataInputStream/DataOutputStream/)
     * ②字符流复制文件(InputStreamReader/OutputStreamWriter、FileReader
     * /FileWriter、BufferedReader/BufferedWriter)
     * BufferedReader/BufferedWriter字符缓冲区流有三种方法，多了一种可以直接读取一行，一次写入一个字符串。其它都是两种方法。
     * 
     */
    public static void main(String[] args) throws Exception {
	// 字节流 FileInputStream是InputStream的子类
	FileInputStream fis = new FileInputStream("david.txt");
	FileOutputStream fos = new FileOutputStream("xiaobing.txt");

	// 字节缓冲区流
	BufferedInputStream bis = new BufferedInputStream(new FileInputStream(
		"david.txt"));
	BufferedOutputStream bos = new BufferedOutputStream(
		new FileOutputStream("xiaobing.txt"));

	// 字符流
	InputStreamReader isr = new InputStreamReader(new FileInputStream(
		"david.txt"));
	OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
		"xiaobing.txt"));
	// InputStreamReader是FileReader的父类，FileReader是InputStreamReader的简化版
	FileReader fr = new FileReader("newfile.java");
	FileWriter fw = new FileWriter("newfile.java");

	// 字符缓冲区流
	BufferedReader br = new BufferedReader(new FileReader("newfile.java"));
	BufferedWriter bw = new BufferedWriter(new FileWriter("newfile.java"));

	// 字节流使用方法
	copyInputStream1(fis, fos);
	copyInputStream2(fis, fos);
	// 缓冲字节流使用方法
	copyBufferedInputStream1(bis, bos);
	copyBufferedInputStream2(bis, bos);

	// 字符流使用方法
	copyInputStreamReader1(isr, osw);
	copyInputStreamReader2(isr, osw);
	// 普通方法读取字符流
	copyFileReader1(fr, fw);
	copyFileReader2(fr, fw);

	// 使用缓冲字符流
	copyBufferedReader1(br, bw);
	copyBufferedReader2(br, bw);
	copyBufferedReader3(br, bw);

    }

    /**
     * 字节读取方法 1 使用字节流一次读取一个字节
     */
    private static void copyInputStream1(FileInputStream fis,
	    FileOutputStream fos) throws IOException {
	// 一次读取一个字节 使用字节流
	int bys = 0;
	while ((bys = fis.read()) != -1) {
	    fos.write(bys);
	    fos.flush();
	}
	// 关闭流
	if (fos != null) {
	    fos.close();
	}
	if (fis != null) {
	    fis.close();
	}
    }

    /**
     * 字节读取方法2 使用字节流一次读取一个字节数组
     */
    private static void copyInputStream2(FileInputStream fis,
	    FileOutputStream fos) throws IOException {
	// 一次读取一个字节数组 即 一次读取1024个字节 使用字节流
	byte[] datas = new byte[1024];
	int len = 0;
	while ((len = fis.read(datas)) != -1) {
	    fos.write(datas, 0, len);
	    fos.flush();
	}
	// 关闭流
	if (fos != null) {
	    fos.close();
	}
	if (fis != null) {
	    fis.close();
	}
    }

    /**
     * 1字节流读取方法 一次读取一个字节，使用缓冲字节流
     */
    private static void copyBufferedInputStream1(BufferedInputStream bis,
	    BufferedOutputStream bos) throws IOException {
	// 一次读取一个字节，使用缓冲字节流 缓冲流可不关闭
	int bys = 0;
	while ((bys = bis.read()) != -1) {
	    bos.write(bys);
	    bos.flush();
	}
    }

    /**
     * 2字节流读取方法 一次读取一个字节数组，使用缓冲字节流
     * 
     */
    private static void copyBufferedInputStream2(BufferedInputStream bis,
	    BufferedOutputStream bos) throws IOException {
	// 一次读取一个字节数组 即 一次读取1024个字节 使用缓冲字节流
	byte[] datas = new byte[1024];
	int len = 0;
	while ((len = bis.read(datas)) != -1) {
	    bos.write(datas, 0, len);
	    bos.flush();
	}
	// 关闭流
	if (bos != null) {
	    bos.close();
	}
	if (bis != null) {
	    bis.close();
	}
    }

    /**
     * 1,字符流读取方法 使用字符流一次读取一个字符
     */
    private static void copyInputStreamReader1(InputStreamReader isr,
	    OutputStreamWriter osw) throws IOException {
	// 一次读取一个字符
	// InputStreamReader是FileReader的父类
	int len = 0;
	while ((len = isr.read()) != -1) {
	    osw.write(len);
	    osw.flush();
	}
	// 关闭流
	if (osw != null) {
	    osw.close();
	}
	if (isr != null) {
	    isr.close();
	}

    }

    /**
     * 2,字符流读取方法 一次读取一个字符数组，使用字符流
     * 
     */
    private static void copyInputStreamReader2(InputStreamReader isr,
	    OutputStreamWriter osw) throws IOException {
	// 一次读取一个字符数组 即 一次读取1024个字符
	char[] datas = new char[1024];
	int len = 0;
	while ((len = isr.read()) != -1) {
	    osw.write(datas, 0, len);
	    osw.flush();
	}
	// 关闭流
	if (osw != null) {
	    osw.close();
	}
	if (isr != null) {
	    isr.close();
	}

    }

    /**
     * 1,普通字符流读取方法 使用字符流一次读取一个字符
     */
    private static void copyFileReader1(FileReader fr, FileWriter fw)
	    throws IOException {
	// 普通方法 使用字符流一次读取一个字符
	int len = 0;
	while ((len = fr.read()) != -1) {
	    fw.write(len);
	    fw.flush();
	}
	// 关闭流
	if (fw != null) {
	    fw.close();
	}
	if (fr != null) {
	    fr.close();
	}
    }

    /**
     * 2,普通字符流读取方法 一次读取一个字符数组，使用字符流
     */
    private static void copyFileReader2(FileReader fr, FileWriter fw)
	    throws IOException {
	// 普通方法 一次读取一个字符数组，使用字符流 一次读取1024个字符
	char[] datas = new char[1024];
	int len = 0;
	while ((len = fr.read(datas)) != -1) {
	    fw.write(datas, 0, len);
	    fw.flush();
	}
	// 关闭流
	if (fw != null) {
	    fw.close();
	}
	if (fr != null) {
	    fr.close();
	}

    }

    /**
     * 1,缓冲字符流 一次读取一个字符
     */
    private static void copyBufferedReader1(BufferedReader br, BufferedWriter bw)
	    throws IOException {
	// 缓冲字符流 一次读取一个字符
	int len = 0;
	while ((len = br.read()) != -1) {
	    bw.write(len);
	    bw.flush();
	}
	// 关闭流
	if (bw != null) {
	    bw.close();
	}
	if (br != null) {
	    br.close();
	}
    }

    /**
     * 2,缓冲字符流 一次读取一个字符数组
     */
    private static void copyBufferedReader2(BufferedReader br, BufferedWriter bw)
	    throws IOException {
	// 缓冲字符流 一次读取一个字符数组 即一次读取1024个字符
	char[] datas = new char[1024];
	int len = 0;
	while ((len = br.read(datas)) != -1) {
	    bw.write(datas, 0, len);
	    bw.flush();
	}
	// 关闭流
	if (bw != null) {
	    bw.close();
	}
	if (br != null) {
	    br.close();
	}
    }

    /**
     * 3,缓冲字符流 一次读取一行
     */
    private static void copyBufferedReader3(BufferedReader br, BufferedWriter bw)
	    throws IOException {
	// 使用缓冲字符流，一次读取一行
	String len = null;
	while ((len = br.readLine()) != null) {
	    bw.write(len);
	    bw.newLine();
	    bw.flush();
	}
	// 关闭流
	if (bw != null) {
	    bw.close();
	}
	if (br != null) {
	    br.close();
	}

    }
}
