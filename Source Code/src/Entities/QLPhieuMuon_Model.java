package Entities;

import java.util.ArrayList;
import java.util.Objects;


public class QLPhieuMuon_Model {
	private ArrayList<PhieuMuon> dsPhieuMuon;
	
	public QLPhieuMuon_Model() {
		this.dsPhieuMuon = new ArrayList<PhieuMuon>();
	}
	
	public QLPhieuMuon_Model(ArrayList<PhieuMuon> dsPhieuMuon) {
		this.dsPhieuMuon = dsPhieuMuon;
	}

	public ArrayList<PhieuMuon> getDsPhieuMuon() {
		return dsPhieuMuon;
	}

	public void setDsPhieuMuon(ArrayList<PhieuMuon> dsPhieuMuon) {
		this.dsPhieuMuon = dsPhieuMuon;
	}
	
	public void insertPM(PhieuMuon pm) {
		this.dsPhieuMuon.add(pm);
	}
	public boolean deletePM(PhieuMuon pm) {
		this.dsPhieuMuon.remove(pm);
		return false;
	}
	public void updatePM(PhieuMuon pm) {
		this.dsPhieuMuon.removeIf(oldPM -> oldPM.getMaPhieu().equals(pm.getMaPhieu()));
		this.dsPhieuMuon.add(pm);
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(dsPhieuMuon);
	}

	public boolean kiemTraTonTai_PM(PhieuMuon pm) {
		for (PhieuMuon phieumuon : dsPhieuMuon) {
			if(pm.getMaPhieu().equals(phieumuon.getMaPhieu())) {
				return true;
			}
		}
		return false;
	}
	
}
