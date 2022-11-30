package com.maahi;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CustomerLogin() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	doPost(request,response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE SET THE CONTENT  TYPE OF RESPONSE BEING SEND TO CLUENT
        PrintWriter wr=response.getWriter();//To add the response to RESPONSE OBJ
        wr.println("This is the get method of login....");
        HttpSession session =request.getSession(false);
        String userId=(String) session.getAttribute("uid");
        String password=(String) session.getAttribute("pwd");
        System.out.println("user Id is   "+userId);
        System.out.println("password is   "+password);
        wr.println("<html><body><p> UserID:<input type =\"text\" name=\"uid\"/></p>   Password:<input type =\"text\" name=\"password\"/> <br><br>   <input type =\"submit\" value=\"Login\"/></p> </body> </html>");
        String uid1=request.getParameter("uid");
        Connection  conn;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
	
		
		conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletProject","root","A2016ece@4701");
		Statement st=conn.createStatement();
	//	System.out.println("Driver connected");
	ResultSet set=	st.executeQuery("select * from student");
	//System.out.println("__________________________");
	while(set.next()) {
		System.out.println("User id is"+set.getString(4));
		System.out.println("password is"+set.getString(5));
		if(set.getString(4).equals(uid1)) {
			wr.println("Success");
		}
		wr.println(set.getString(1)+"   "+set.getString(2)+"   "+set.getString(3)+"   "+set.getString(4)+"   "+set.getString(5));
	
		wr.println("<br>");
	
	}} catch(Exception ee) {
		ee.printStackTrace();
	}
	}}

