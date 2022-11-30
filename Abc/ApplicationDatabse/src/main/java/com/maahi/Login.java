package com.maahi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	RequestDispatcher rd=request.getRequestDispatcher("login.html");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String uid1=request.getParameter("uid");
		String pswd1=request.getParameter("pswd");
		System.out.println(uid1+"   "+pswd1);

		
		
		PrintWriter out =response.getWriter();
	
		
		Connection conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","A2016ece@4701");
		Statement st=conn.createStatement();
	
			
	String query1="select * from customer where UserName="+"'"+uid1+"'"+" AND password="+"'"+pswd1+"'";
	ResultSet set1=st.executeQuery(query1);
	String uid="";
	String pwd="";
	
	
	
	while(set1.next()) {
		uid=set1.getString(4);
		pwd=set1.getString(5);
		
	}
	System.out.println(uid+"    "+pwd);
	out.println(uid+"    "+pwd);
	if(uid.equals(uid1) && pwd.equals(pswd1) )
	{
		System.out.println("Login Succesfull");
		out.println("Login Succesfull");
	}
	else {
		System.out.println("Login UnSuccesfull");
		out.println("Login UnSuccesfull");
	}
	//out.println("Login Succesfull");
			
	}catch(Exception e) {
		e.printStackTrace();
	}
	}	
}