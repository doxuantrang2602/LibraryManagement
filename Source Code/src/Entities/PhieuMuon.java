package Entities;

import java.sql.Date;
import java.util.Objects;

public class PhieuMuon {
	private String maPhieu;
	private int maSV;
	private Date ngayMuon;
	private int maSach;
	private int soLuong;
	
	public PhieuMuon() {
	}

	public PhieuMuon(String maPhieu, int maSV, Date ngayMuon, int maSach, int soLuong) {
		this.maPhieu = maPhieu;
		this.maSV = maSV;
		this.ngayMuon = ngayMuon;
		this.maSach = maSach;
		this.soLuong = soLuong;
	}

	public String getMaPhieu() {
		return maPhieu;
	}

	public void setMaPhieu(String maPhieu) {
		this.maPhieu = maPhieu;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public Date getNgayMuon() {
		return ngayMuon;
	}

	public void setNgayMuon(Date ngayMuon) {
		this.ngayMuon = ngayMuon;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "PhieuMuon [maPhieu=" + maPhieu + ", maSV=" + maSV + ", ngayMuon=" + ngayMuon + ", maSach=" + maSach
				+ ", soLuong=" + soLuong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhieu, maSV, maSach, ngayMuon, soLuong);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PhieuMuon other = (PhieuMuon) obj;
		return Objects.equals(maPhieu, other.maPhieu) && maSV == other.maSV && maSach == other.maSach
				&& Objects.equals(ngayMuon, other.ngayMuon) && soLuong == other.soLuong;
	}
	

	
	
	
	

}
