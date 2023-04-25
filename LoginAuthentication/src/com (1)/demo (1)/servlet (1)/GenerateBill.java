package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;


public class GenerateBill extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<Product> plist=(List<Product>) session.getAttribute("cart");
		if(plist!=null)
		{
			float amount=0;
			out.println("<form action='finalizeorder'>");
			out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>Price</th></tr>");
			for(Product p:plist)
			{
				out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPrice()+"</td></tr>");
				amount=amount+p.getPrice();
			}
			out.println("<tr><td colspan='2'> Total Bill</td><td>"+amount+"</td></tr>");
			out.println("</table>");
			out.println("<button type='submit' name='btn' id='btn'>Pay the Bill</button>");
			out.println("</form>");
		}
	}

}
