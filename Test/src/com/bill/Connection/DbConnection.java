package com.bill.Connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.CodeSource;
import java.sql.Connection;
import java.sql.DriverManager;

import com.bill.Start.Appstart;

public class DbConnection {
	
	String servername,portno,username,password = "";
	public static Connection mastercon,transconn;
	
	public DbConnection() throws Exception {
		try {
			fileread();
			mastercon = connection("DEMM2223");
			transconn = connection("NEWDATA");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private Connection connection(String databasename) throws Exception {
		try {
			
			String drivername = "net.sourceforge.jtds.jdbc.Driver";
			String connectionstr = "jdbc:jtds:sqlserver://" + servername +":" + portno + "/" + databasename;
			Class.forName(drivername).newInstance();
			
			return DriverManager.getConnection(connectionstr, username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("resource")
	private void fileread() throws Exception {
		try {
			
			CodeSource source = Appstart.class.getProtectionDomain().getCodeSource();
			File file = new File(source.getLocation().getPath());
			FileReader filereader = new FileReader(file.getParent()+"/Server.jas");
			
			BufferedReader bfreader = new BufferedReader(filereader);
			String lines = "";
			int i = 1;
			while((lines = bfreader.readLine()) != null) {
				switch (i) {
				case 1:servername = lines; break;
				case 2:portno = lines; break;
				case 3:username = lines; break;
				case 4:password = lines; break;
				default:break;
				}
				i++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
