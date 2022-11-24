package com.bill.Model;

public class FunctionMasterModel {

	
	private String Function_Code,FunctionName,Head,CoOrdinator,Area,City,MobileNo,CoOrdinateMobile,Active;
	private String StartDate,EndDate;
	private int MinPerson,MaxPerson;
	
	
	public FunctionMasterModel(String function_Code, String functionName, String head, String coOrdinator, String area,
			String city, String mobileNo, String coOrdinateMobile, String startDate, String endDate,
			int minPerson, int maxPerson, String active) {
		super();
		Function_Code = function_Code;
		FunctionName = functionName;
		Head = head;
		CoOrdinator = coOrdinator;
		Area = area;
		City = city;
		MobileNo = mobileNo;
		CoOrdinateMobile = coOrdinateMobile;
		Active = active;
		StartDate = startDate;
		EndDate = endDate;
		MinPerson = minPerson;
		MaxPerson = maxPerson;
	}
	public String getFunction_Code() {
		return Function_Code;
	}
	public void setFunction_Code(String function_Code) {
		Function_Code = function_Code;
	}
	public String getFunctionName() {
		return FunctionName;
	}
	public void setFunctionName(String functionName) {
		FunctionName = functionName;
	}
	public String getHead() {
		return Head;
	}
	public void setHead(String head) {
		Head = head;
	}
	public String getCoOrdinator() {
		return CoOrdinator;
	}
	public void setCoOrdinator(String coOrdinator) {
		CoOrdinator = coOrdinator;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getCoOrdinateMobile() {
		return CoOrdinateMobile;
	}
	public void setCoOrdinateMobile(String coOrdinateMobile) {
		CoOrdinateMobile = coOrdinateMobile;
	}
	public String getActive() {
		return Active;
	}
	public void setActive(String active) {
		Active = active;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
	}
	public int getMinPerson() {
		return MinPerson;
	}
	public void setMinPerson(int minPerson) {
		MinPerson = minPerson;
	}
	public int getMaxPerson() {
		return MaxPerson;
	}
	public void setMaxPerson(int maxPerson) {
		MaxPerson = maxPerson;
	}
	
	
}
