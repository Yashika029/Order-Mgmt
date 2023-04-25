package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService 
{
	private LoginDao ldao;
	
	public LoginServiceImpl()
	{
		ldao=new LoginDaoImpl();
	}

	@Override
	public User ValidateUser(String usernm, String pass)
	{
		
		return ldao.ValidateUser(usernm, pass) ;
	}
	
	
	@Override
	public void insertproduct(Product product)
	{
		ldao.saveProduct(product);
		
	}


	@Override
	public List<Product> getAllProduct()
	{
		return ldao.findAllProduct();
	}


	@Override
	public void deleteProduct(int pid)
	{
		ldao.removeProduct(pid);
		
	}

	
	@Override
	public Product getById(int pid) 
	{
		return ldao.findbyId(pid);
	}


	@Override
	public void updatebyId(Product p) 
	{
		 ldao.modifybyId(p);
	}

	@Override
	public List<Product> getbyCategory(int cid)
	{
		return ldao.findByCategory(cid);
	}


}
