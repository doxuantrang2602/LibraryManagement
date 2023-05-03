package controller;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ThongTinDAO;
import view.QLTV_View;

public class ThongTin_controller implements ActionListener {
	
	public QLTV_View qltv_View;
	
	public ThongTin_controller(QLTV_View qltv_View) {
		// TODO Auto-generated constructor stub
		this.qltv_View = qltv_View;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String src = e.getActionCommand();
//		System.out.println("You pressed a node: ");
		if (src.equals("Cập Nhật")) {
			//JOptionPane.showMessageDialog(null, "Thành công");
		new ThongTinDAO().UpdateIF(this.qltv_View.Lable_name1.getText(),this.qltv_View.Lable_email1.getText(),this.qltv_View.Lable_SDT1.getText());
		}
		if(src.equals("Cập Nhật Tài Khoản")) {
			this.qltv_View.setVisible(false);
			new QLTV_View();
		}
	}
	
}
