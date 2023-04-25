package com.demo.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class DeleteProduct extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("id"));	
		LoginService lservice=new LoginServiceImpl();
		lservice.deleteProduct(pid);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayAllProduct");
		rd.forward(request, response);
		
		  
		}

}
