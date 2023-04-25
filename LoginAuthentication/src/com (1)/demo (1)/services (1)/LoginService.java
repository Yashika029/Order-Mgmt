package com.demo.services;

import java.util.List;

import com.demo.beans.Product;
import com.demo.beans.User;

public interface LoginService {

	User ValidateUser(String usernm, String pass);

	void insertproduct(Product product);

	List<Product> getAllProduct();

	void deleteProduct(int pid);

	Product getById(int pid);

	void updatebyId(Product p);

	List<Product> getbyCategory(int cid);

}
