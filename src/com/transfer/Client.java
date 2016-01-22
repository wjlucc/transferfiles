package com.transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 客户端使用UDP报文传送要发送的文件名；使用TCP发送文件内容。
 * 
 * @author WJLUCK
 *
 */

public class Client {


	public static void main(String[] args) throws IOException {
		// 1.创建Socket对象，用于发送文件内容。
		int port = 8888;
		Socket socket = new Socket("localhost", port);

		// 2.从Socket获得缓冲字节输出流用于向远方写文件.
		OutputStream outputStream = socket.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		
		//从文件处获得一个缓冲字节输入流，对文件进行处理。
		String fileName = "怒火攻心.BD1280高清中英双字.mp4";
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

		byte[] info = new byte[1024];
		int len = -1;
		while((len = bufferedInputStream.read(info)) != -1){
			//从文件中获得了输入字节数组。并且发送出去。
			bufferedOutputStream.write(info, 0, len);			
		}
	
		bufferedInputStream.close();
		bufferedOutputStream.close();
		outputStream.close();
		
		
		socket.close();
	}

}
