package com.bill.Model;

import java.sql.Date;

public class ReportModel {

	private double Amount;
	private String customerid,mobilenumber,CustomerName,area,City,functionName;
	private Date billDate;
	public ReportModel(double amount, String customerid, String mobilenumber, String customerName, String area,
			String city,String functionName) {
		super();
		this.functionName =functionName;
		this.Amount = amount;
		this.customerid = customerid;
		this.mobilenumber = mobilenumber;
		this.CustomerName = customerName;
		this.area = area;
		this.City = city;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	
	
	
}
