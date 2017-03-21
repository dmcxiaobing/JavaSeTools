package com.qq986945193.javasetools.socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
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
 * udpClientSocket客户端 udp发送数据
 */
public class UdpClientSocket {
	public static void main(String[] args) throws IOException {
		/**
		 * 向服务器发送数据
		 */
		//定义服务器的地址,数据,端口号
		InetAddress inetAddress = InetAddress.getByName(Api.LOCAL_HOST);
		int port = Integer.parseInt(Api.TCP_SERVER_PORT);
		byte []data = "客户端说：username=admin password = root".getBytes();
		//创建数据报，包含发送的信息
		DatagramPacket datagramPacket = new DatagramPacket(data,data.length,inetAddress,port);
		//创建DatagramSocket对象
		DatagramSocket datagramSocket = new DatagramSocket();
		//向服务端发送数据报
		datagramSocket.send(datagramPacket);
		/**
		 * 接收服务器端响应的数据
		 */
		byte []socketDatas = new byte[1024];
		DatagramPacket datagramPacket2 = new DatagramPacket(socketDatas, socketDatas.length);
		//接收服务端响应的数据
		datagramSocket.receive(datagramPacket2);
		//读取数据
		String replay = new String(socketDatas,0,socketDatas.length);
		System.out.println("我是客户端,服务器说:"+replay);
		if (datagramSocket!=null) {
			//关闭资源
			datagramSocket.close();
		}
		
		
	}
}
