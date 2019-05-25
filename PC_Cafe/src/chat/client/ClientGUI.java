package chat.client;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientGUI extends JFrame{

	JTextArea jta = new JTextArea(40, 25);
	JTextField jtf = new JTextField(25);
	ClientBackground client = new ClientBackground();
	
	public ClientGUI() {
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		jtf.addActionListener(e->{
			String msg = jtf.getText()+"\n";
			jta.append(msg);
			jtf.setText("");
		});//이벤트 리스너
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(200, 100, 400, 600);
		setTitle("클라이언트 채팅창");
		client.setGui(this);
		client.connect();
	}
	
	public static void main(String[] args) {
		new ClientGUI();
	}
}
