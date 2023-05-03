package controller;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import Entities.Tinh;
import view.QLTV_View;

public class QLSV_controller implements ActionListener{

	private QLTV_View qlsv_view;
	
	
	public QLSV_controller(QLTV_View qlsv_view) {
		this.qlsv_view = qlsv_view;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if(src.equals("Thêm")) {
			// Mã sinh viên
			try {
				String maSV = this.qlsv_view.textField_maSV.getText()+"";
				if(maSV.length()==0) {
					JOptionPane.showMessageDialog(null, "Mã sinh viên không được để trống! VD: 211240555");
					return;
				}
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, 
						"Nhập sai dữ liệu mã sinh viên !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
			
			// Tên sinh viên
				String tenSV = this.qlsv_view.textField_hoVaTenSV.getText()+"";
				try {
					if(tenSV.length()==0) {
						JOptionPane.showMessageDialog(null, "Tên sinh viên không được để trống! VD: Đỗ Xuân Tráng");
						return;
					} 
					if(tenSV.matches(".*\\d+.*")) { 
						JOptionPane.showMessageDialog(null, "Tên sinh viên không hợp lệ! VD: Đỗ Xuân Tráng");
						return;
					}
				} catch (HeadlessException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			
			// Quê quán Sinh viên
				if(this.qlsv_view.comboBox_queQuanSV.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Quê quán không được để trống!");
					return;
				}
			
			// Ngày sinh Sinh viên	
				if(this.qlsv_view.textField_ngaySinhSV.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
					return;
				} 
				
			// Lớp - Khóa
				if(this.qlsv_view.textField_lopKhoa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lớp - Khóa không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
			// Email
				if(this.qlsv_view.textField_EmailSV.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
			// Số điện thoại
				if(this.qlsv_view.textField_SdtSV.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						String sdt = this.qlsv_view.textField_SdtSV.getText();
						long sDT = Long.parseLong(sdt);
						if( sDT< Math.pow(10, 8) || sDT>Math.pow(10, 9) || sdt.charAt(0) != '0' || !sdt.matches(".*\\d+.*") ) {
							JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số và bắt đầu bằng chữ số 0!","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						} 
				
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
						return;
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					}
			}
			try {
				this.qlsv_view.thucHienThemSinhVien();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		} 
		else if(src.equals("Lưu")) {
			
			// Mã sinh viên
			try {
				String maSV = this.qlsv_view.textField_maSV.getText()+"";
				if(maSV.length()==0) {
					JOptionPane.showMessageDialog(null, "Mã sinh viên không được để trống! VD: 211240555");
					return;
				}
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, 
						"Nhập sai dữ liệu mã sinh viên !",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
			}
			
			// Tên sinh viên
				String tenSV = this.qlsv_view.textField_hoVaTenSV.getText()+"";
				try {
					if(tenSV.length()==0) {
						JOptionPane.showMessageDialog(null, "Tên sinh viên không được để trống! VD: Đỗ Xuân Tráng");
						return;
					} 
					if(tenSV.matches(".*\\d+.*")) { 
						JOptionPane.showMessageDialog(null, "Tên sinh viên không hợp lệ! VD: Đỗ Xuân Tráng");
						return;
					}
				} catch (HeadlessException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
			
			// Quê quán Sinh viên
				if(this.qlsv_view.comboBox_queQuanSV.getSelectedItem().equals("")) {
					JOptionPane.showMessageDialog(null, "Quê quán không được để trống!");
					return;
				}
			
			// Ngày sinh Sinh viên	
				if(this.qlsv_view.textField_ngaySinhSV.getDate() == null) {
					JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
					return;
				} 
				
			// Lớp - Khóa
				if(this.qlsv_view.textField_lopKhoa.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lớp - Khóa không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
			// Email
				if(this.qlsv_view.textField_EmailSV.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Email không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				}
			// Số điện thoại
				if(this.qlsv_view.textField_SdtSV.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số điện thoại không được bỏ trống!","ERROR",JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						String sdt = this.qlsv_view.textField_SdtSV.getText();
						long sDT = Long.parseLong(sdt);
						if( sDT< Math.pow(10, 8) || sDT>Math.pow(10, 9) || sdt.charAt(0) != '0' || !sdt.matches(".*\\d+.*") ) {
							JOptionPane.showMessageDialog(null, "Số điện thoại phải đủ 10 số và bắt đầu bằng chữ số 0!","ERROR",JOptionPane.ERROR_MESSAGE);
							return;
						} 
				
					} catch (NumberFormatException e1) {
						e1.printStackTrace();
						return;
					} catch (HeadlessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						return;
					}
			}
				
			// Lưu thông tin
			try {
			this.qlsv_view.thucHienLuuSinhVien();
			}
			catch (Exception e1) {
					e1.printStackTrace();
				}
		} else if(src.equals("Sửa")) {
			this.qlsv_view.hienThiThongtinSinhVienDaChon();
		} else if(src.equals("Xóa")) {
			this.qlsv_view.thucHienXoaSV();
		}  else if(src.equals("Thoát chương trình")) {
			this.qlsv_view.thoat_QLSV();
		} else if(src.equals("Reset")) {
			this.qlsv_view.xoaForm_SV();
		}	 else if(src.equals("Tìm")) {
			this.qlsv_view.thucHienTimSV();
		} else if(src.equals("Hủy")) {
			this.qlsv_view.thucHienHuyTimSV();
		}  				
		}		
	}
	
