package com.bill.Start;

import javax.swing.UIManager;

import com.bill.Connection.DbConnection;
import com.bill.DesigningForm.Login;

public class Appstart {

	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
			new DbConnection();
			
			Login login= new Login();
			login.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		

	}

}
