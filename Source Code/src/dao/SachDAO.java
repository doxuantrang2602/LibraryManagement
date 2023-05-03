package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entities.QLSach_Model;
import Entities.Sach;

public class SachDAO {
	private Connection conn;
	
	public SachDAO(){
		
			try {
				// Đọc File
//	            BufferedReader br = new BufferedReader(new FileReader("D:\\Code_Java\\Java_Project\\BaiTapLon_QLTV_Copy2\\Java_QLTV.txt"));
//	            String url = br.readLine();
//	            String username = br.readLine();
//	            String password = br.readLine();
//	            br.close();
	            
	            // register JDBC driver
	            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
	            
	            String url = "jdbc:mySQL://localhost:3306/qltv";
				String username = "root";
				String password = "";
	            conn = DriverManager.getConnection(url, username, password);
	            
	            System.out.println("Kết nối thành công !");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	} 
	public void getListSach(QLSach_Model ds_Sach){
		String sql = "SELECT* FROM sach";
		
		try {
			PreparedStatement ps = this.conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Sach s = new Sach();
				s.setMaSach(rs.getInt("maSach"));
				s.setTenSach(rs.getString("tenSach"));
				s.setTagGia(rs.getString("tacGia"));
				s.setTheLoai(rs.getString("theLoai"));
				s.setNamXB(rs.getInt("namXB"));
				s.setSoLuongCon(rs.getInt("soLuongCon"));
				
				ds_Sach.getDsSach().add(s);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	public boolean addSach(Sach s) {
		
		String sql = "INSERT INTO sach(maSach,tenSach,tacGia,theLoai,namXB,soLuongCon)"
				+ "VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, s.getMaSach());
			ps.setString(2, s.getTenSach());
			ps.setString(3, s.getTagGia());
			ps.setString(4, s.getTheLoai());
			ps.setInt(5, s.getNamXB());
			ps.setInt(6, s.getSoLuongCon());
			
			return ps.executeUpdate() >0;
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return false;
	}
	
	 public boolean deleteSach(Sach s) {
		 String sql = "DELETE FROM sach WHERE maSach = ?";
		 
		 try {
			 PreparedStatement ps = conn.prepareStatement(sql);
			 ps.setInt(1, s.getMaSach());
			 
			return ps.executeUpdate() >0;

		} catch (Exception e) {
			// TODO: handle exception
		}
		 
		return false;
	 }
	
	public boolean updateSach(Sach s) {
		try {
			String sql = "UPDATE sach "+
					     "SET " +
					     "tenSach=?"+
					     ", tacGia=?"+
					     ", theLoai=?"+
					     ", namXB=?"+
					     ", soLuongCon=?"+
					     " WHERE maSach = ?";
			PreparedStatement pst = conn.prepareStatement(sql);
					
			pst.setString(1, s.getTenSach());
			pst.setString(2, s.getTagGia());
			pst.setString(3, s.getTheLoai());
			pst.setInt(4, s.getNamXB());
			pst.setInt(5, s.getSoLuongCon());
			pst.setInt(6,s.getMaSach());
			
			return pst.executeUpdate() >0;
		} catch (Exception e) {
			// TODO: handle exception
		} 
		return false;
	}
	public Sach selectByid(int id_tim) {
		Sach sach = null;
		try {
			String sql = "SELECT* FROM sach WHERE maSach = ? ";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1, id_tim);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int maSach = rs.getInt("maSach");
				String tenSach = rs.getString("tenSach");
				String tacGia = rs.getString("tacGia");
				String theLoai = rs.getString("theLoai");
				int namXB = rs.getInt("namXB");
				int soLuongCon = rs.getInt("soLuongCon");
				
				sach = new Sach(maSach, tenSach, tacGia, theLoai, namXB, soLuongCon);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return sach;
	}
	
	public ArrayList<Sach> selectByKeyword(String keyword) {
	    ArrayList<Sach> sachList = new ArrayList<>();
	    try {
	        String sql = "SELECT * FROM sach WHERE maSach LIKE ? OR tenSach LIKE ? "
	        		+ "OR tacGia LIKE ? OR theLoai LIKE ? OR namXB LIKE ? OR soLuongCon LIKE ?";
	        PreparedStatement pst = conn.prepareStatement(sql);
	        pst.setString(1, "%" + keyword + "%");
	        pst.setString(2, "%" + keyword + "%");
	        pst.setString(3, "%" + keyword + "%");
	        pst.setString(4, "%" + keyword + "%");
	        pst.setString(5, "%" + keyword + "%");
	        pst.setString(6, "%" + keyword + "%");
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	            int maSach = rs.getInt("maSach");
	            String tenSach = rs.getString("tenSach");
	            String tagGia = rs.getString("tacGia");
	            String theLoai = rs.getString("theLoai");
	            int namXB = rs.getInt("namXB");
	            int soLuongCon = rs.getInt("soLuongCon");
	            Sach sach = new Sach(maSach, tenSach, tagGia, theLoai, namXB, soLuongCon);
	            sachList.add(sach);
	        }
	        conn.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return sachList;
	}


	
	
	public static void main(String[] args) {
		new SachDAO();
	}
}
