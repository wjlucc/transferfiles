package com.transfer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端使用单线程UDP接收传来的文件名； 之后创建新线程，利用Socket接收文件内容。
 * 
 * @author WJLUCK
 *
 */

public class Server {
	public static void main(String[] args) throws IOException {

		// 服务器端创建一个ServerSocket通信点，作为通信TCP服务器。并且绑定端口8888。
		ServerSocket serverSocket = new ServerSocket(8888);
		// 创建一个DatagramSocket作为接收文件名的邮筒，绑定端口8889
		DatagramSocket datagramSocket = new DatagramSocket(8889);

		
		// 这个对象每次用来获取文件名。
		ServerGetName getName = new ServerGetName(datagramSocket);

		// 服务器开始侦听，直到有连接建立。
		System.out.println("----服务器已经建立，等待连接----");
		Socket socket = null;

		while (true) {

			// 这个里面是使用UDP接收发过来的文件名。
			String fileName = getName.getFileName();
			System.out.println("要接收的文件是：" + fileName + ",请等待。");

			// 接收文件名后使用TCP接收文件内容。
			// 每次会在新接收一个文件名后再多线程接收文件内容。可以同时传送多个文件。但是文件名的传送是单线程。
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket, fileName);
			serverThread.start();
		}
	}
}
