package com.bill.Query;

public class MaxTranIDQuery {
	
	private StringBuilder query;
	
	public String CustomerID() throws Exception {
		try {
			query = new StringBuilder();
			query.append("select 'CTR' + convert(nvarchar,\r\n" + 
					"(select COUNT(*) + 1 from Customer where CustomerID in (\r\n" + 
					"select distinct CustomerId from Customer)\r\n" + 
					")) as customerID\r\n");
			
			System.out.println("--CUSTOMER ID:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String function_code() throws Exception {
		try {
			query = new StringBuilder();
			query.append("select 'FCN' + convert(nvarchar,\r\n" + 
					"(select COUNT(*) + 1 from FunctionMaster where function_code in (\r\n" + 
					"select distinct function_code from FunctionMaster)\r\n" + 
					")) as function_code\r\n");
			
			System.out.println("--FUNCTION CODE:\r\n" + query + "\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
