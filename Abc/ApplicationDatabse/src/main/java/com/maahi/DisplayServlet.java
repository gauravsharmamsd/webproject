package com.maahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DisplayServlet implements Servlet {
	private static final long serialVersionUID = 1L;
       

    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

 

	
		
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("Atlaeast callwed ones......");
		
	}

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter wr=response.getWriter();//To add the response to obj
        wr.println("This is the get method only.....");
//        HttpSession session =request.getSession(false);
//        String userId=(String) session.getAttribute("uid");
//        String password=(String) session.getAttribute("pswd");
//        System.out.println("user Id is   "+userId);
//        System.out.println("password is   "+password);
		Connection  conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","A2016ece@4701");
		Statement st=conn.createStatement();
	//	System.out.println("Driver connected");
	ResultSet set=	st.executeQuery("select * from customer");
	//System.out.println("__________________________");
	while(set.next()) {
		System.out.println("User id is"+set.getString(4));
		System.out.println("password is"+set.getString(5));
		wr.println(set.getString(1)+"   "+set.getString(2)+"   "+set.getString(3)+"   "+set.getString(4)+"   "+set.getString(5));
	wr.println("<br>");
	}
	//wr.println("<a href='registerpage'> Click here to Add record....</a>");
	
	
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	public void destroy() {
		System.out.println("Hit rewstart to destroy");
		
	}

		
	}

	
	


