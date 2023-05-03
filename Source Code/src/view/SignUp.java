package view;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.formDangKy;
import controller.formDangNhap;
import dao.DangNhapDAO;
import Entities.*;
import test.Login;

public class SignUp extends JFrame {
	public User us1;
	public JLabel lable1;
	public JLabel lable2;
	public JTextField Text1;
	public JLabel lable3;
	public JPasswordField Text2;
	public JPasswordField Text3;
	public JLabel lable4;
	public JButton button1;
	public JLabel lable5;
	public JLabel lable6;
	public JLabel lable7;
	public JButton button2;
	//private JLabel lable5;
	public SignUp() {
		this.us1 = new User();
		this.init();
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Quản Lý Thư Viện");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
//		URL iconTitle = Test1.class.getResource("title.png");
//		Image img = Toolkit.getDefaultToolkit().createImage(iconTitle);
//		this.setIconImage(img);
		
		ActionListener ac = new formDangKy(this);
		
		lable1 = new JLabel("Sign Up");
		lable2 = new JLabel("Username");
		Text1 = new JTextField();
		lable3 = new JLabel("Password");
		Text2 = new JPasswordField();
		lable4 = new JLabel("Repassword");
		Text3 = new JPasswordField();
		button1 = new JButton("Sign Up");
		button1.addActionListener(ac);
		
		Font font = new Font("Arial", Font.PLAIN, 16);
		button1.setFont(font);
		
		Font font1 = new Font("Arial", Font.BOLD, 25);
		lable1.setFont(font1);
		
		Font font2 = new Font("Arial", Font.PLAIN, 14);
		lable2.setFont(font2);
		lable3.setFont(font2);
		lable4.setFont(font2);
		
		Font font3 = new Font("Arial", Font.ITALIC, 16);
		
		JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel.setLayout( new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 5, 5, 5);
		//c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		panel.add(lable1,c);
		c.gridy = 1;
		panel.add(lable2,c);
		c.gridy = 2;
		panel.add(Text1,c);
		Text1.setPreferredSize(new Dimension(200,30));
		c.gridy = 3;
		panel.add(lable3,c);
		c.gridy = 4;
		panel.add(Text2,c);
		Text2.setPreferredSize(new Dimension(200,30));
		c.gridy = 5;
		panel.add(lable4,c);
		c.gridy = 6;
		panel.add(Text3,c);
		Text3.setPreferredSize(new Dimension(200,30));
		c.gridy = 7;
		panel.add(button1,c);
		panel.setBackground(Color.WHITE);
		this.add(BorderLayout.CENTER,panel);
		
		lable5 = new JLabel("Welcome Back!");
		lable6 = new JLabel("To keep connected with us please");
		lable7 = new JLabel("login with your personal info");
		button2 = new JButton("Sign In");
		button2.addActionListener(ac);
		
		button2.setFont(font);
		lable5.setFont(font3);
		lable6.setFont(font3);
		lable7.setFont(font3);
		
		
		JPanel panel1 = new JPanel();
        panel1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel1.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(15, 15, 15, 15);
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0.9;
		panel1.add(lable5,g);
		g.gridy = 1;
		panel1.add(lable6,g);
		g.gridy = 2;
		panel1.add(lable7,g);
		g.gridy = 3;
		panel1.add(button2,g);
		panel1.setBackground(Color.PINK);
		this.add(BorderLayout.EAST,panel1);
	}
	//themtk
			public void thuchienthemtk() {
				String userName = this.Text1.getText();
				String passWord = this.Text2.getText();
				User us = new User(userName,passWord);
				this.themtk();
}
			public void themtk() {
				 new DangNhapDAO().signUp(this.Text1.getText(),this.Text2.getText());
		
	}
}
