package com.backup.dao;

import java.util.List;

public interface BackupDao {
	
	public List<String> database(String str) throws Exception;
	
	public boolean backup(String database, String path) throws Exception;

}
