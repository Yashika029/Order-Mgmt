package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.services.LoginService;
import com.demo.services.LoginServiceImpl;


public class ProductDetails extends HttpServlet 
{
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String btn=request.getParameter("btn");
		if(btn.equals("find"))
		{
		int cid=Integer.parseInt(request.getParameter("cid"));
		LoginService pservices=new LoginServiceImpl();
		List<Product> plist=pservices.getbyCategory(cid);
		out.println("<form action='generatecart' method='get'>");
		int cnt=1;
		for(Product p:plist)
		{
			String str=p.getPid()+":"+p.getPname()+":"+p.getPrice();
			out.println("<input type='checkbox' name='prod' id='p"+cnt+"'value='"+str+"'><label for='p"+cnt+"'>"+p.getPname()+"-----"+p.getPrice()+"<lable><br>");
			cnt++;
		}
		
		out.println("<button type='submit' name='btn' id='btn'>Add to cart</button>");
		out.print("</form>");
		
	}
	
	else if (btn.equals("payment"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("generatebill");
		rd.forward(request, response);
	}

}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
	
		doGet(request, response);
	}
}
	
