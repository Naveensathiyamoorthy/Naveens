package com.dbconn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class SigninValidate
 */
@WebServlet("/SigninValidate")
public class SigninValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SigninValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		int flag=0;
		PrintWriter writer=response.getWriter();
		String email=request.getParameter("user");
		String password=request.getParameter("pass");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "root");
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from signup");
			while(rs.next())
			{
				if(rs.getString("emailid").equals(email) && rs.getString("password").equals(password))
				{
					flag=1;
					writer.println("EmailId: "+rs.getString("emailId"));
					writer.println("FirstName: "+rs.getString("firstname"));
					writer.println("LastName: "+rs.getString("lastname"));
					writer.println("UserName: "+rs.getString("username"));
					writer.println("Password: "+rs.getString("password"));
				}
			}
			if(flag==0)
			{
				writer.println("Username or password is invalid");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
