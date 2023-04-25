package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginDao 
{

	User ValidateUser(String usernm, String pass);

	void saveProduct(Product product);

	List<Product> findAllProduct();

	void removeProduct(int pid);

	Product findbyId(int pid);

	void modifybyId(Product p);

	List<Product> findByCategory(int cid);
	

}
