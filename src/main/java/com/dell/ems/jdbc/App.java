package com.dell.ems.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;


public class App 
{
	
	//data source related properties 
    static final String DBURL="jdbc:mysql://localhost:3306/ems_system";
	static final String JDBC_DRIVER ="com.mysql.cj.jdbc.Driver";
	static final String USERNAME="root";
	static final String PASSWORD="root";
	
	public static void main( String[] args )
    {
		Connection conn=null;
		Statement stm= null;
		ResultSet rst=null;
        //1.Registering JDBC driver
        try {
			Class.forName(JDBC_DRIVER); 
			
			//2.get connection
			 conn = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
			//3.create JDBC statement
			 stm=conn.createStatement();
			//4.Execute
			 String query= "select * from employee";
			 rst=stm.executeQuery(query);
			 //Print result 
			 printData(rst);
			 if(conn !=null)
			 System.out.println("Connection established");
			 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			 System.out.println("Connection is failed ");
			e.printStackTrace();
		}finally 
        {
			//cleanup
			//close connection
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
	 private static void printData(ResultSet rst) throws SQLException
     {
     	while(rst.next())
     	{
     		System.out.println("-----------------------------------------------------------------------------------------------");
     		System.out.println("| ID | "+rst.getInt("id")+",| Name | "+rst.getString("full_name")+"| Email | "+rst.getString("email")+", | salary | "+rst.getDouble("salary")+"| dept | "+rst.getString("dept"));
     		
     	
     		
     		
     	}
     }
}
