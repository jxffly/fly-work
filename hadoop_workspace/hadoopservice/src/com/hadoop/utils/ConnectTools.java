package com.hadoop.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;







public class ConnectTools {
	static String driver = "com.mysql.jdbc.Driver";
	static String dbName = "hadoop";
	static String passwrod = "123456";
	static String userName = "root";
	static String url = "jdbc:mysql://localhost:3306/" + dbName;
	static Connection conn;

	
	public static Connection getConnection(){
		if(conn==null){
			 try {
		            Class.forName(driver);
		             conn =  DriverManager.getConnection(url, userName,
		                    passwrod);   
		 
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
			 return conn;
		}else{
			return conn;
		}
		
		
	}
	public static void  closeConnetion(Connection connect,ResultSet rs,PreparedStatement psmt){
		try {
			rs.close();
			psmt.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void  closeConnetion(Connection connect,PreparedStatement psmt){
		try {
			psmt.close();
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	

}
