package com.bill.Query;

public class ViewQuery {
	
	private StringBuilder query;
	
	public String dataoperator() throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select * from employee where EmpActive = 'Y' and EmpOper = 'Y'");
			
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String functionMaster() throws Exception {
		try {
			query = new StringBuilder();
			query.append("select * from FunctionMaster where Active = 'Y'");
			
			System.out.println("--FUNCTION MASTER VIEW:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String report(Object fromDate, Object toDate) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select SUM(amount) as Amount,f.FunctionName,c.customerid,c.mobilenumber,c.CustomerName,c.area,c.City,p.CreatedDate from Customer as c\r\n" + 
					"inner join Payment as p on p.customerid = c.customerid\r\n" + 
					"inner join FunctionMaster as f on f.Function_Code = c.FCode\r\n" +
					"where p.createddate between '" + fromDate + "' and '" + toDate + "'\r\n" +
					"group by f.FunctionName,c.customerid,c.mobilenumber,c.CustomerName,c.area,c.City,p.CreatedDate,p.Createtime\r\n" +
					"order by p.CreatedDate,p.Createtime");
			
			System.out.println(query);
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String collectionReport(Object fromDate, Object toDate) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select SUM(Amount) as Amount,ModeofPay from Payment as P \r\n" +
					"where p.createddate between '" + fromDate + "' and '" + toDate + "'\r\n" +
					"group by ModeofPay");
			
			System.out.println(query);
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String customerDetails(String CustomerID) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query = new StringBuilder();
			query.append("");
			query.append("select SUM(amount) as Amount,c.customerid,mobilenumber,CustomerName,area,City from Customer as c\r\n" + 
					"inner join Payment as p on p.customerid = c.customerid\r\n" + 
					"where p.customerid in ('" + CustomerID + "')" +
					"group by c.customerid,mobilenumber,CustomerName,area,City\r\n");
			
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
