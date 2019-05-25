package chat.client;

import java.net.Socket;

public class ClientBackground {
	Socket socket;
	
	public void connect() {
		try {
			socket = new Socket("127.0.0.1", 7777);
			System.out.println("서버 연결됨.");
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		ClientBackground clientBackground = new ClientBackground();
		clientBackground.connect();
	}

}
