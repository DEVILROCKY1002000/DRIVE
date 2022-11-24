package com.bill.DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bill.Connection.DbConnection;
import com.bill.Model.CollectionReportModel;
import com.bill.Model.ReportModel;
import com.bill.Query.PrintingQuery;

public class Print {
	
	Connection connection;
	private PrintingQuery query = new PrintingQuery();
	
	StringBuilder sb = new StringBuilder();
	List<ReportModel> lstReport;
	List<CollectionReportModel> lstCollectionReport;
	
	public List<ReportModel> customerDetails(String CustomerID) throws Exception {
		try {
			lstReport = new ArrayList<ReportModel>();
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.customerDetails(CustomerID));
			
			while (set.next()) {
				ReportModel model = new ReportModel(
						set.getDouble("Amount"),
						set.getString("customerID"),
						set.getString("mobilenumber"),
						set.getString("customerName"),
						set.getString("Area"),
						set.getString("City"),
						set.getString("FunctionName"));
				lstReport.add(model);
				
			}
			
			return lstReport;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
	public List<CollectionReportModel> customerCollection(String CustomerID) throws Exception {
		try {
			lstCollectionReport = new ArrayList<CollectionReportModel>();
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.customerCollection(CustomerID));
			
			while (set.next()) {
				CollectionReportModel model = new CollectionReportModel(
						set.getDouble("Amount"),
						set.getString("ModeofPay"));
				lstCollectionReport.add(model);
				
			}
			
			return lstCollectionReport;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}

}
