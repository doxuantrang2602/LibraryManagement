package Entities;

import java.util.Scanner;

public class User {
	private String username;
	private String password;
	private String repassword;
	
	public User() {
		this.username = null;
		this.password = null;
		this.repassword = null;
	}
	public User(String username, String password) {
	
		this.username = username;
		this.password = password;
	}
	
	public User(String username, String password, String repassword) {
		super();
		this.username = username;
		this.password = password;
		this.repassword = repassword;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean checkPassword (String password) {
		return this.password.equals(password);
	}
	
	public void LogIn() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username: ");
		username = sc.next();
		System.out.println("Enter your password: ");
		password = sc.next();
	}
	
	public void SignUp() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username:");
		username = sc.next();
		System.out.println("Enter your password: ");
		password = sc.next();
		System.out.println("Enter your repassword:");
		repassword = sc.next();
	}
	
	
}
