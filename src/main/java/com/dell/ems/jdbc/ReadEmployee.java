package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadEmployee {
	
	static Connection conn=null;
	static Statement stm= null;
	static ResultSet rst=null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			conn = DatabaseConnection.initConnection();
			stm=conn.createStatement();
			String query= "select * from employee";
			 rst=stm.executeQuery(query);
			 printData(rst);
		} catch (Exception e) {
			// TODO: handle exception
		}
		

	}
	private static void printData(ResultSet rst) throws SQLException
    {
    	while(rst.next())
    	{
    		System.out.println("-----------------------------------------------------------------------------------------------");
    		System.out.println("| ID | "+rst.getInt("id")+",| Name | "+rst.getString("full_name")+"| Email | "+rst.getString("email")+", | salary | "+rst.getDouble("salary")+"| dept | "+rst.getString("dept"));		   	
    	}
    }

}
