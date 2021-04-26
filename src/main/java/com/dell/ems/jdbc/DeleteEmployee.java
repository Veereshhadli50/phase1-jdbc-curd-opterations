package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DeleteEmployee {
	
	static Connection conn=null;
	static Statement stm= null;
	static ResultSet rst=null;
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		try {
			//conn = DatabaseConnection.initConnection();
			//1.get connection and create statement 
			stm=DatabaseConnection.initConnection().createStatement();
			String query= "delete from employee "+			
					"where id=6";
			 int rowsaffacted=stm.executeUpdate(query);
			 
			 if(rowsaffacted>0)
				 System.out.println("Number of rows affacted : "+ rowsaffacted);
			// printData(rst);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		finally 
		{
			if(stm != null)
				try {
					stm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

	}

}
