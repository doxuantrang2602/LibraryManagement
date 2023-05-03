package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;


import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.QLSV_Model;
import Entities.Sach;
import Entities.SinhVien;


public class SinhVienDao {
	private Connection conn;
	
	public SinhVienDao() {
		try {
			
			// Đọc File
//			BufferedReader br = new BufferedReader(new FileReader("D:\\Code_Java\\Java_Project\\BaiTapLon_QLTV_Copy2\\Java_QLTV.txt"));
//			String url = br.readLine();
//			String user = br.readLine();
//			String password = br.readLine();
//			br.close();
			
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            
            String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
            conn = DriverManager.getConnection(url, username, password);
            
            System.out.println("Kết nối thành công !");
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public void getListSV(QLSV_Model ds_SV) {
		String sql = "SELECT* FROM sinhvien";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				SinhVien sv = new SinhVien();
				sv.setMaSV(rs.getInt(1));
				sv.setHoVaTen(rs.getString(2));
				sv.setQueQuan(rs.getString(3));
				sv.setNgaySinh(rs.getDate(4));
				sv.setLopKhoa(rs.getString(5));
				sv.setEmail(rs.getString(6));
				sv.setsDT(rs.getString(7));
				
				ds_SV.getDsSinhVien().add(sv);
			}
			conn.close();
		} catch (Exception e) {
			
		} 
	}
	
	public boolean addSV(SinhVien sv) {
		String sql = "INSERT INTO sinhvien(maSV, hoVaTen,queQuan, ngaySinh, lopKhoa, email, sDT)"
					 +"VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setInt(1, sv.getMaSV());
			pst.setString(2, sv.getHoVaTen());
			pst.setString(3, sv.getQueQuan());
			pst.setDate(4, sv.getNgaySinh());
			pst.setString(5, sv.getLopKhoa());
			pst.setString(6, sv.getEmail());
			pst.setString(7, sv.getsDT());
			
			return pst.executeUpdate()>0;
			
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return false;			
	}
	
	public boolean deteleSV(SinhVien sv) {
		String sql = "DELETE FROM sinhvien WHERE maSV = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, sv.getMaSV());
			
			return pst.executeUpdate() >0;
		
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return false;
	}
	
	public boolean updateSV(SinhVien sv) {
		
		try {
			String sql = "UPDATE sinhvien "+
						 "SET "+
						 "hoVaTen=?"+
						 ", queQuan=?"+
						 ", ngaySinh=?"+
						 ", lopKhoa=?"+
						 ", email=?"+
						 ", sDT=?"+
						 " WHERE maSV= ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, sv.getHoVaTen());
			pst.setString(2, sv.getQueQuan());
			pst.setDate(3, sv.getNgaySinh());
			pst.setString(4, sv.getLopKhoa());
			pst.setString(5, sv.getEmail());
			pst.setString(6, sv.getsDT());
			pst.setInt(7, sv.getMaSV());
			
			return pst.executeUpdate()>0;
		
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return false;
	}
	
	public SinhVien selectByID_SV(int id_SV_Tim) {
		SinhVien sv = null;
		
		try {
			String sql = "SELECT* FROM sinhvien WHERE maSV = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id_SV_Tim);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int maSV = rs.getInt(1);
				String hoVaTen = rs.getString(2);
				String queQuan = rs.getString(3);
				Date ngaySinh = rs.getDate(4);
				String lopKhoa = rs.getString(5);
				String email = rs.getString(6);
				String sDT = rs.getString(7);
				
				sv = new SinhVien(maSV, hoVaTen, queQuan, ngaySinh, lopKhoa, email, sDT);
				
			}
			conn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		
		return sv;
	}
	
	public ArrayList<SinhVien> selectByKeyword(String keyword) {
	    ArrayList<SinhVien> SV_List = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM sinhvien WHERE maSV LIKE ? OR hoVaTen LIKE ? "
	        		+ "OR queQuan LIKE ? OR ngaySinh LIKE ? OR lopKhoa LIKE ? "
	        		+ "OR email LIKE ? OR sDT LIKE ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, "%" + keyword + "%");
	        pst.setString(2, "%" + keyword + "%");
	        pst.setString(3, "%" + keyword + "%");
	        pst.setString(4, "%" + keyword + "%");
	        pst.setString(5, "%" + keyword + "%");
	        pst.setString(6, "%" + keyword + "%");
	        pst.setString(7, "%" + keyword + "%");
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            int maSV = rs.getInt(1);
	            String hoVaTen = rs.getString(2);
	            String queQuan = rs.getString(3);
	            Date ngaySinh = rs.getDate(4);
	            String lopKhoa = rs.getString(5);
	            String email = rs.getString(6);
	            String sDT = rs.getString(7);
	            
	            SinhVien sv = new SinhVien(maSV, hoVaTen, queQuan, ngaySinh, lopKhoa, email, sDT);
	            SV_List.add(sv);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return SV_List;
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		new SinhVienDao();
	}
	
}
