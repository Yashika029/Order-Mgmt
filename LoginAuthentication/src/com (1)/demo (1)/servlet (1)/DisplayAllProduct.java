package com.demo.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class DisplayAllProduct extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		LoginService lservice=new LoginServiceImpl();
		List<Product> plist=lservice.getAllProduct();
		out.println("<a href='AddProduct'>Add Product</a>");
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>qty</th>");
		out.println("<th>price</th><th>cid</th><th>operations</th></tr>");
		for(Product p :plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPqty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='DeleteProduct?id="+p.getPid()+"'>delete</a> / <a href='Edit?id="+p.getPid()+"'>edit</a></td></tr>");
		}
		out.println("</table>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	

}
