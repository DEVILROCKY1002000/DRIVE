package com.backup.start;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import com.backup.connection.DbConnection;

public class ApplicationStart {

	public static void main(String[] args) {
		
		try {
			
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			UIManager.put("MenuBar.font", new FontUIResource(new Font("Lato", Font.PLAIN, 13)));
			UIManager.put("Menu.font", new FontUIResource(new Font("Lato", Font.PLAIN, 13)));
			UIManager.put("MenuItem.font", new FontUIResource(new Font("Lato", Font.PLAIN, 13)));
			UIManager.put("Label.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("TextField.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("TextField.font", Color.blue);
			UIManager.put("RadioButton.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("ComboBox.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("Spinner.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("JTable.font", new FontUIResource(new Font("Lato", Font.PLAIN, 14)));
			UIManager.put("Button.defaultButtonFollowsFocus", Boolean.TRUE);
			
			new DbConnection();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
	}

}
