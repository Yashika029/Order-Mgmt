package com.demo.beans;

public class User
{
	private String name,pass,role;
	private int id;
	
	public User() 
	{
		super();
	}

	public User(int id, String name, String pass, String role)
	{
		super();
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", pass=" + pass + ", role=" + role + ", id=" + id + "]";
	}
	
	
	
	
	

	
	

}
