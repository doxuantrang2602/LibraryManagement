package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;

import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Entities.PhieuMuon;
import Entities.QLPhieuMuon_Model;

public class PhieuMuonDao {
	private Connection conn;
	
	public PhieuMuonDao() {
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
	public void getListPM(QLPhieuMuon_Model ds_PM) {

		String sql = "SELECT* FROM phieumuon";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				PhieuMuon pm = new PhieuMuon();
				pm.setMaPhieu(rs.getString(1));
				pm.setMaSV(rs.getInt(2));
				pm.setNgayMuon(rs.getDate(3));
				pm.setMaSach(rs.getInt(4));
				pm.setSoLuong(rs.getInt(5));
				
				ds_PM.insertPM(pm);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
	}
	
	public boolean addPM(PhieuMuon pm) {
		String sql = "INSERT INTO phieumuon(maPhieu, maSV, ngayMuon, maSach, soLuong) "+
					 "VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			
			pst.setString(1, pm.getMaPhieu());
			pst.setInt(2, pm.getMaSV());
			pst.setDate(3, pm.getNgayMuon());
			pst.setInt(4, pm.getMaSach());
			pst.setInt(5, pm.getSoLuong());
			
			return pst.executeUpdate()>0;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
		return false;
	}
	
	public boolean deletePM(PhieuMuon pm) {
		String sql = "DELETE FROM phieumuon where maPhieu = ?";
		
		try {
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, pm.getMaPhieu());
			
			return pst.executeUpdate()>0;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
		return false;
	}
	
	public boolean updatePM(PhieuMuon pm) {
		try {
			String sql = "UPDATE phieumuon "+
				     "SET " +
				     "maSV=?"+
				     ", ngayMuon=?"+
				     ", maSach=?"+
				     ", soLuong=?"+
				     " WHERE maPhieu = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			
			
			pst.setInt(1, pm.getMaSV());
			pst.setDate(2, pm.getNgayMuon());
			pst.setInt(3, pm.getMaSach());
			pst.setInt(4, pm.getSoLuong());
			pst.setString(5, pm.getMaPhieu());
			
			return pst.executeUpdate()>0;
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
		return false;
	}
	
	public PhieuMuon selectByid(String id_timMP) {
		PhieuMuon pm = null;
		try {
			String sql = "SELECT* FROM phieumuon WHERE maPhieu = ?";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setString(1, id_timMP);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				String maPhieu = rs.getString(1);
				int maSV = rs.getInt(2);
				Date ngayMuon = rs.getDate(3);
				int maSach = rs.getInt(4);
				int soLuong = rs.getInt(5);
				
				pm = new PhieuMuon(maPhieu, maSV, ngayMuon, maSach, soLuong);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
		
		return pm;
		
	}

	public int tinhTongSach() {
		int S = 0;
		try {
			String sql = "SELECT SUM(soLuong) FROM phieumuon";
			
			PreparedStatement pst = conn.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				S = rs.getInt(1);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
	        try {
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            // TODO: handle exception
	        }
	    }
		return S;
		
	}
	
	
	
	
	public static void main(String[] args) {
		new PhieuMuonDao();
	}
	
	
	
}
