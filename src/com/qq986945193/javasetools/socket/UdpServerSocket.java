package com.qq986945193.javasetools.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import com.qq986945193.javasetools.constant.Api;
import com.sun.media.sound.DataPusher;

/**	
 * @Author ：程序员小冰
 * @新浪微博 ：http://weibo.com/mcxiaobing
 * @GitHub: https://github.com/QQ986945193
 * @CSDN博客: http://blog.csdn.net/qq_21376985
 * @OsChina空间: https://my.oschina.net/mcxiaobing
 */
/**
 * udpserver服务端，用来简单演示基于UDP实现用户登录。
 */
public class UdpServerSocket {
	public static void main(String[] args) throws NumberFormatException,
			IOException {
		/**
		 * 接收客户端发送的数据
		 */
		// 1,创建服务端DatagramSocke，指定端口
		DatagramSocket socket = new DatagramSocket(
				Integer.parseInt(Api.TCP_SERVER_PORT));
		// 2,创建数据报，用于接收客户端发送的数据
		// 创建字节数组，指定接收的数据包的大小
		byte[] data = new byte[1024];
		DatagramPacket packet = new DatagramPacket(data, data.length);
		// 3,接收客户端发送的数据
		System.out.println("服务器端已经启动，等待客户端发送数据");
		// 接收客户端发送的数据，此方法在接收到数据报之前会一直阻塞
		socket.receive(packet);
		// 读取数据，解析客户端的数据
		String info = new String(data, 0, data.length);
		System.out.println("我是服务器，客户端说：" + info);
		/**
		 * 向客户端响应数据
		 */
		// 定义客户端的地址，端口号，数据
		InetAddress inetAddress = packet.getAddress();
		int port = packet.getPort();
		byte[] sendData = "服务器说：欢迎您客户端".getBytes();
		// 创建数据报，包含响应的数据信息
		DatagramPacket sendDatagramPacket = new DatagramPacket(sendData,
				sendData.length, inetAddress, port);
		// 发送数据 传递给客户端
		socket.send(sendDatagramPacket);
		// 关闭资源
		if (socket != null) {
			socket.close();
		}

	}
}
