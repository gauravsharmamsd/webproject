package com.maahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public CustomerServlet() {
        // TODO Auto-generated constructor stub
    }

	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html");
//        PrintWriter wr=response.getWriter();//To add the response to obj
//        wr.println("This is the get method");
//	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE SET THE CONTENT  TYPE OF RESPONSE BEING SEND TO CLUENT
        PrintWriter wr=response.getWriter();//To add the response to RESPONSE OBJ
        wr.println("This is the post method.");
    	wr.println("<html><body><h1> Registration Sucess</h1></body><html>");

    	String firstName=request.getParameter("firstName");
		String lastName=request.getParameter("lastName");
		String email=request.getParameter("email");
		String userId=request.getParameter("uid");
		String password=request.getParameter("pswd");
		
		//wr.println("<html><body><h1> Registration Sucess</h1></body><html>");
        HttpSession session = request.getSession();
        
        session.setAttribute("uid", userId);
        session.setAttribute("pwd", password);
        
        
        
        
       
		Connection conn = null;
		   PreparedStatement ps = null;

		
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
		
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","A2016ece@4701");
		
//			System.out.println("Driver connected");
//		String q1="create table customer(FirstName varchar(20),LastName varchar(20),Email varchar(20),UserName varchar(20),Password varchar(20))";
//  
//		ps = conn.prepareStatement(q1);
//
//
//			ps.executeUpdate(q1);
//	
		System.out.println("Table created______________");	
		ps=conn.prepareStatement("insert into student values(?,?,?,?,?)");
			ps.setString(1,firstName);
			ps.setString(2,lastName);
			ps.setString(3,email);
			ps.setString(4,userId);
			ps.setString(5,password);
			int x=ps.executeUpdate();
			System.out.println(x);
			wr.println("Data inserted .....f.   "+x);
			wr.println("<a href ='DisplayServlet'> Click here to display record...</a>");
			
			wr.println("Data inserted ...   "+x);
				
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	}
	}


	
	

}
