package com.bill.DataLayer;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

import com.bill.Connection.DbConnection;
import com.bill.Model.CustomerModel;
import com.bill.Model.FunctionMasterModel;
import com.bill.Query.SaveQuery;

public class Save {
	
	Connection connection;
	private SaveQuery query = new SaveQuery();
	
	StringBuilder sb = new StringBuilder();
	
	public boolean CustomerSave(List<CustomerModel> lstCustomer) throws Exception {
		try {
			
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			boolean set = statement.execute(query.CustomerSave(lstCustomer));
			
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
	public boolean PaymentSave(List<CustomerModel> lstPayment) throws Exception {
		try {
			
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			boolean set = statement.execute(query.PaymentSave(lstPayment));
			
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
	public boolean FnMasterSave(List<FunctionMasterModel> lstFnMaster) throws Exception {
		try {
			
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			boolean set = statement.execute(query.FnMasterSave(lstFnMaster));
			
			return set;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
}
