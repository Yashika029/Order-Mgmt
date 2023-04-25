package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao
{
	static Connection con;
	static PreparedStatement plogin, psel,pins,pdel,pselbyId,pupdate,pselByCateg;
	static
	{
		con=DbUtil.getMyConnection();
		try {
			plogin=con.prepareStatement("select * from User where uname=? and password=?");
			psel=con.prepareStatement("select * from productss");
			pins=con.prepareStatement("insert into productss values(?,?,?,?,?)");
			pdel=con.prepareStatement("delete from  productss where pid=?");
			pselbyId=con.prepareStatement("select * from productss where pid=?");
			pupdate=con.prepareStatement("update productss set pid=?,pname=?,pqty=?,price=?,cid=? where pid=?");
			pselByCateg=con.prepareStatement("select * from productss where cid=?");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public User ValidateUser(String usernm, String pass)
	{
		try
		{
		
			plogin.setString(1,usernm);
			plogin.setString(2, pass);
			ResultSet rs=plogin.executeQuery();
			while(rs.next())
			{
				System.out.println("in rs");
				User u=new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				if(u!=null) {
					return u;
				}
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
	


	@Override
	public void saveProduct(Product product)
	{
		
		 try 
		 {
			 pins.setInt(1,product.getPid());
			 pins.setString(2,product.getPname());
			 pins.setInt(3,product.getPqty());
			 pins.setFloat(4,product.getPrice());
			 pins.setInt(5,product.getCid());
			 pins.executeUpdate();
		}
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}
			 
	}

	

	@Override
	public List<Product> findAllProduct()
	{
		List<Product> plist=new ArrayList<>();
		 try {
			ResultSet rs=psel.executeQuery();
			while(rs.next())
			{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getInt(5)));
			}
			
			if(plist.size()>0)
			{
				return plist;
			}
			
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
		 
		return null;
	}

	
	
	@Override
	public void removeProduct(int pid)
	{
		try
		{
			pdel.setInt(1,pid);
			pdel.executeUpdate();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
	}



	@Override
	public Product findbyId(int pid)
	{
		try
		{
			pselbyId.setInt(1, pid);
			ResultSet rs=pselbyId.executeQuery();
			if(rs.next())
			{
				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getFloat(4), rs.getInt(5));
			}
			
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public void modifybyId(Product p)
	{
		try {
			pupdate.setInt(1, p.getPid());
			pupdate.setString(2, p.getPname());
			pupdate.setInt(3,  p.getPqty());
			pupdate.setFloat(4,  p.getPrice());
			pupdate.setInt(5,  p.getCid());
			pupdate.setInt(6, p.getPid());
			pupdate.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	
	}



	@Override
	public List<Product> findByCategory(int cid)
	{

		try {
			List<Product> plist=new ArrayList<>();
			pselByCateg.setInt(1,cid);
			ResultSet rs=pselByCateg.executeQuery();
			while(rs.next())
			{
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getFloat(4),rs.getInt(5)));
				
			}
			
			if(plist.size()>0)
			{
				return plist;
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		
		return null;
	}
	}


