package com.bill.DataLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bill.Connection.DbConnection;
import com.bill.Model.CollectionReportModel;
import com.bill.Model.FunctionMasterModel;
import com.bill.Model.ReportModel;
import com.bill.Query.ViewQuery;

public class View {
	
	Connection connection;
	private ViewQuery query = new ViewQuery();
	
	StringBuilder sb = new StringBuilder();
	List<ReportModel> lstReport;
	List<CollectionReportModel> lstCollectionReport;
	List<FunctionMasterModel> lstFunctionMaster;
	
	public List<ReportModel> report(Object fromDate, Object toDate) throws Exception {
		try {
			lstReport = new ArrayList<ReportModel>();
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.report(fromDate, toDate));
			
			while (set.next()) {
				ReportModel model = new ReportModel(
						set.getDouble("Amount"),
						set.getString("customerID"),
						set.getString("mobilenumber"),
						set.getString("customerName"),
						set.getString("Area"),
						set.getString("City"),
						set.getString("FunctionName"));
				model.setBillDate(set.getDate("createdDate"));
				lstReport.add(model);
				
			}
			
			return lstReport;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
	public List<CollectionReportModel> collectionReport(Object fromDate, Object toDate) throws Exception {
		try {
			lstCollectionReport = new ArrayList<CollectionReportModel>();
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.collectionReport(fromDate, toDate));
			
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
	
	public List<FunctionMasterModel> functionMaster() throws Exception {
		try {
			lstFunctionMaster = new ArrayList<FunctionMasterModel>();
			connection = DbConnection.transconn;
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(query.functionMaster());
			
			while (set.next()) {
				FunctionMasterModel model = new FunctionMasterModel(
						set.getString("Function_code"),
						set.getString("FunctionName"),
						set.getString("Head"),
						set.getString("CoOrdinator"),
						set.getString("Area"),
						set.getString("City"),
						set.getString("MobileNo"),
						set.getString("CoOrdinateMobile"),
						set.getString("StartDate"),
						set.getString("EndDate"),
						set.getInt("MinPerson"),
						set.getInt("MaxPerson"),
						set.getString("Active")
						);
				lstFunctionMaster.add(model);
				
			}
			
			return lstFunctionMaster;
		} catch (Exception e) {
			e.printStackTrace();
			connection.rollback();
			throw e;
		}
		
	}
	
}
