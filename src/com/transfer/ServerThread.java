package com.transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Arrays;

public class ServerThread extends Thread {
	private Socket socket = null;
	private String name = "";

	public ServerThread(Socket socket, String name) {
		this.socket = socket;
		this.name = "D:\\接收\\"+name;
	}

	public void run() {

		/**
		 * 先实现传输一个电影的过程。
		 */
		try {

			// 从Socket获得输入流，并通过这个输入流获取信息。包装了一个高效字节缓冲输入流。
			InputStream inputStream = this.socket.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

			// 定义一个字节缓冲输出流，将文件写入。
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.name, true));

			System.out.println("正在写入文件......");

			byte[] info = new byte[1024];
			int len = 0;
			while ((len = bufferedInputStream.read(info)) != -1) {
				// 进入了循环，说明已经将信息读到了，字节数组中。
				bufferedOutputStream.write(info, 0, len);
//				System.out.println(Arrays.toString(info));
			}
			System.out.println("文件已经完全写入！");
			
//			this.socket.shutdownInput();
			bufferedOutputStream.close();
//			bufferedInputStream.close();
//			inputStream.close();
			
			this.socket.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
