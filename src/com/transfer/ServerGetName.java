package com.transfer;

//����������ڽ����ļ�����

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ServerGetName {
	private DatagramSocket socket = null;

	public ServerGetName(DatagramSocket socket) {
		this.socket = socket;
	}

	// �������ʵ��UDP�����ļ�����
	public String getFileName() throws IOException {

		// 1.DatagramSocket��Ͳ���С�

		// 2.����׼�����յ��ֽ����顣�Լ����ġ�
		byte[] info = new byte[1024];
		DatagramPacket packet = new DatagramPacket(info, info.length);

		// 3.���������ձ��ġ������������������
		this.socket.receive(packet);

		// 4.������յ������ݡ�ע������ĳ���Ӧ���Ǳ��ĳ��ȡ�
		String name = new String(info, 0, packet.getLength());
		return name;
	}
}
