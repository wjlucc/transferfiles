package com.transfer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * �ͻ���ʹ��UDP���Ĵ���Ҫ���͵��ļ�����ʹ��TCP�����ļ����ݡ�
 * 
 * @author WJLUCK
 *
 */

public class Client {


	public static void main(String[] args) throws IOException {
		// 1.����Socket�������ڷ����ļ����ݡ�
		int port = 8888;
		Socket socket = new Socket("localhost", port);

		// 2.��Socket��û����ֽ������������Զ��д�ļ�.
		OutputStream outputStream = socket.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		
		//���ļ������һ�������ֽ������������ļ����д���
		String fileName = "ŭ����.BD1280������Ӣ˫��.mp4";
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(fileName));

		byte[] info = new byte[1024];
		int len = -1;
		while((len = bufferedInputStream.read(info)) != -1){
			//���ļ��л���������ֽ����顣���ҷ��ͳ�ȥ��
			bufferedOutputStream.write(info, 0, len);			
		}
	
		bufferedInputStream.close();
		bufferedOutputStream.close();
		outputStream.close();
		
		
		socket.close();
	}

}
