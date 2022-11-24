package com.backup.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.backup.dao.BackupDao;
import com.backup.form.SQLConnection;
import com.backup.query.BackupQuery;

public class BackupDaoImpl implements BackupDao{
	
	private Connection connection;
	private Statement statement;
	private ResultSet set;
	private BackupQuery query = new BackupQuery();
	private List<String> lstdatabases;
	
	@Override
	public List<String> database(String str) throws Exception {
		try {
			
			lstdatabases = new ArrayList<String>();
			connection = SQLConnection.mastercon;
			statement = connection.createStatement();
			set = statement.executeQuery(query.database(str));
			
			while(set.next()) {
				lstdatabases.add(set.getString("name"));
			}
			
			set.close();
			return lstdatabases;	
			
		} catch (Exception e) {
			 e.printStackTrace();
			 throw e;
		}
	}

	@Override
	public boolean backup(String database, String path) throws Exception {
		try {
			
			connection = SQLConnection.mastercon;
			statement = connection.createStatement();
			statement.execute(query.backupquery(database, path));
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
}
