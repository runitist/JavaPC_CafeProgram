package chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBackground {

	private ServerSocket serverSocket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private ServerGUI gui;
	
	public void setGui(ServerGUI gui) {
		this.gui = gui;
	}

	public void setting() {
		try {
			serverSocket = new ServerSocket(7777);// 서버 소켓의 생성, 그리고 바인드를 한번에
			System.out.println("서버 대기중...");
			socket = serverSocket.accept();// 서버 소켓의 accept를 실행하여 클라이언트의 요청을 기다림.
			System.out.println(socket.getInetAddress() + "에서 접속했습니다.");

			out = new DataOutputStream(socket.getOutputStream());
			in = new DataInputStream(socket.getInputStream());

			String msg = in.readUTF();
			System.out.println("클라이언트 : " + msg);
			gui.appendMsg(msg);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerBackground serverBackground = new ServerBackground();
		serverBackground.setting();
	}

}
