package chat.server;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ServerGUI  extends JFrame{

	private JTextArea jta = new JTextArea(40, 25);
	private JTextField jtf = new JTextField(25);
	
	//연동을 위한 객체
	private ServerBackground server = new ServerBackground();
	
	public ServerGUI() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(e->{
			String msg = jtf.getText()+"\n";
			jta.append(msg);
			server.sendMessage(msg);
			jtf.setText("");
		});//이벤트 리스너
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 100, 400, 600);
		setTitle("서버 채팅창");
		server.setGui(this);
		server.setting();
	}
	
	public static void main(String[] args) {
		new ServerGUI();
	}

	public void appendMsg(String msg) {
		jta.append(msg);
		System.out.println("받은 메시지 : "+msg);
	}
	
}
