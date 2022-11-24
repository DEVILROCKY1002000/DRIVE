package com.backup.connection;

import java.io.File;
import java.io.FileWriter;
import java.security.CodeSource;

import javax.swing.JOptionPane;

import com.backup.start.ApplicationStart;

public class ServerDetails {
	
	CodeSource source = ApplicationStart.class.getProtectionDomain().getCodeSource();
	File file = new File(source.getLocation().getPath());
	File filecheck = new File(file.getParent() + "/Server.jas");
	String servername,portno,username,password;
	
	public ServerDetails(String servername, String portno, String username, String password) {
		this.servername = servername;
		this.portno = portno;
		this.username = username;
		this.password = password;
		try {
			check();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void check() throws Exception {
		try {
			CodeSource source = ApplicationStart.class.getProtectionDomain().getCodeSource();
			File file = new File(source.getLocation().getPath());
			File filecheck = new File(file.getParent() + "/Server.jas");
			
			if(!filecheck.exists()) {
				filewrite();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void filewrite() throws Exception {
		try {
			String nl = "\r\n";
			CodeSource source = ApplicationStart.class.getProtectionDomain().getCodeSource();
			File file = new File(source.getLocation().getPath());
			File filecheck = new File(file.getParent() + "/Server.jas");
			if(!filecheck.exists()) {
				FileWriter fw = new FileWriter(file.getParent()+"/Server.jas");
				fw.write(servername+ nl);
				fw.write(portno + nl);
				fw.write(username + nl);
				fw.write((password == null || password.trim().equalsIgnoreCase("")) ? "" : password + nl);
				fw.close();
				JOptionPane.showMessageDialog(null, "Connection success", "CONNECTION", JOptionPane.INFORMATION_MESSAGE);
				check();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
