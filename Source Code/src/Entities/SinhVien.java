package Entities;

import java.sql.Date;


import java.util.Objects;

public class SinhVien {
	private int maSV;
	private String hoVaTen;
	private String queQuan;
	private Date ngaySinh;
	private String lopKhoa;
	private String email;
	private String sDT;
	
	public SinhVien() {
	}

	public SinhVien(int maSV, String hoVaTen, String queQuan, Date ngaySinh, String lopKhoa,
			String email, String sDT) {
		this.maSV = maSV;
		this.hoVaTen = hoVaTen;
		this.queQuan = queQuan;
		this.ngaySinh = ngaySinh;
		this.lopKhoa = lopKhoa;
		this.email = email;
		this.sDT = sDT;
	}

	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int maSV) {
		this.maSV = maSV;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getQueQuan() {
		return queQuan;
	}

	public void setQueQuan(String queQuan) {
		this.queQuan = queQuan;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public String getLopKhoa() {
		return lopKhoa;
	}

	public void setLopKhoa(String lopKhoa) {
		this.lopKhoa = lopKhoa;
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

	@Override
	public String toString() {
		return "SinhVien [maSV=" + maSV + ", hoVaTen=" + hoVaTen + ", queQuan=" + queQuan + ", ngaySinh=" + ngaySinh
				+  ", lopKhoa=" + lopKhoa + ", email=" + email + ", sDT=" + sDT + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email,  hoVaTen, lopKhoa, maSV, ngaySinh, queQuan, sDT);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(email, other.email)
				&& Objects.equals(hoVaTen, other.hoVaTen) && Objects.equals(lopKhoa, other.lopKhoa)
				&& maSV == other.maSV && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(queQuan, other.queQuan) && Objects.equals(sDT, other.sDT);
	}
	
	
}
