package Entities;

import java.util.Set;

public class ThongTin {
	String ten;
	String email;
	String sDT;
	public ThongTin(String ten, String email, String sDT) {
		super();
		this.ten = ten;
		this.email = email;
		this.sDT = sDT;
	}
	public ThongTin() {
		super();
		this.ten = null;
		this.email = null;
		this.sDT = null;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	
	public void updateTT() {
		
	}
	public void updateIF() {
		
		
	}
	
	
}
