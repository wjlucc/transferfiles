package com.transfer;

//这个对象用于接收文件名。

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerGetName {
	private DatagramSocket socket = null;

	public ServerGetName(DatagramSocket socket) {
		this.socket = socket;
	}

	// 这个方法实现UDP接收文件名。
	public String getFileName() throws IOException {

		// 1.DatagramSocket邮筒已有。

		// 2.创建准备接收的字节数组。以及报文。
		byte[] info = new byte[1024];
		DatagramPacket packet = new DatagramPacket(info, info.length);

		// 3.服务器接收报文。这里会有阻塞产生。
		this.socket.receive(packet);

		// 4.处理接收到的数据。注意这里的长度应该是报文长度。
		String name = new String(info, 0, packet.getLength());
		return name;
	}
}
