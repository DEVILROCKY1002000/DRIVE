package com.bill.DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bill.Connection.DbConnection;
import com.bill.Model.LoginOperatorModel;
import com.bill.Query.LoginOperatorQuery;


public class LoginOperatorDataLayer {
	
	private Connection connection;
	private Statement statement;
	private ResultSet set;
	private LoginOperatorQuery query = new LoginOperatorQuery();
	
	private List<LoginOperatorModel> lstOperator = new ArrayList<LoginOperatorModel>();
	
	public List<LoginOperatorModel> loginoperator() throws Exception {
		try {
			connection = DbConnection.mastercon;
			statement = connection.createStatement();
			set = statement.executeQuery(query.dataoperator());
			
			while(set.next()) {
				LoginOperatorModel model = new LoginOperatorModel();
				model.setEmpNo(set.getInt("EmpNo"));
				model.setEmpName(set.getString("EmpName"));
				model.setEmpPassWord(set.getString("EmpPass"));
				lstOperator.add(model);
			}
			
			set.close();
			return lstOperator;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
