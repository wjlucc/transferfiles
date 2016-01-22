package com.transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端使用UDP报文传送要发送的文件名；使用TCP发送文件内容。
 * 
 * @author WJLUCK
 *
 */

public class Client {


	public static void main(String[] args) throws IOException {
		
		//这个表示的是要传送的文件名字和服务器地址。
		String name = "10993561_165851054340_2.jpg";
		String host = "localhost";
		
		
		//1.创建UDP邮筒，用于发送信件，发送邮筒不需要绑定端口。
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//2.创建报文，报文的三个部分都要有。
		InetAddress address = InetAddress.getByName(host);
		int port = 8889;		
		byte[] fileName = name.getBytes();
		DatagramPacket packet = new DatagramPacket(fileName, fileName.length, address, port);
		
		//3.进行发送
		datagramSocket.send(packet);


		// 1.创建Socket对象，用于TCP发送文件内容。
		int port2 = 8888;
		Socket socket = new Socket(host, port2);

		// 2.从Socket获得缓冲字节输出流用于向远方写文件.
		OutputStream outputStream = socket.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		
		//3.从文件处获得一个缓冲字节输入流，对文件进行处理。
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(name));

		//4.不停地发送文件。
		byte[] info = new byte[1024];
		int len = -1;
		while((len = bufferedInputStream.read(info)) != -1){
			//从文件中获得了输入字节数组。并且发送出去。
			bufferedOutputStream.write(info, 0, len);			
		}
		
//		socket.shutdownOutput();	
		
		//最后要关闭资源。
		bufferedInputStream.close();
//		bufferedOutputStream.close();
//		outputStream.close();
		socket.close();
		
		datagramSocket.close();
	}

}
