package com.transfer;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��������ʹ�õ��߳�UDP���մ������ļ����� ֮�󴴽����̣߳�����Socket�����ļ����ݡ�
 * 
 * @author WJLUCK
 *
 */

public class Server {
	public static void main(String[] args) throws IOException {

		// �������˴���һ��ServerSocketͨ�ŵ㣬��Ϊͨ��TCP�����������Ұ󶨶˿�8888��
		ServerSocket serverSocket = new ServerSocket(8888);
		// ����һ��DatagramSocket��Ϊ�����ļ�������Ͳ���󶨶˿�8889
		DatagramSocket datagramSocket = new DatagramSocket(8889);

		
		// �������ÿ��������ȡ�ļ�����
		ServerGetName getName = new ServerGetName(datagramSocket);

		// ��������ʼ������ֱ�������ӽ�����
		System.out.println("----�������Ѿ��������ȴ�����----");
		Socket socket = null;

		while (true) {

			// ���������ʹ��UDP���շ��������ļ�����
			String fileName = getName.getFileName();
			System.out.println("Ҫ���յ��ļ��ǣ�" + fileName + ",��ȴ���");

			// �����ļ�����ʹ��TCP�����ļ����ݡ�
			// ÿ�λ����½���һ���ļ������ٶ��߳̽����ļ����ݡ�����ͬʱ���Ͷ���ļ��������ļ����Ĵ����ǵ��̡߳�
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket, fileName);
			serverThread.start();
		}
	}
}
