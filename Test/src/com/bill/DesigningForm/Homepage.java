package com.bill.DesigningForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.CodeSource;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import com.bill.Common.Appcommon;
import com.bill.DesignComponents.RoundButton;
import com.bill.Start.Appstart;


public class Homepage extends JFrame implements MouseListener {
	private static final long serialVersionUID = 1L;
	private JPanel titlePanel;
	
	@SuppressWarnings("unused")
	private JLabel lblTitle,lblmasterlogo,lblogout,lblbillinglogo,lblreportlogo;
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	
	@SuppressWarnings("unused")
	private int x = 10, y = 50, width = 300, height = 250, dx = 350 , dy = 45, twidth = 350, theight = 35;
	public Homepage() throws Exception {
		try {

			setLayout(null);
			getContentPane().setPreferredSize(new Dimension(1500,1500));
			setBounds(0, 0, 1500, 1500);
			setTitle("HomePage");
			setBackground(Color.black);
			setResizable(false);
			setLocationRelativeTo(null);
			setUndecorated(true);
			pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			panel();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void panel() throws Exception {
		try {
			Border line = new RoundButton(2);
			titlePanel = new JPanel();
			titlePanel.setBounds(0, 0, 1500, 0);
			titlePanel.setVisible(true);
			titlePanel.setLayout(null);
			titlePanel.setBackground(Color.BLUE);
			getContentPane().add(titlePanel);
			
			lblmasterlogo = new JLabel(new ImageIcon(classLoader.getResource("master.png")));
//			lblmasterlogo.setBounds(10, 50, 300, 250);
			lblmasterlogo.setBounds(x, y, width, height);
			lblmasterlogo.setVisible(true);
			lblmasterlogo.addMouseListener(this);
			lblmasterlogo.setBackground(Color.WHITE);
			lblmasterlogo.setOpaque(true);
			lblmasterlogo.setBorder(line);
			getContentPane().add(lblmasterlogo);
			
			lblbillinglogo = new JLabel(new ImageIcon(classLoader.getResource("billing.png")));
//			lblbillinglogo.setBounds(350, 50, 300, 250);
			lblbillinglogo.setBounds(x+(1*dx), y, width, height);
			lblbillinglogo.setVisible(true);
			lblbillinglogo.setBackground(Color.WHITE);
			lblbillinglogo.setOpaque(true);
			lblbillinglogo.setBorder(line);
			lblbillinglogo.addMouseListener(this);
			getContentPane().add(lblbillinglogo);
			
			lblreportlogo = new JLabel(new ImageIcon(classLoader.getResource("report.png")));
//			lblreportlogo.setBounds(650, 50, 300, 250);
			lblreportlogo.setBounds(x+(2*dx), y, width, height);
			lblreportlogo.setVisible(true);
			lblreportlogo.addMouseListener(this);
			lblreportlogo.setBorder(line);
			lblreportlogo.setBackground(Color.WHITE);
			lblreportlogo.setOpaque(true);
			getContentPane().add(lblreportlogo);
			
			lblogout = new JLabel(new ImageIcon(classLoader.getResource("exit.png")));
//			lblogout.setBounds(1050, 50, 300, 250);
			lblogout.setBounds(x+(3*dx), y, width, height);
			lblogout.addMouseListener(this);
			lblogout.setBorder(line);
			lblogout.setVisible(true);
			lblogout.setBackground(Color.WHITE);
			lblogout.setOpaque(true);
			getContentPane().add(lblogout);
	    	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void mouseClicked(MouseEvent e) {
		try {
			Object o = e.getSource();
			
			if(o.equals(lblmasterlogo)) {
				setVisible(false);
				MasterMenu m = new MasterMenu();
				m.setVisible(true);
			} else if(o.equals(lblbillinglogo)) { 
				setVisible(false);
				System.out.println(Appcommon.billing);
				String path = "cmd /c " +Appcommon.billing;
				Runtime rn = Runtime.getRuntime();
				rn.exec(path);
			} else if(o.equals(lblreportlogo)) {
				setVisible(false);
				FilterData f = new FilterData("R E P O R T");
				f.setVisible(true);
			} else if(o.equals(lblogout)) {
				setVisible(false);
				Login login = new Login();
				login.setVisible(true);
			}
		} catch (Exception e2) {
			e2.getStackTrace();
		}
		
	}

	public void mousePressed(MouseEvent e) {
		
		
	}

	public void mouseReleased(MouseEvent e) {
		
		
	}

	public void mouseEntered(MouseEvent e) {
		
		
	}

	public void mouseExited(MouseEvent e) {
		
		
	}
}


