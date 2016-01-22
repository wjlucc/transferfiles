package com.transfer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		// 1.服务器端创建一个ServerSocket通信点，作为通信服务器。并且绑定端口。ServerSocket
		ServerSocket serverSocket = new ServerSocket(8888);

		// 2.服务器开始侦听，直到有连接建立。
		System.out.println("----服务器已经建立，等待连接----");

		String name = "怒火攻心.BD1280高清中英双字.mp4";
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket,name);
			serverThread.start();
		}

	}
}
