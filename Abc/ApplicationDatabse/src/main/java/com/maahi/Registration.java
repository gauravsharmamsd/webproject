package com.maahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		RequestDispatcher rd=request.getRequestDispatcher("register.html");
//		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
        PrintWriter wr=response.getWriter();
        wr.println("This is the post method.");
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String uid=request.getParameter("uid");
		String email=request.getParameter("email");
		String pswd=request.getParameter("pswd");
		System.out.println(name);

		
		PrintWriter out =response.getWriter();
		out.println("<html><body><h1> Registration Sucess</h1></body><html>");
		System.out.println("UserIdd: "+uid+"\nEmail: "+email+"\nPassword: "+pswd+" \nName: "+name+" \nphoneNo:"+phone);

		Connection conn = null;
		   PreparedStatement ps = null;

		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","A2016ece@4701");
		
//			System.out.println("Driver connected");
//		String q1="create table customer(Name varchar(20),Phone varchar(20),Email varchar(20),UserName varchar(20),Password varchar(20))";
//  
//		ps = conn.prepareStatement(q1);
//
//			ps.executeUpdate(q1);
	
	//	System.out.println("Table created______________");	
		ps=conn.prepareStatement("insert into customer values(?,?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setString(3,email);
			ps.setString(4,uid);
			ps.setString(5,pswd);
			int x=ps.executeUpdate();
			System.out.println(x);
			wr.println("Data inserted Succesfully ......   "+x);
			wr.println("<br>");
			wr.println("<br>");
			wr.println("<a href ='DisplayServlet'> Click here to display record...</a>");
			
		//	System.out.println();
		
		
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}

	}

}
