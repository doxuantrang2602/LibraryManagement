package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.DangNhapDAO;
import view.SignIn;
import view.SignUp;

public class formDangNhap implements ActionListener {
	public SignIn sng;
	
	
	public formDangNhap( SignIn sng) {
		// TODO Auto-generated constructor stub
		this.sng = sng;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
//		System.out.println("You pressed a node: " + src);
		if (src.equals("Sign In")) {
			try {
				String dangNhap = this.sng.user_Name.getText()+"";
				if (dangNhap.length() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập tên đăng nhập!");
					return;
				} 
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, 
						"Tên đăng nhập không tồn tại !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
			try {
				char [] matKhau = this.sng.pass_Word.getPassword();
				String matKhau1 = new String(matKhau);
				if (matKhau1.length() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập mật khẩu!");
					return;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, 
						"Mật khẩu không hợp lệ !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
			new DangNhapDAO().login(this.sng.user_Name.getText(), this.sng.pass_Word.getText());
		}
		
		if (src.equals("Sign Up")) {
			this.sng.setVisible(false);
			new SignUp();
		}
		
	}
	
}
