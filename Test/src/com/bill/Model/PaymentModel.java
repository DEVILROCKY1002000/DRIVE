package com.bill.Model;

import java.sql.Date;
import java.sql.Time;

public class PaymentModel {

	String ModeofPay,CustomerId;
	double Amount;
	Date CreatedDate;
	Time Createtime;
	
	public PaymentModel(String modeofPay, String customerID, double amount) {
		super();
		ModeofPay = modeofPay;
		CustomerId = customerID;
		Amount = amount;
	}
	
	public String getModeofPay() {
		return ModeofPay;
	}
	public void setModeofPay(String modeofPay) {
		ModeofPay = modeofPay;
	}
	public String getCustomerID() {
		return CustomerId;
	}
	public void setCustomerId(String customerID) {
		CustomerId = customerID;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public Date getCreatedDate() {
		return CreatedDate;
	}
	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}
	public Time getCreatetime() {
		return Createtime;
	}
	public void setCreatetime(Time createtime) {
		Createtime = createtime;
	}
	
}
