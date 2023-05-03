package Entities;

import java.io.Serializable;
import java.util.Objects;

public class Sach implements Serializable {
	private int maSach;
	private String tenSach;
	private String tagGia;
	private String theLoai;
	private int namXB;
	private int soLuongCon;
	
	public Sach() {
	}
	
	public Sach(int maSach, String tenSach, String tagGia, String theLoai, int namXB, int soLuongCon) {
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tagGia = tagGia;
		this.theLoai = theLoai;
		this.namXB = namXB;
		this.soLuongCon = soLuongCon;
	}
	public int getMaSach() {
		return maSach;
	}
	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public String getTagGia() {
		return tagGia;
	}
	public void setTagGia(String tagGia) {
		this.tagGia = tagGia;
	}
	public String getTheLoai() {
		return theLoai;
	}
	public void setTheLoai(String theLoai) {
		this.theLoai = theLoai;
	}
	public int getNamXB() {
		return namXB;
	}
	public void setNamXB(int namXB) {
		this.namXB = namXB;
	}
	public int getSoLuongCon() {
		return soLuongCon;
	}
	public void setSoLuongCon(int soLuongCon) {
		this.soLuongCon = soLuongCon;
	}
	@Override
	public String toString() {
		return "Sach [maSach=" + maSach + ", tenSach=" + tenSach + ", tagGia=" + tagGia + ", theLoai=" + theLoai
				+ ", namXB=" + namXB + ", soLuongCon=" + soLuongCon + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(maSach, namXB, soLuongCon, tagGia, tenSach, theLoai);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		return maSach == other.maSach && namXB == other.namXB && soLuongCon == other.soLuongCon
				&& Objects.equals(tagGia, other.tagGia) && Objects.equals(tenSach, other.tenSach)
				&& Objects.equals(theLoai, other.theLoai);
	}
	
	
	
}
