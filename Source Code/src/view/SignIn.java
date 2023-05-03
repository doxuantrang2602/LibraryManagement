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
import java.awt.geom.RoundRectangle2D;
import java.net.URL;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.formDangNhap;
import Entities.*;
import test.Login;

public class SignIn extends JFrame {
	public User us;
	public JButton jbutton_LogIn;
	public JLabel Login;
	public JLabel user_name;
	public JLabel pass_word;
	public JTextField user_Name;
	public JPasswordField pass_Word;
	public JLabel forgot;
	public JLabel lable1;
	public JLabel lable2;
	public JLabel lable3;
	public JButton button1;
	public SignIn() {
		this.us = new User();
		this.init();
		this.setVisible(true);
	}
	public void init() {
		this.setTitle("Quản Lý Thư Viện");
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//đặt icon cho title		
//		URL iconTitle = Test1.class.getResource("title.png");
//		Image img = Toolkit.getDefaultToolkit().createImage(iconTitle);
//		this.setIconImage(img);
		
		ActionListener ac = new formDangNhap(this);
		
		jbutton_LogIn = new JButton("Sign In");
		Login = new JLabel("Sign In");
		jbutton_LogIn.addActionListener(ac);
		user_name = new JLabel("Username");
		pass_word = new JLabel("Password");
	    user_Name = new JTextField();
		pass_Word = new JPasswordField();
		forgot = new JLabel("Forgot password?");
		
		
		Font font = new Font("Arial", Font.PLAIN, 16);
		jbutton_LogIn.setFont(font);
		
		Font font1 = new Font("Arial", Font.BOLD, 25);
		Login.setFont(font1);
		
		Font font2 = new Font("Arial", Font.PLAIN, 14);
		user_name.setFont(font2);
		pass_word.setFont(font2);
		forgot.setFont(font2);
		
		Font font3 = new Font("Arial", Font.ITALIC, 16);
		
		JPanel panel2 = new JPanel();
        panel2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel2.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 5, 5, 5);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		//c.fill = GridBagConstraints.BOTH;
		panel2.add(Login,c);
		c.gridx = 0;
		c.gridy = 1;
		//c.fill = GridBagConstraints.BOTH;
		panel2.add(user_name,c);
		c.gridx = 0;
		c.gridy = 2;
		panel2.add(user_Name,c);
		user_Name.setPreferredSize(new Dimension(200,30));
		c.gridx = 0;
		c.gridy = 3;
		panel2.add(pass_word,c);
		c.gridx = 0;
		c.gridy = 4;
		panel2.add(pass_Word,c);
		pass_Word.setPreferredSize(new Dimension(200,30));
		c.gridx = 0;
		c.gridy = 5;
		panel2.add(jbutton_LogIn,c);
		c.gridy = 6;
		panel2.add(forgot,c);
		panel2.setBackground(Color.WHITE);
		this.add(BorderLayout.CENTER,panel2);
		
		lable1 = new JLabel("Hello Friends");
		lable2 = new JLabel("Enter your personel details");
		lable3 = new JLabel("and start journey with us");
		button1 = new JButton("Sign Up");
		button1.addActionListener(ac);
		
		lable1.setFont(font3);
		lable2.setFont(font3);
		lable3.setFont(font3);
		button1.setFont(font);
		
		JPanel panel3 = new JPanel();
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panel3.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		g.insets = new Insets(15, 15, 15, 15);
		g.gridx = 0;
		g.gridy = 0;
		g.weightx = 0.9;
		panel3.add(lable1,g);
		g.gridy = 1;
		panel3.add(lable2,g);
		g.gridy = 2;
		panel3.add(lable3,g);
		g.gridy = 3;
		panel3.add(button1,g);
		panel3.setBackground(Color.PINK);
		this.add(BorderLayout.WEST,panel3);
		}
}
