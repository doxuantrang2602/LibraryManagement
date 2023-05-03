package Entities;

import java.util.ArrayList;

public class QL_Dangki {
	ArrayList<User> us;

	public QL_Dangki() {
		this.us = new ArrayList<User>();
	}
	
	public QL_Dangki(ArrayList<User> us) {
		super();
		this.us = us;
	}
	
	public ArrayList<User> getUs() {
		return us;
	}

	public void setUs(ArrayList<User> us) {
		this.us = us;
	}
	
	public void insert(User user) {
		this.us.add(user);
	}
	
	public void update(User user) {
		this.us.removeIf(oldUser -> oldUser.getUsername() == user.getUsername());
		this.us.add(user);
	}
	
}
