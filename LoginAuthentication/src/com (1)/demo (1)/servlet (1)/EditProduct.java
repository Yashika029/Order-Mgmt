package com.demo.servlet;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class EditProduct extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int pid=Integer.parseInt(request.getParameter("id"));
		LoginService pservice=new LoginServiceImpl();
		Product p=pservice.getById(pid);
		
		out.println("<form action='Update' method='post'>");
		out.println("product id: <input type='text' name='pid' id='pid'value='"+p.getPid()+"' readonly><br>");
		out.println("product name: <input type='text' name='pname'id='pname' value='"+p.getPname()+"'><br>");
		out.println("product qty: <input type='text' name='pqty' id='pqty' value='"+p.getPqty()+"'<br>");
		out.println("product price: <input type='text' name='price' id='price' value='"+p.getPrice()+"'<br>");
		out.println("product cid: <input type='text' name='cid' value='"+p.getCid()+"'<br>");
		out.println("<button type='submit' name='btn'id='btn' value='update'>update product</button>");
		out.println("</form>");
		
	}
	
	
	

	

}
