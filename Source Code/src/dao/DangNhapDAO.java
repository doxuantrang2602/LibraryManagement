package dao;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.text.StyledEditorKit.BoldAction;

import com.mysql.cj.jdbc.Driver;

import database.JBDCUtil;
import view.QLTV_View;
import Entities.*;

public class DangNhapDAO {
	private Connection con;
	
	public DangNhapDAO() {
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
			
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public boolean signUp(String username, String password) {
		Connection con = null;
		PreparedStatement su = null;
		
		try {
			con = JBDCUtil.getConnection();
			
			String sql = "SELECT COUNT(*) FROM dangnhap WHERE Username = ?";
			su = con.prepareStatement(sql);
			su.setString(1, username);

			ResultSet rs = su.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if (count > 0) {
				JOptionPane.showMessageDialog(null, "Tài khoản đã tồn tại");
			} else {
				JOptionPane.showMessageDialog(null, "Đăng kí thành công");
			}
			sql = "INSERT INTO dangnhap(Username,Password) VALUES (?,?)";
			 su = con.prepareStatement(sql);
		        su.setString(1, username);
		        su.setString(2, password);
		        su.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			JBDCUtil.closeConnection(con);
		}
		return true;
	}

	public boolean login(String username, String password){
	    boolean loggedIn = false;
	    try {
	       // Connection con = JBDCUtil.getConnection(); // Kết nối đến cơ sở dữ liệu
	        String sql = "SELECT * FROM dangnhap WHERE Username = ? AND Password = ?";
	        PreparedStatement pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, username);
	        pstmt.setString(2, password);
	        ResultSet rs = pstmt.executeQuery(); // Truy vấn cơ sở dữ liệu
	        if (rs.next()) {
	            loggedIn = true; // Nếu tìm thấy kết quả, đăng nhập thành công
	//            if (loggedIn == true) {
	            	JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
	            	try {
	       			 for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	       	                if ("Nimbus".equals(info.getName())) {
	       	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	       	                    break;
	       	                }
	       	            }
	       			new QLTV_View();
	       		} catch (Exception e) {
	       			e.printStackTrace();
	       		}
	            }
	        if (loggedIn == false)
	        {
	            	JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc mật khẩu không đúng");
	        }
	        JBDCUtil.closeConnection(con);
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	    return loggedIn;
	}
	
	
	public static void main(String[] args) {
		new DangNhapDAO();
	}


}
