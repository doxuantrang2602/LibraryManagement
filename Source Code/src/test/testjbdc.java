package test;

import java.sql.Connection;


import database.JBDCUtil;

public class testjbdc {
	public static void main (String [] args) {
		Connection connection = JBDCUtil.getConnection();
		
		JBDCUtil.printInfo(connection);
		
		JBDCUtil.closeConnection(connection);
	}
}
