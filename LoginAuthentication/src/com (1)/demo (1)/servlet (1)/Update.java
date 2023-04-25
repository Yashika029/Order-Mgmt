package com.demo.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class Update extends HttpServlet
{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int pqty=Integer.parseInt(request.getParameter("pqty"));
		float price=Float.parseFloat(request.getParameter("price"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		Product p=new Product(pid,pname,pqty,price,cid);
		LoginService lservice=new LoginServiceImpl();
		lservice.updatebyId(p);
		RequestDispatcher rd=request.getRequestDispatcher("DisplayAllProduct");
		rd.forward(request,response);
	}

}
