package com.transfer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {

		// 1.�������˴���һ��ServerSocketͨ�ŵ㣬��Ϊͨ�ŷ����������Ұ󶨶˿ڡ�ServerSocket
		ServerSocket serverSocket = new ServerSocket(8888);

		// 2.��������ʼ������ֱ�������ӽ�����
		System.out.println("----�������Ѿ��������ȴ�����----");

		String name = "ŭ����.BD1280������Ӣ˫��.mp4";
		Socket socket = null;
		while (true) {
			socket = serverSocket.accept();
			ServerThread serverThread = new ServerThread(socket,name);
			serverThread.start();
		}

	}
}
