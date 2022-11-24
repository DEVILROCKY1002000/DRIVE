package com.bill.Model;

import java.util.List;

public class CustomerModel {
	
	private String fnCode,cusID,cusName,cusFatherName,cusLastName,cusDoorNO,cusAdd1,cusAdd2,cusAdd3,cusArea,cusCity,cusMobNo,cusPhNo;
	private List<PaymentModel> lstPayment;
	private double amount;
	
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public CustomerModel(String fncode, String cusId,String cusName, String cusFatherName, String cusLastName, String cusDoorNO, String cusAdd1,
			String cusAdd2, String cusAdd3, String cusArea, String cusCity, String cusMobNo, String cusPhNo) {
		super();
		this.fnCode = fncode;
		this.cusID = cusId;
		this.cusName = cusName;
		this.cusFatherName = cusFatherName;
		this.cusLastName = cusLastName;
		this.cusDoorNO = cusDoorNO;
		this.cusAdd1 = cusAdd1;
		this.cusAdd2 = cusAdd2;
		this.cusAdd3 = cusAdd3;
		this.cusArea = cusArea;
		this.cusCity = cusCity;
		this.cusMobNo = cusMobNo;
		this.cusPhNo = cusPhNo;
	}
	
	public String getFnCode() {
		return fnCode;
	}

	public void setFnCode(String fnCode) {
		this.fnCode = fnCode;
	}

	public String getCusID() {
		return cusID;
	}

	public void setCusID(String cusID) {
		this.cusID = cusID;
	}

	public List<PaymentModel> getLstPayment() {
		return lstPayment;
	}

	public void setLstPayment(List<PaymentModel> lstPayment) {
		this.lstPayment = lstPayment;
	}
	
	public String getCusFatherName() {
		return cusFatherName;
	}

	public void setCusFatherName(String cusFatherName) {
		this.cusFatherName = cusFatherName;
	}

	public String getCusLastName() {
		return cusLastName;
	}

	public void setCusLastName(String cusLastName) {
		this.cusLastName = cusLastName;
	}

	public String getCusName() {
		return cusName;
	}

	public void setCusName(String CusName) {
		this.cusName = CusName;
	}

	public String getCusDoorNO() {
		return cusDoorNO;
	}

	public void setCusDoorNO(String CusDoorNO) {
		this.cusDoorNO = CusDoorNO;
	}

	public String getCusAdd1() {
		return cusAdd1;
	}

	public void setCusAdd1(String CusAdd1) {
		this.cusAdd1 = CusAdd1;
	}

	public String getCusAdd2() {
		return cusAdd2;
	}

	public void setCusAdd2(String CusAdd2) {
		this.cusAdd2 = CusAdd2;
	}

	public String getCusAdd3() {
		return cusAdd3;
	}

	public void setCusAdd3(String CusAdd3) {
		this.cusAdd3 = CusAdd3;
	}

	public String getCusArea() {
		return cusArea;
	}

	public void setCusArea(String CusArea) {
		this.cusArea = CusArea;
	}

	public String getCusCity() {
		return cusCity;
	}

	public void setCusCity(String CusCity) {
		this.cusCity = CusCity;
	}

	public String getCusMobNo() {
		return cusMobNo;
	}

	public void setCusMobNo(String CusMobNo) {
		this.cusMobNo = CusMobNo;
	}

	public String getCusPhNo() {
		return cusPhNo;
	}

	public void setCusPhNo(String CusPhNo) {
		this.cusPhNo = CusPhNo;
	}

}
