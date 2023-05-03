package Entities;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QLSach_Model {
	private ArrayList<Sach> dsSach;
	private String tenFile;
	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	
	public QLSach_Model() {
		this.dsSach = new ArrayList<Sach>();
		this.tenFile = "";
	}
	public QLSach_Model(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}
	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}

	
	public String getTenFile() {
		return tenFile;
	}
	public void setTenFile(String tenFile) {
		this.tenFile = tenFile;
	}
	public void insert(Sach sach) {
		executorService.execute( ()->{			
			this.dsSach.add(sach);
		});
		
	}
	public boolean delete(Sach s) {
		executorService.execute( ()->{			
			this.dsSach.remove(s);
		});
		return false;
		
	}
	
	public void update(Sach s) {
		executorService.execute( ()->{			
			this.dsSach.removeIf(oldSach -> oldSach.getMaSach() == s.getMaSach());
		    this.dsSach.add(s);
		});		
	}
	
	public boolean kiemTraTonTaiSach(Sach s) {		
		for (Sach sach : dsSach) {
			if(sach.getMaSach() == s.getMaSach()) {
				return true;
			}
		}
		return false;
	}
	
	// Hàm đóng ExecutorService khi không sử dụng nữa
	public void shutdown() {
		executorService.shutdown();
	}
	
	
}
