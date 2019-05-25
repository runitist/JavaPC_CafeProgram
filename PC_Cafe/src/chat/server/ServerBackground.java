package chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {
	
	ServerSocket serverSocket;
	Socket socket;
	
	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);
			System.out.println("대기중...");
			socket = serverSocket.accept();
			System.out.println(socket.getInetAddress()+"에서 접속했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

}
