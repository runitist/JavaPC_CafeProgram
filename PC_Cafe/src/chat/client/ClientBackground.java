package chat.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class ClientBackground {
	Socket socket;
	DataInputStream in;
	DataOutputStream out;
	ClientGUI gui;

	public void setGui(ClientGUI gui) {
		this.gui = gui;
	}

	// 1 메시지 통신 기능
	// 2 gui 구성
	// 3 지속적 송수신기능.
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);// 바인딩한 소켓 주소로 요청을 보냄.
			System.out.println("서버 연결됨.");

			out = new DataOutputStream(socket.getOutputStream());// 리퀘스트
			in = new DataInputStream(socket.getInputStream());// 리스폰스

			out.writeUTF("안녕하세요. 클라이언트입니다.");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}

}
