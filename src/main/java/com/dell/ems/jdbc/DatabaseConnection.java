package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	static final String DBURL="jdbc:mysql://localhost:3306/ems_system";
	static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String USERNAME="root";
	static final String PASSWORD="root";
	
	public static Connection initConnection()
	{
		Connection conn=null;
		try {
			Class.forName(JDBC_DRIVER);
			try {
				conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return conn;
		 
		
	}
}
