package com.bill.Query;

import java.util.List;

import com.bill.Model.CustomerModel;
import com.bill.Model.FunctionMasterModel;
import com.bill.Model.PaymentModel;

public class SaveQuery {
	
	private StringBuilder query;
	
	public String CustomerSave(List<CustomerModel> lstCustomer) throws Exception {
		try {
			int size = 0;
			query = new StringBuilder();
			query.append("");
			query.append("if exists (select name from sysobjects where name = 'Customer' and xtype = 'U')\r\n");
			query.append("begin\r\n");
			query.append("insert into Customer values ");
			for(CustomerModel model : lstCustomer) {
				query.append("(\r\n" +
						"'" + model.getFnCode() + "'," + 
						"'" + model.getCusID() + "'," +
						"'" + model.getCusName() + "'," + 
						"'" + model.getCusFatherName() + "'," + 
						"'" + model.getCusLastName() + "'," + 
						"'" + model.getCusAdd1() + "'," + 
						"'" + model.getCusAdd2() + "'," +
						"'" + model.getCusArea() + "'," + 
						"'" + model.getCusCity() + "'," + 
						"'TAMIL NADU'," + 
						"'" + model.getCusMobNo() + "'," + 
						"'" + model.getCusPhNo() + "'," + 
						"getdate(),getdate())\r\n");
				size++;
				if(lstCustomer.size() != size) {
					query.append(",");
				}
			}
			query.append("\r\nend");
			
			System.out.println("--CUSTOMER SAVE:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String PaymentSave(List<CustomerModel> lstPayment) throws Exception {
		try {
			int size = 0;
			query = new StringBuilder();
			query.append("");
			query.append("if exists (select name from sysobjects where name = 'Payment' and xtype = 'U')\r\n");
			query.append("begin\r\n");
			query.append("insert into Payment values ");
			for(CustomerModel m : lstPayment) {
				for(PaymentModel model : m.getLstPayment()) {
					query.append("(\r\n" +
							"'" + model.getModeofPay() + "'," + 
							"'" + model.getAmount() + "'," +
							"'" + model.getCustomerID() + "'," + 
							"getdate(),getdate())\r\n");
					size++;
					if(m.getLstPayment().size() != size) {
						query.append(",");
					}
				}
			}
			
			query.append("\r\nend");
			
			System.out.println("--CUSTOMER SAVE:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String FnMasterSave(List<FunctionMasterModel> lstFnMaster) throws Exception {
		try {
			int size = 0;
			query = new StringBuilder();
			query.append("");
			query.append("if exists (select name from sysobjects where name = 'FunctionMaster' and xtype = 'U')\r\n");
			query.append("begin\r\n");
			query.append("insert into FunctionMaster values ");
			for(FunctionMasterModel model : lstFnMaster) {
				query.append("(\r\n"+
						"'"+  model.getFunction_Code() + "'," +
						"'" + model.getFunctionName() + "'," +
						"'" + model.getHead() + "'," + 
						"'" + model.getCoOrdinator() + "'," + 
						"'" + model.getArea() + "'," + 
						"'" + model.getCity() + "'," + 
						"'" + model.getMobileNo() + "'," +
						"'" + model.getCoOrdinateMobile() + "'," + 
						"'" + model.getStartDate() + "'," + 
						"'" + model.getEndDate() + "'," + 
						model.getMinPerson() + "," + 
						model.getMaxPerson() + "," + 
						"'" + model.getActive().substring(0,1) + "'" + 
						")\r\n");
				size++;
				if(lstFnMaster.size() != size) {
					query.append(",");
				}
			}
			query.append("\r\nend");
			
			System.out.println("--FUNCTION MASTER SAVE:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
