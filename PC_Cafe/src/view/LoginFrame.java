package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

//프로그램의 메인
public class LoginFrame extends JFrame {// 가장 바깥은 jframe 스테이지

	// 각 노드들
	BufferedImage img = null;
	JTextField loginTextField;
	JPasswordField passwordField;
	JButton bt;
	JLabel idlb;
	JLabel passlb;

	public static void main(String[] args) {
		new LoginFrame();
	}

	public LoginFrame() {
		setTitle("로그인 테스트");
		setSize(1600, 900);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);// 레이아웃이 절대값 좌표로 배치

		// 이미지 받아오기

		try {
			img = ImageIO.read(new File("img/login.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}

		// 레이아웃 설정

		JLayeredPane layeredpane = new JLayeredPane();// 창의 바탕이 되는 패널 씬
		layeredpane.setBounds(0, 0, 1600, 900);
		layeredpane.setLayout(null);

		// 패널1
		MyPanel panel = new MyPanel();// 씬의 안에 붙어서 배경이 되는 패널.
		panel.setBounds(0, 0, 1600, 900);

		// 로그인 필드
		idlb = new JLabel("아이디");
		idlb.setFont(new Font("Serif", Font.BOLD, 18));
		idlb.setForeground(Color.WHITE);
		idlb.setBounds(650, 399, 100, 30);
		loginTextField = new JTextField(15);
		loginTextField.setBounds(731, 399, 200, 30);

		layeredpane.add(idlb);
		layeredpane.add(loginTextField);

		// 비밀번호 필드
		passlb = new JLabel("비밀번호");
		passlb.setFont(new Font("Serif", Font.BOLD, 18));
		passlb.setForeground(Color.WHITE);
		passlb.setBounds(650, 480, 100, 30);
		passwordField = new JPasswordField(15);
		passwordField.setBounds(731, 480, 200, 30);

		layeredpane.add(passlb);
		layeredpane.add(passwordField);

		// 버튼추가
		
		bt = new JButton("Login");//ImageIcon 객체를 생성해서 넣어주면 이미지 버튼을 만들수 있음.
		bt.setBackground(Color.black);
		bt.setFont(new Font("Serif", Font.BOLD, 18));
		bt.setForeground(Color.WHITE);
		bt.setBounds(755, 589, 104, 48);
		
		layeredpane.add(bt);
		

		// 노드 추가
		layeredpane.add(panel);

		add(layeredpane);

		setVisible(true);
	}

	class MyPanel extends JPanel { // 패널을 생성하는 내부클래스
		public void paint(Graphics g) {
			g.drawImage(img, 0, 0, 1600, 900, null);
		}

	}

}