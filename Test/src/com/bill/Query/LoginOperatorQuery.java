package com.bill.Query;

public class LoginOperatorQuery {
	
	private StringBuilder query;
	
	public String dataoperator() throws Exception {
		try {
			query = new StringBuilder();
//			query.append("if not exists (select name from sysobjects where name = 'Employee' and xtype = 'U')\r\n");
//			query.append("create table Employee(\r\n" + 
//					"EmpNo int unique,\r\n" + 
//					"EmpName nvarchar(100) not null,\r\n" + 
//					"EmpDoorNo nvarchar(100),\r\n" + 
//					"EmpAdd1 nvarchar(100),\r\n" + 
//					"EmpAdd2 nvarchar(100),\r\n" + 
//					"EmpAdd3 nvarchar(100),\r\n" + 
//					"EmpArea nvarchar(100),\r\n" + 
//					"EmpCity nvarchar(100),\r\n" + 
//					"EmpMobileNO nvarchar(10) unique,\r\n" + 
//					"EmpPhoneNo nvarchar(10),\r\n" + 
//					"EmpDOJ date,\r\n" + 
//					"EmpOper varchar(1) check(EmpOper = 'Y' or EmpOper = 'N') default 'Y',\r\n" + 
//					"EmpRefno int, \r\n" + 
//					"EmpActive varchar(1) check(EmpActive = 'Y' or EmpActive = 'N') default 'Y', \r\n" +
//					"EmpPass varchar(16) not null\r\n" +
//					")");
//			query.append("insert into Employee values(isnull((select max(EmpNo) from Employee),0)+1,'Administrator','','','','','Kovilpatti','Thoothukudi','9999999999','',GETDATE(),'Y','Administrator',1,'Y', '123')\r\n");
//			query.append("end\r\n");
			query.append("select * from employee where EmpActive = 'Y' and EmpOper = 'Y'");
			
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
