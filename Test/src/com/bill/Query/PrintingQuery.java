package com.bill.Query;

public class PrintingQuery {
	
	private StringBuilder query;
	
	
	public String customerDetails(String CustomerID) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query = new StringBuilder();
			query.append("");
			query.append("select SUM(amount) as Amount,f.FunctionName,c.customerid,c.mobilenumber,c.CustomerName,c.area,c.City from Customer as c\r\n" + 
					"inner join Payment as p on p.customerid = c.customerid\r\n" + 
					"inner join FunctionMaster as f on f.Function_Code = c.FCode\r\n" + 
					"where p.customerid in ('" + CustomerID + "')" +
					"group by f.FunctionName,c.customerid,c.mobilenumber,c.CustomerName,c.area,c.City\r\n");
			
			System.out.println(query);
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String customerCollection(String CustomerID) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select SUM(p.Amount) as Amount,ModeofPay from Payment as p where p.customerid in ('" + CustomerID + "') group by p.ModeofPay\r\n");
			
			System.out.println(query);
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
