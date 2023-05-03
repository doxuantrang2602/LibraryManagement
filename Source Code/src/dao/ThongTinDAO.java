package dao;

import java.awt.JobAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.jdbc.Driver;

import database.JBDCUtil;
import Entities.ThongTin;

public class ThongTinDAO {
	private Connection con;
	
	public ThongTinDAO() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
			
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void UpdateIF(String Ten, String Email, String sDT) {
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = JBDCUtil.getConnection();
			
			String sql = "SELECT FROM thongtin WHERE Ten = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, Ten);
			
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count > 0) {
				try {
					String sql1 = "UPDATE thongtin"
							+ "SET Ten = ?, Email = ?, SDT = ?"
							+ "WHERE Ten = ?";
					ps = con.prepareStatement(sql1);
					ps.setString(1, Ten);
					ps.setString(2, Email);
					ps.setString(3, sDT);
					int count2 = ps.executeUpdate();
					if (count2 > 0) {
						JOptionPane.showMessageDialog(null, "Cập nhật thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Cập nhật thất bại");
					}
					ps.close();
					con.close();
					rs.close();
					return;
				} catch (SQLException e1) {
					// TODO: handle exception
				}
			} else {
				try {
					String sql2 = "INSERT INTO thongtin(Ten,Email,SDT) VALUES (?,?,?)"; 
					ps.setString(1, Ten);
					ps.setString(2, Email);
					ps.setString(3, sDT);
					int count3 = ps.executeUpdate();
					if (count3 > 0) {
						JOptionPane.showMessageDialog(null, "Thêm thông tin thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thông tin thất bại");
					}
				} catch (SQLException e1) {
					// TODO: handle exception
				}
			}
			
		} catch (SQLException e1) {
			// TODO: handle exception
		}
	}
	
//	private void getInfo() {
//		try {
//			Connection con = JBDCUtil.getConnection();
//			
//			String sql = "SELECT * FROM thongtin WHERE Ten = ?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			//ps.setString(1, Ten);
//			
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//	}
}
