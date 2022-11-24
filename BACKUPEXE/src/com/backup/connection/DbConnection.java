package com.backup.connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.CodeSource;

import com.backup.form.SQLConnection;
import com.backup.start.ApplicationStart;

public class DbConnection {
	
	public static String servername,portno,username,password = "";
	
	
	public DbConnection() throws Exception {
		try {
			
			fileread();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("resource")
	public static void fileread() throws Exception {
		try {
			
			CodeSource source = ApplicationStart.class.getProtectionDomain().getCodeSource();
			File file = new File(source.getLocation().getPath());
			File filecheck = new File(file.getParent() + "/Server.jas");
			if(!filecheck.exists()) {
				new SQLConnection();	
			} else {
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
				
				new SQLConnection();
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
