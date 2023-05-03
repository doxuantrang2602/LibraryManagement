package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.management.openmbean.OpenMBeanAttributeInfoSupport;
import javax.swing.JOptionPane;

import view.QLTV_View;

public class QLPhieuMuon_controller implements ActionListener{
	private QLTV_View ql_phieuMuonView;
 
	public QLPhieuMuon_controller(QLTV_View ql_phieuMuonView) {
		this.ql_phieuMuonView = ql_phieuMuonView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		
		if(src.equals("Thêm")) {
			
			// Mã Phiếu
			if(this.ql_phieuMuonView.textField_maPhieu.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Mã phiếu không được để trống! VD: MP01");
				return;
			}
			
			// Mã Sinh viên
			if(this.ql_phieuMuonView.comboBox_maSV.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng thêm mã sinh viên !");
				return;
			}
			
			// Ngày mượn
			if(this.ql_phieuMuonView.textField_ngayMuon.getDate() == null) {
				JOptionPane.showMessageDialog(null, "Ngày mượn không được để trống");
				return;
			} 
			
			// Mã Sách
			if(this.ql_phieuMuonView.comboBox_maSach.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Mã sách không được để trống!");
				return;
			}
			
			// Số lượng còn
			try {	
				if(this.ql_phieuMuonView.textField_soLuongMuon.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số lượng không được bỏ trống!", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int soLuongCon = Integer.valueOf(this.ql_phieuMuonView.textField_soLuongMuon.getText()+"");
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
				this.ql_phieuMuonView.thucHienThem_PM();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Lưu")) {
			
			// Mã Phiếu
			if(this.ql_phieuMuonView.textField_maPhieu.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Mã phiếu không được để trống! VD: MP01");
				return;
			}
			
			// Mã Sinh viên
			if(this.ql_phieuMuonView.comboBox_maSV.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Vui lòng thêm mã sinh viên !");
				return;
			}
			
			// Ngày mượn
			if(this.ql_phieuMuonView.textField_ngayMuon.getDate() == null) {
				JOptionPane.showMessageDialog(null, "Ngày mượn không được để trống");
				return;
			} 
			
			// Mã Sách
			if(this.ql_phieuMuonView.comboBox_maSach.getSelectedItem() == null) {
				JOptionPane.showMessageDialog(null, "Mã sách không được để trống!");
				return;
			}
			
			// Số lượng còn
			try {	
				if(this.ql_phieuMuonView.textField_soLuongMuon.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Số lượng không được bỏ trống!", "Error",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				int soLuongCon = Integer.valueOf(this.ql_phieuMuonView.textField_soLuongMuon.getText()+"");
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
				this.ql_phieuMuonView.thucHienLuu_PM();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if(src.equals("Xóa")) {
			this.ql_phieuMuonView.thucHienXoa_PM();
		} else if(src.equals("Reset")) {
			this.ql_phieuMuonView.xoaForm_PM();
		} else if(src.equals("Thoát chương trình")) {
			this.ql_phieuMuonView.thoatChuongTrinh();
		} else if(src.equals("Exit")) {
			this.ql_phieuMuonView.thoatChuongTrinh();
		} else if(src.equals("Tìm")) {
			this.ql_phieuMuonView.timPhieuMuon();
		} else if(src.equals("Hủy")) {
			this.ql_phieuMuonView.huyTimPhieuMuon();
		}  else if(src.equals("Sửa")) {
			this.ql_phieuMuonView.hienThiThongtinPhieuMuonDaChon();
		}else if(src.equals("Sum")) {
			this.ql_phieuMuonView.tinhTongSach();
		}
	}

	
	
	
	
}
