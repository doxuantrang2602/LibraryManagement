package database;

import java.sql.Connection;

import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JBDCUtil {
	public static Connection getConnection() {
		Connection c = null;
		
//		com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
//		DriverManager.registerDriver(driver);
		try {
			//đăng kí mysql driver vs driver manager
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url = "jdbc:mySQL://localhost:3306/qltv";
			String username = "root";
			String password = "";
			c = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	public static void closeConnection(Connection c) {
		try {
			if (c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if (c!=null) {
				 DatabaseMetaData mtdt = c.getMetaData();
				System.out.println(mtdt.getDatabaseProductName());
				
			}
		} catch ( SQLException e) {
			// TODO: handle exception
		}
	}
}
