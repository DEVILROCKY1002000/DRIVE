package com.connection.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

import com.connection.DataColumns.DataColumns;

public class DBConnection {

	public static Connection masterConnection,transcConnection, schemeConnection;
	StringBuilder query = new StringBuilder();
	String CompanyId;
	String ServerName;
	String PortNo;
	String UserName;
	String PassWord;
	String IpAdd;
	
	public DBConnection(String CompanyId, String ServerName, String PortNo, String UserName, String PassWord, String IpAdd) {
		try {
			this.CompanyId = CompanyId;
			this.ServerName = ServerName;
			this.PortNo = PortNo;
			this.UserName = UserName;
			this.PassWord = PassWord;
			this.IpAdd = IpAdd;
			connection();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Connection Failed : " + e.getMessage());
		}
	}
	
	private boolean connection() throws Exception {
		try {
			DataColumns db = databaseConnection();
			masterConnection = setConnection(db.getMasterDb());
			transcConnection = setConnection(db.getMasterDb());
			schemeConnection = setConnection(db.getMasterDb());
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private DataColumns databaseConnection() throws Exception {
		try {
			
			Connection connection = setConnection(CompanyId + "CompyDB");
			DataColumns model = new DataColumns();
			model.setCompyDb(CompanyId + "CompyDB");
			Statement statement = connection.createStatement();
			ResultSet set = statement.executeQuery(databases());
						
			while(set.next()) {
				
				model.setCompName(set.getString("CompName"));
				model.setAdd1(set.getString("add1"));
				model.setAdd2(set.getString("add2"));
				model.setCity(set.getString("City"));
				model.setEmail(set.getString("EMAIL"));
				model.setPhone(set.getString("Phone"));
				model.setPincode(set.getString("Pincode"));
				model.setGstno(set.getString("GSTNo"));
				model.setMasterDb(set.getString("MasterDb"));
				model.setSchemeDb(set.getString("SchemeDb"));
				model.setStockDb(set.getString("StockDb"));
				model.setTranDb(set.getString("Trandb"));
				
			}
			set.close();
			connection.close();
			return model;
		} catch (Exception e) {			
			e.printStackTrace();
			throw e;
			
		}
	}
	
	private Connection setConnection(String dbname) throws Exception {
		try {
			String driverName = "net.sourceforge.jtds.jdbc.Driver";
			String connectionStr = "jdbc:jtds:sqlserver://"+ServerName+":"+PortNo+"/"+dbname;
			Class.forName(driverName).newInstance();
			
			return DriverManager.getConnection(connectionStr, UserName, PassWord);			
		} catch (Exception e) {			
			if(e.getMessage().equalsIgnoreCase("Cannot open database \"null\" requested by the login. The login failed.")) {
				JOptionPane.showMessageDialog(null, "Operator Login Failed..");
				System.exit(0);
				throw e;
			} else {
				e.printStackTrace();
				throw e;
			}
			
		}
	}	
	
	private String databases() throws Exception {
		try {
			query = new StringBuilder();
			query.append("");
			query.append("select f.AddressDB,f.CompId,f.MasterDb,f.SchemeDb,f.StockDB,f.TranDb,c.Add1,c.Add2,c.CompName");
			query.append("\n ,c.CompShtName,c.EMAIL,c.City,c.Phone,c.PinCode,isnull(ca.GSTNo,'') as GSTNo from " + CompanyId + "CompyDb.dbo.FILEMAIN as f");
			query.append("\n left join " + CompanyId + "CompyDb.dbo.Company as c on c.CompId = f.CompId");
			query.append("\n left join " + CompanyId + "CompyDb.dbo.Computer as cc on cc.CompCode = c.CompId and f.CompId=cc.CompCode");
			query.append("\n left join " + CompanyId + "CompyDb.dbo.CompanyAddlDetails as ca on ca.CompId = c.CompId and f.CompId=ca.CompId");
			query.append("\n where cc.IPAdd='" + IpAdd + "'");
			query.append("\n and cc.FinYearFromDate between f.FromDate and f.ToDate");
			
			return query.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
