package Entities;

import java.util.ArrayList;

public class QLThongTin_model {
	ArrayList<ThongTin> tt;

	public QLThongTin_model(ArrayList<ThongTin> tt) {
		super();
		this.tt = tt;
	}

	public QLThongTin_model() {
		this.tt = new ArrayList<ThongTin>();
	}

	public ArrayList<ThongTin> getTt() {
		return tt;
	}

	public void setTt(ArrayList<ThongTin> tt) {
		this.tt = tt;
	}
	
	public void Insert(ThongTin thongTin) {
		this.tt.add(thongTin);
	}
	
	public void Update(ThongTin thongTin) {
		this.tt.removeIf(oldThongTin -> oldThongTin.getTen() == thongTin.getTen());
		this.tt.add(thongTin);
	}
}
