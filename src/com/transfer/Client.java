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
 * �ͻ���ʹ��UDP���Ĵ���Ҫ���͵��ļ�����ʹ��TCP�����ļ����ݡ�
 * 
 * @author WJLUCK
 *
 */

public class Client {


	public static void main(String[] args) throws IOException {
		
		//�����ʾ����Ҫ���͵��ļ����ֺͷ�������ַ��
		String name = "10993561_165851054340_2.jpg";
		String host = "localhost";
		
		
		//1.����UDP��Ͳ�����ڷ����ż���������Ͳ����Ҫ�󶨶˿ڡ�
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//2.�������ģ����ĵ��������ֶ�Ҫ�С�
		InetAddress address = InetAddress.getByName(host);
		int port = 8889;		
		byte[] fileName = name.getBytes();
		DatagramPacket packet = new DatagramPacket(fileName, fileName.length, address, port);
		
		//3.���з���
		datagramSocket.send(packet);


		// 1.����Socket��������TCP�����ļ����ݡ�
		int port2 = 8888;
		Socket socket = new Socket(host, port2);

		// 2.��Socket��û����ֽ������������Զ��д�ļ�.
		OutputStream outputStream = socket.getOutputStream();
		BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
		
		//3.���ļ������һ�������ֽ������������ļ����д���
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(name));

		//4.��ͣ�ط����ļ���
		byte[] info = new byte[1024];
		int len = -1;
		while((len = bufferedInputStream.read(info)) != -1){
			//���ļ��л���������ֽ����顣���ҷ��ͳ�ȥ��
			bufferedOutputStream.write(info, 0, len);			
		}
		
//		socket.shutdownOutput();	
		
		//���Ҫ�ر���Դ��
		bufferedInputStream.close();
//		bufferedOutputStream.close();
//		outputStream.close();
		socket.close();
		
		datagramSocket.close();
	}

}
