package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConncetion {

	
	public static Connection getConnection() {
		
		Connection con = null;
		String jdbcUrl ="jdbc:mysql://localhost:3306/demo";
		String driver = "com.mysql.cj.jdbc.Driver";
		String user = "root";
		String Pass ="Nikhil";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcUrl,user,Pass);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
