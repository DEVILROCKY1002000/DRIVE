package com.bill.Model;

public class CollectionReportModel {
	
	private double amount;
	private String ModeofPay;

	public CollectionReportModel(double amount, String modeofPay) {
		super();
		this.amount = amount;
		ModeofPay = modeofPay;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getModeofPay() {
		return ModeofPay;
	}

	public void setModeofPay(String modeofPay) {
		ModeofPay = modeofPay;
	}
	
	

}
