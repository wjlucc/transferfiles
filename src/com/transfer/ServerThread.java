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
		this.name = "D:\\����\\"+name;
	}

	public void run() {

		/**
		 * ��ʵ�ִ���һ����Ӱ�Ĺ��̡�
		 */
		try {

			// ��Socket�������������ͨ�������������ȡ��Ϣ����װ��һ����Ч�ֽڻ�����������
			InputStream inputStream = this.socket.getInputStream();
			BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

			// ����һ���ֽڻ�������������ļ�д�롣
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.name, true));

			System.out.println("����д���ļ�......");

			byte[] info = new byte[1024];
			int len = 0;
			while ((len = bufferedInputStream.read(info)) != -1) {
				// ������ѭ����˵���Ѿ�����Ϣ�����ˣ��ֽ������С�
				bufferedOutputStream.write(info, 0, len);
//				System.out.println(Arrays.toString(info));
			}
			System.out.println("�ļ��Ѿ���ȫд�룡");
			
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
