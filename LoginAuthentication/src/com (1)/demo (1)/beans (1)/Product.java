package com.demo.beans;

public class Product
{
private int pid;
private String pname;
private int pqty;
private float price;
private int cid;


public Product() 
{
	super();
}


public Product(int pid, String pname, int pqty, float price, int cid) 
{
	super();
	this.pid = pid;
	this.pname = pname;
	this.pqty = pqty;
	this.price = price;
	this.cid = cid;
}


public Product(int pid, String pname, float price) 
{
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
}


public  int getPid() {
	return pid;
}


public void setPid(int pid) {
	this.pid = pid;
}


public String getPname() {
	return pname;
}


public void setPname(String pname) {
	this.pname = pname;
}


public int getPqty() {
	return pqty;
}


public void setPqty(int pqty) {
	this.pqty = pqty;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


public int getCid() {
	return cid;
}


public void setCid(int cid) {
	this.cid = cid;
}


@Override
public String toString()
{
	return "Product [pid=" + pid + ", pname=" + pname + ", pqty=" + pqty + ", price=" + price + ", cid=" + cid + "]";
}








}
