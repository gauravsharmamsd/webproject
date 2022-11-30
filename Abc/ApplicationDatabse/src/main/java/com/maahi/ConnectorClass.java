package com.maahi;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

import java.util.Properties;

public class ConnectorClass{
	
	static Connection conn ;
	
		  public static  Connection  createConnection() {
			  FileInputStream fi = null;
			try {
				fi = new FileInputStream("db.properties");
				Properties pro = new Properties();
				pro.load(fi);
			    String driver = pro.getProperty("driver");
				String url    = pro.getProperty("url");
				String uid    = pro.getProperty("uid");
				String pwd    = pro.getProperty("pwd");
		
				Class.forName(driver);
				System.out.println("Class loaded");
				conn=(Connection) DriverManager.getConnection(url,uid,pwd);
				System.out.println("Driver connected");}
		
			  catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			  return conn;
		  
		

	}}