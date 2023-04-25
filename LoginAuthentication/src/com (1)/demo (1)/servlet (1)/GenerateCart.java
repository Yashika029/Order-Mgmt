package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;


public class GenerateCart extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
//		response.setContentType("text/html");
//		PrintWriter out=response.getWriter();
		String[] arr=request.getParameterValues("prod");
		//new session object will be created
		HttpSession session =request.getSession();
		
		List<Product> plist=(List<Product>) session.getAttribute("cart");
		if(plist==null)
		{
			//we have come first time
			plist=new ArrayList<>();
		}
		for(String s: arr)
		{
			String sarr[]=s.split(":");
			//this will generate one product object
			Product p=new Product(Integer.parseInt(sarr[0]),sarr[1],Float.parseFloat(sarr[2]));
			plist.add(p);
		}
            session.setAttribute("cart", plist);
            //to again go to CategoryId.html page
            RequestDispatcher rd=request.getRequestDispatcher("CategoryId.html");
            rd.forward(request, response);	
		
	}

}
