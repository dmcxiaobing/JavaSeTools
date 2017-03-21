package com.qq986945193.javasetools.socket;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import com.qq986945193.javasetools.constant.Api;

/**	
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * TcpClientSocket
 */
public class TcpClientSocket {
	public static void main(String[] args) {
		InputStream iStream = null;
		Socket socket = null;
		OutputStream outputStream = null;
		PrintWriter pwriter = null;
		BufferedReader br = null;
		try {
			// 创建客户端Socket，指定服务器地址和端口
			socket = new Socket(Api.LOCAL_HOST,
					Integer.parseInt(Api.TCP_SERVER_PORT));
			// 获取输出流，向服务端发送消息
			outputStream = socket.getOutputStream();
			pwriter = new PrintWriter(outputStream);
			pwriter.write("username：david,password:qq986945193");
			pwriter.flush();
			// 关闭输出流
			socket.shutdownOutput();
			/**
			 * 获取输入流，并且读取服务端的响应信息
			 */
			iStream = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(iStream));
			String info = null;
			while ((info = br.readLine()) != null) {
				System.out.println("服务器说:" + info);
			}
			br.close();
			iStream.close();
			pwriter.close();
			outputStream.close();
			socket.close();

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
				}
				if (iStream != null) {
					iStream.close();
				}
				if (pwriter != null) {
					pwriter.close();
				}
				if (outputStream != null) {
					outputStream.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

	}
}
