package com.ata.util;

import java.sql.Connection;
//import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Config {
	
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/ata", "navi", "Navi1@");
			System.out.println("connected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return con;
	}
	public static String closeConnection() {
		try {
			con.close();
			System.out.println("Connection Closed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return("connection closed");
	}
	
}
