package com.qq986945193.javasetools.thread;

/**	
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.BufferedInputStream;
import java.io.BufferedReader;
/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 
 * TCPSocketServerThread用来处理服务端接受到的信息
 *
 */
public class TcpSocketServerThread extends Thread {
	public Socket socket = null;

	public TcpSocketServerThread(Socket socket) {
		// TODO Auto-generated constructor stub
		this.socket = socket;
	}

	// 线程执行操作,响应客户端的操作
	@Override
	public void run() {
		InputStream inputStream = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		OutputStream oStream = null;
		PrintWriter pWriter = null;

		try {
			// 获取输入流，并读取客户端的信息
			inputStream = socket.getInputStream();
			isr = new InputStreamReader(inputStream);
			br = new BufferedReader(isr);
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("我是服务器，客户端说:" + info);
			}
			// 关闭输入流
			socket.shutdownInput();
			// 获取输出流，告知客户端的请求
			oStream = socket.getOutputStream();
			pWriter = new PrintWriter(oStream);
			pWriter.write("欢迎您客户端");
			// 调用flush()方法将缓冲输出刷新
			pWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// 关闭资源
			try {
				if (pWriter != null) {
					pWriter.close();
				}
				if (oStream != null) {
					oStream.close();
				}
				if (br != null) {
					br.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
