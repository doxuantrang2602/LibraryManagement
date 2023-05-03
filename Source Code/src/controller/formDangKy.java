package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import dao.DangNhapDAO;
import view.SignIn;
import view.SignUp;

public class formDangKy implements ActionListener{
	public SignUp snu;
	
	public formDangKy(SignUp snu) {
		// TODO Auto-generated constructor stub
		this.snu = snu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
//		System.out.println("You pressed a node: ");
		
		if (src.equals("Sign Up")) {
			try {
				String tenDangNhap = this.snu.Text1.getText()+"";
				if (tenDangNhap.length() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn cần tạo tên đăng nhập!");
					return;
				} 
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, 
						"Tên đăng nhập đã tồn tại !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			} 
			try {
				char [] matKhau = this.snu.Text2.getPassword();
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
			try {
				char [] matKhau = this.snu.Text3.getPassword();
				String matKhau1 = new String(matKhau);
				if (matKhau1.length() == 0) {
					JOptionPane.showMessageDialog(null, "Bạn cần nhập lại mật khẩu!");
					return;
				}
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, 
						" Nhập lại mật khẩu không hợp lệ !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
			new DangNhapDAO().signUp(this.snu.Text1.getText(),this.snu.Text2.getText());
		}
		
		if(src.equals("Sign In")) {
			this.snu.setVisible(false);
			new SignIn();
		}
	}
}
