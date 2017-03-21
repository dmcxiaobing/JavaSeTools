package com.qq986945193.javasetools.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.qq986945193.javasetools.constant.Api;
import com.qq986945193.javasetools.thread.TcpSocketServerThread;

/**
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * TcpServerSocket
 */
public class TcpServerSocket {
	public static void main(String[] args) {
		try {
			// 创建一个服务端socket，即ServerSocket,指定绑定的端口，并监听此端口
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(Api.TCP_SERVER_PORT));
			Socket socket = null;
			// 记录客户端的数量
			int count = 0;
			System.out.println("******TCPServer启动了*******");
			while (true) {
				// 调用accept()方法进行开始监听，等待客户端的连接
				socket = serverSocket.accept();
				// 创建一个新的线程,读取客户端发来的信息
				TcpSocketServerThread serverThread = new TcpSocketServerThread(socket);
				// 启动线程
				serverThread.start();
				count++;
				System.out.println("客户端的数量:" + count);
				InetAddress address = socket.getInetAddress();
				System.out.println("客户端当前的IP是：" + address.getHostAddress());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("TCPServerSocket异常...");
		}
	}
}
