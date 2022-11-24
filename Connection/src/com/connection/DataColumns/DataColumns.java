package com.connection.DataColumns;

public class DataColumns {
	
	private String compyDb, masterDb, tranDb, schemeDb, stockDb, addressDb, imageDb, compName,add1,add2,city,phone,pincode,email,gstno;

	public String getCompyDb() {
		return compyDb == null ? "Company Database Not found for this Company" : compyDb;
	}

	public void setCompyDb(String compyDb) {
		this.compyDb = compyDb;
	}

	public String getMasterDb() {
		return masterDb == null ? "Master Database Not found for this Company" : masterDb;
	}

	public void setMasterDb(String masterDb) {
		this.masterDb = masterDb;
	}

	public String getTranDb() {
		return tranDb == null ? "Transaction Database Not found for this Company" : tranDb;
	}

	public void setTranDb(String tranDb) {
		this.tranDb = tranDb;
	}

	public String getSchemeDb() {
		return schemeDb == null ? "Scheme Database Not found for this Company" : schemeDb;
	}

	public void setSchemeDb(String schemeDb) {
		this.schemeDb = schemeDb;
	}

	public String getStockDb() {
		return stockDb == null ? "Stock Database Not found for this Company" : stockDb;
	}

	public void setStockDb(String stockDb) {
		this.stockDb = stockDb;
	}

	public String getAddressDb() {
		return addressDb == null ? "Address Database Not found for this Company" : addressDb;
	}

	public void setAddressDb(String addressDb) {
		this.addressDb = addressDb;
	}

	public String getImageDb() {
		return imageDb;
	}

	public void setImageDb(String imageDb) {
		this.imageDb = imageDb;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getAdd1() {
		return add1;
	}

	public void setAdd1(String add1) {
		this.add1 = add1;
	}

	public String getAdd2() {
		return add2;
	}

	public void setAdd2(String add2) {
		this.add2 = add2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGstno() {
		return gstno;
	}

	public void setGstno(String gstno) {
		this.gstno = gstno;
	}
	
}
