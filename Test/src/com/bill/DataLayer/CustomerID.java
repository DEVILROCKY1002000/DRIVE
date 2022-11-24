package com.bill.DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.bill.Common.Appcommon;
import com.bill.Connection.DbConnection;
import com.bill.Query.MaxTranIDQuery;

public class CustomerID {

	Connection connection;
	private MaxTranIDQuery query = new MaxTranIDQuery();
	
	StringBuilder sb = new StringBuilder();
	
	public CustomerID() {
		try {
			CustomerId();
			FunctionCode();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public String CustomerId() throws Exception {
		try {
			
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.CustomerID());
			while(set.next()) {
				Appcommon.customerID = set.getString("customerID");
			}
			return Appcommon.customerID;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
	public String FunctionCode() throws Exception {
		try {
			
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.function_code());
			while(set.next()) {
				Appcommon.functionCode = set.getString("function_code");
			}
			return Appcommon.functionCode;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
}
