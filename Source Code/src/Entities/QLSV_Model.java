package Entities;

import java.util.ArrayList;

import java.util.Objects;

public class QLSV_Model {
	private ArrayList<SinhVien> dsSinhVien;
	
	public QLSV_Model() {
		this.dsSinhVien = new ArrayList<SinhVien>();
	}
	
	public QLSV_Model(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}

	public ArrayList<SinhVien> getDsSinhVien() {
		return dsSinhVien;
	}

	public void setDsSinhVien(ArrayList<SinhVien> dsSinhVien) {
		this.dsSinhVien = dsSinhVien;
	}


	public void insert(SinhVien sv) {
		this.dsSinhVien.add(sv);
	}
	public void delete(SinhVien sv) {
		this.dsSinhVien.remove(sv);
	}
	public void update(SinhVien sv) {
		this.dsSinhVien.removeIf(oldSV -> oldSV.getMaSV() == sv.getMaSV());
		this.dsSinhVien.add(sv);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QLSV_Model other = (QLSV_Model) obj;
		return Objects.equals(dsSinhVien, other.dsSinhVien);
	}

	public boolean kiemTraTonTaiSV(SinhVien sv) {
		for (SinhVien sinhVien : dsSinhVien) {
			if(sinhVien.getMaSV() == sv.getMaSV()) {
				return true;
			}
		}
		return false;
	}
	
	
}
