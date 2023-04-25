package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.User;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class Login extends HttpServlet
{
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		String usernm=req.getParameter("uname");
		String pass=req.getParameter("passwd");
		LoginService ls=new LoginServiceImpl();
	
		
		User u=ls.ValidateUser(usernm,pass);
		if(u!=null)
		{
			if(u.getRole().equals("Admin"))
			{
				RequestDispatcher rd=req.getRequestDispatcher("Admin");
				rd.forward(req, res);
			}
			
			else
			{
				RequestDispatcher rd=req.getRequestDispatcher("UserServlet");
				rd.forward(req, res);
			}
			
		}
		else
		{
			out.println("invalid username");
			RequestDispatcher rd=req.getRequestDispatcher("index.html");
			rd.include(req, res);
			
		}
	
		
	}

}
