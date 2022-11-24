package com.backup.query;

public class BackupQuery {
	
	private StringBuilder query;
	
	
	public String database(String str) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select * from sysdatabases " + str + " order by name");
			
			System.out.println(query);
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public String backupquery(String databases, String path) throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
//			query.append("use master \r\n"
//					+ "go \r\n"
//					+ "declare @compcode nvarchar(25),@count int,@database nvarchar(25),@path nvarchar(100)\r\n" + 
//					"set @compcode = '%" + "" +"%'\r\n" + 
//					"set @path = '''" + "" + "\\'\r\n" + 
//					"set @count = (select COUNT(name) from sysdatabases where LEN(name) > 3 and name like + @compcode)\r\n" + 
//					"select * into #tempdatabase from  sysdatabases where LEN(name) > 3 and name like + @compcode\r\n" + 
//					"while (@count > 0)\r\n" + 
//					"begin\r\n" + 
//					"	set @database = (select top(1) name from #tempdatabase)\r\n" + 
//					"	exec ('backup database '+@database+' to disk = '+ @path + @database +'.bak''')\r\n" + 
//					"	delete #tempdatabase where name = @database\r\n" + 
//					"	set @count = @count-1;\r\n" + 
//					"end\r\n" + 
//					"drop table #tempdatabase\r\n" + 
//					"");
			
//			query.append("select * from sysdatabases where name in (" + str + ")");
			query.append("Use master \r\n");
			query.append("declare @count int,@database nvarchar(25),@path nvarchar(1000) \r\n");
			query.append("set @path = '''" + path + "\\' \r\n"); 
			query.append("set @count = (select COUNT(name) from sysdatabases where name in (" + databases + ") and name not in ('tempdb')) \r\n");
			query.append("select * into #tempdatabase from  sysdatabases where name in (" + databases + ") and name not in ('tempdb') \r\n" + 
					"while (@count > 0) \r\n" + 
					"begin \r\n" + 
					"	set @database = (select top(1) name from #tempdatabase) \r\n" + 
					"	exec ('backup database '+@database+' to disk = '+ @path + @database +'.bak''') \r\n" + 
					"	delete #tempdatabase where name = @database \r\n" + 
					"	set @count = @count-1; \r\n" + 
					"end \r\n" + 
					"drop table #tempdatabase \r\n" + 
					"");
			
			System.out.println("\r\n\r\nBackup:\r\n"+query+"\r\n\r\n\r\n");
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
