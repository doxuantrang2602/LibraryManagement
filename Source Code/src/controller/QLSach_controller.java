package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.QLTV_View;

public class QLSach_controller implements ActionListener{

	public QLTV_View qlSach_view;
	
	public QLSach_controller(QLTV_View qlSach_view) {
		this.qlSach_view = qlSach_view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if(src.equals("Thêm")) {
			
				// Mã sách
				try {		
					String maSach = this.qlSach_view.textField_idSach.getText()+"";
					if(maSach.length() == 0) {
						JOptionPane.showMessageDialog(null, "Mã sách không được để trống! VD: 1001");
						return;
					}
					int idSach = Integer.parseInt(maSach);
					if(idSach >=1000000) {
						JOptionPane.showMessageDialog(null, "Mã sách không được quá 6 chữ số !");
						return;
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, 
							"Nhập sai dữ liệu mã sách !",
							"Error",
							JOptionPane.ERROR_MESSAGE);
						return;
				}
						
				// Tên Sách
				if(this.qlSach_view.textField_tenSach.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Tên sách không được để trống !",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Tác giả
				if(this.qlSach_view.textField_tacGia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Tác giả không được để trống!",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				// Thể loại
				if(this.qlSach_view.textField_theLoai.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Thể loại không được để trống!",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				// Năm xuất bản
				try {
					
					if(this.qlSach_view.textField_namXB.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, 
								"Năm xuất bản không được bỏ trống !",
								"Error",
								JOptionPane.ERROR_MESSAGE);
								return;
					}
					int namXB = Integer.valueOf(this.qlSach_view.textField_namXB.getText()+"");
					if(namXB <= 0 || namXB >2023) {
						JOptionPane.showMessageDialog(null, "Năm xuất bản không hợp lệ! 0< x <2023");
						return;
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, "Cần nhập lại năm xuất bản");
					return;
				}
								
				// Số lượng còn
				try {	
					if(this.qlSach_view.textField_soLuongCon.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Số lượng không được bỏ trống!", "Error",JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					int soLuongCon = Integer.valueOf(this.qlSach_view.textField_soLuongCon.getText()+"");
					if(soLuongCon < 0) {
						JOptionPane.showMessageDialog(null, 
								"Số lượng phải là 1 số tự nhiên ! ",
								"Error",
								JOptionPane.ERROR_MESSAGE);						
						return;
					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null, 
							"Số lượng không hợp lệ !",
							"Error",
							JOptionPane.ERROR_MESSAGE);
					return;
				} 	
				
				// Thêm dữ liệu
				try {
					this.qlSach_view.thucHienThemSach();
				} catch (Exception e1) {
					e1.printStackTrace();
				}						
		} else if(src.equals("Lưu")) {
			// Mã sách
			try {		
				String maSach = this.qlSach_view.textField_idSach.getText()+"";
				if(maSach.length() == 0) {
					JOptionPane.showMessageDialog(null, "Mã sách không được để trống! VD: 1001");
					return;
				}
				int idSach = Integer.parseInt(maSach);
				if(idSach >=1000000) {
					JOptionPane.showMessageDialog(null, "Mã sách không được quá 6 chữ số !");
					return;
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, 
						"Nhập sai dữ liệu mã sách !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
					
			// Tên Sách
			if(this.qlSach_view.textField_tenSach.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"Tên sách không được để trống !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Tác giả
			if(this.qlSach_view.textField_tacGia.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"Tác giả không được để trống!",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			// Thể loại
			if(this.qlSach_view.textField_theLoai.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, 
						"Thể loại không được để trống!",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			
			// Năm xuất bản
			try {
				
				if(this.qlSach_view.textField_namXB.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Năm xuất bản không được bỏ trống !",
							"Error",
							JOptionPane.ERROR_MESSAGE);
							return;
				}
				int namXB = Integer.valueOf(this.qlSach_view.textField_namXB.getText()+"");
				if(namXB <= 0 || namXB >2023) {
					JOptionPane.showMessageDialog(null, "Năm xuất bản không hợp lệ! 0< x <2023");
					return;
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, "Cần nhập lại năm xuất bản");
				return;
			}
							
			// Số lượng còn
			try {	
				if(this.qlSach_view.textField_soLuongCon.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số lượng không được bỏ trống!", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int soLuongCon = Integer.valueOf(this.qlSach_view.textField_soLuongCon.getText()+"");
				if(soLuongCon < 0) {
					JOptionPane.showMessageDialog(null, 
							"Số lượng phải là 1 số tự nhiên ! ",
							"Error",
							JOptionPane.ERROR_MESSAGE);						
					return;
				}
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(null, 
						"Số lượng không hợp lệ !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			try {
				this.qlSach_view.thucHienLuuSach();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Sửa")) {
			this.qlSach_view.hienThiThongTinSachDaChon();
		} else if(src.equals("Xóa")) {
			this.qlSach_view.thucHienXoaSach();
		} else if(src.equals("Tìm")) {
			if(this.qlSach_view.textField_TuKhoaSach_Tim.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Bạn muốn tìm sách nào ?");
				return;
			}
			this.qlSach_view.timSach();
		}else if(src.equals("Hủy")) {
			this.qlSach_view.huyTimSach();
		} else if(src.equals("Thoát chương trình")) {
			 this.qlSach_view.thoatChuongTrinh();
		} else if(src.equals("Reset")) {
			 this.qlSach_view.xoaFormSach();

		} else if(src.equals("Exit")) {
			this.qlSach_view.setVisible(false);
			new QLTV_View();

		}
		else if(src.equals("Open")) {
			 this.qlSach_view.thucHienOpen();

		}
		else if(src.equals("Save")) {
			 this.qlSach_view.thucHienSave();

		}
		
	}

}
