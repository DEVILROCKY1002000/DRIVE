package com.bill.DesigningForm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.Border;

import com.bill.Common.Appcommon;
import com.bill.DataLayer.Print;
import com.bill.DesignComponents.RoundButton;
import com.bill.DesignComponents.TableReport;
import com.bill.Model.CollectionReportModel;
import com.bill.Model.PrintModel;
import com.bill.Model.ReportModel;
import com.bill.Printing.PrinterJobFile;

public class Report extends JFrame implements ActionListener,MouseListener,FocusListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 914079789052714569L;
	private JPanel entryPanel, mainPanel, headerPanel, btnpanel;
	private JButton btnAdd,btnSave,btnCancel,btnClear,btnBack;
	private JLabel lblClose;
	List<ReportModel> lstReport = new ArrayList<ReportModel>();
	List<CollectionReportModel> lstCollectionReport = new ArrayList<CollectionReportModel>();
	List<String[]> lstRows1 = new ArrayList<String[]>();
	List<String[]> lstRows2 = new ArrayList<String[]>();
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	
	DecimalFormat amountFormat = new DecimalFormat("#0.00");
	TableReport tr;
	
	public Report(PrintModel model) throws Exception {
		try {	
			setLayout(null);
			getContentPane().setPreferredSize(new Dimension(1500, 900));
			setBounds(0, 0, 1500, 900);
			setTitle("Master");
			setResizable(false);
			setLocationRelativeTo(null);
			setUndecorated(true);
			pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			lstReport = model.getReportModels();
			lstCollectionReport = model.getCollectionReportModels();
			panel();
			employeedetails();
			collection();
			reportTable();
			button();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void panel() throws Exception {
		try {
			
			mainPanel = new JPanel();
			mainPanel.setBounds(0, 0, 1370, 900);
			mainPanel.setVisible(true);
			mainPanel.setLayout(null);
			mainPanel.setBackground(Color.WHITE);
			getContentPane().add(mainPanel);
			
			headerPanel = new JPanel();
			headerPanel.setBounds(0, 0, 1370, 40);
			headerPanel.setVisible(true);
			headerPanel.setLayout(null);
			headerPanel.setBackground(Color.decode("#1be0a8"));
			mainPanel.add(headerPanel);
			
			JLabel label = new JLabel("R E P O R T", JLabel.CENTER);
			label.setBounds(550, 5, 300, 30);
			label.setFont(new Font("Arial black", Font.BOLD, 14));
			label.setForeground(Color.WHITE);
			label.setVisible(true);
			label.setLayout(null);
			headerPanel.add(label);
			
			lblClose = new JLabel(new ImageIcon(classLoader.getResource("close.png")));
			lblClose.setBounds(1325, 5, 30, 30);
			lblClose.setFont(new Font("Arial black", Font.BOLD, 14));
			lblClose.setForeground(Color.WHITE);
			lblClose.setVisible(true);
			lblClose.setLayout(null);
			lblClose.addMouseListener(this);
			headerPanel.add(lblClose);
			
			entryPanel = new JPanel();
			entryPanel.setBounds(10, 50, 1345, 625);
			Border line = BorderFactory.createLineBorder(Color.red, 2);
			entryPanel.setBorder(line);
			entryPanel.setVisible(true);
			entryPanel.setLayout(null);
			entryPanel.setBackground(Color.WHITE);
			mainPanel.add(entryPanel);
			
			btnpanel = new JPanel();
			btnpanel.setBounds(0, 700, 1370, 100);
			btnpanel.setVisible(true);
			btnpanel.setLayout(null);
			btnpanel.setBackground(Color.decode("#1be0a8"));
			mainPanel.add(btnpanel);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void reportTable() throws Exception {
		try {
			String[] column = {"Function Name",
					"CustomerID", "Amount", "CustomerName", "Mobile No", "Area", "City"
					};
			tr = new TableReport(entryPanel, "Report", column, lstRows1, 50, 100, 1250, 300);
			
			String[] column2 = {
					"Mode of Payment",
					"Amount"
					};
			tr = new TableReport(entryPanel, "Collection", column2, lstRows2, 50, 425, 330, 180);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void employeedetails() throws Exception {
		
		try {
			int totalamount=0;
		    for (ReportModel model : lstReport) {
		    	String[] data = {model.getFunctionName(),
		    			model.getCustomerid(),amountFormat.format(model.getAmount())
		    			,model.getCustomerName(),
		    			model.getMobilenumber(),model.getArea(),
		    			model.getCity()
		    			};
		    	totalamount += model.getAmount();
		    	lstRows1.add(data);
		    }
		    
		    String[] total = {
	    			"Total	",amountFormat.format(totalamount)
	    			};
		    lstRows1.add(total);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
    	
	}
	
	private void collection() throws Exception {
		try {
			int collection = 0;
			for (CollectionReportModel model : lstCollectionReport) {
		    	String[] data2 = {
		    			model.getModeofPay(),
		    			amountFormat.format(model.getAmount())	    			
		    			};
		    	collection += model.getAmount();
		    	lstRows2.add(data2);
		    }
			String[] colleciontTotal = {
	    			"Total	",amountFormat.format(collection)
	    	};
			lstRows2.add(colleciontTotal);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void button() throws Exception {
		try {
			Border line = new RoundButton(25);
			btnAdd = new JButton("A D D");
			btnAdd.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnAdd.setBounds(50, 10, 150, 50);
			btnAdd.setBackground(Color.white);
			btnAdd.setForeground(Color.black);
			btnAdd.setOpaque(false);
			btnAdd.setVisible(true);
			btnAdd.setBorder(line);
			btnAdd.addMouseListener(this);
			btnAdd.addFocusListener(this);
			btnAdd.addKeyListener(this);
			btnAdd.setContentAreaFilled(false);
			btnAdd.setMnemonic('A');
			btnpanel.add(btnAdd);
			
			btnSave = new JButton("S A V E");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnSave.setBounds(320, 10, 150, 50);
			btnSave.setBackground(Color.white);
			btnSave.setForeground(Color.black);
			btnSave.setOpaque(false);
			btnSave.setVisible(true);
			btnSave.setBorder(line);
			btnSave.setMnemonic('S');
			btnSave.addMouseListener(this);
			btnSave.addFocusListener(this);
			btnSave.addKeyListener(this);
			btnSave.setContentAreaFilled(false);
			btnpanel.add(btnSave);
			
			btnClear = new JButton("CLEAR");
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnClear.setBounds(570, 10, 150, 50);
			btnClear.setBackground(Color.white);
			btnClear.setForeground(Color.black);
			btnClear.setOpaque(false);
			btnClear.setVisible(true);
			btnClear.setBorder(line);
			btnClear.setMnemonic('C');
			btnClear.addMouseListener(this);
			btnClear.addFocusListener(this);
			btnClear.addKeyListener(this);
			btnClear.setContentAreaFilled(false);
			btnpanel.add(btnClear);
			
			btnCancel = new JButton("CANCEL");
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnCancel.setBounds(820, 10, 160, 50);
			btnCancel.setBackground(Color.white);
			btnCancel.setForeground(Color.black);
			btnCancel.setOpaque(false);
			btnCancel.setVisible(true);
			btnCancel.setBorder(line);
			btnCancel.setMnemonic('L');
			btnCancel.addMouseListener(this);
			btnCancel.addFocusListener(this);
			btnCancel.addKeyListener(this);
			btnCancel.setContentAreaFilled(false);
			btnpanel.add(btnCancel);
			
			btnBack = new JButton("B A C K");
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnBack.setBounds(1090, 10, 150, 50);
			btnBack.setBackground(Color.white);
			btnBack.setForeground(Color.black);
			btnBack.setOpaque(false);
			btnBack.setVisible(true);
			btnBack.setBorder(line);
			btnBack.setMnemonic('B');
			btnBack.addActionListener(this);
			btnBack.addMouseListener(this);
			btnBack.addFocusListener(this);
			btnBack.addKeyListener(this);
			btnBack.setContentAreaFilled(false);
			btnpanel.add(btnBack);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Component c = (Component) e.getSource();
			
			if(c.equals(btnBack) || c.equals(lblClose)) {
				setVisible(false);
				FilterData f = new FilterData("R E P O R T");
				f.setVisible(true);
			}
			
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd) || c.equals(btnBack)) {
			Border border = new RoundButton(5);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd) || c.equals(btnBack)) {
			Border border = new RoundButton(25);
			c.setForeground(Color.BLACK);
			c.setBorder(border);
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		Component c = (Component) e.getSource();
		if(e.getKeyCode() == KeyEvent.VK_LEFT && c.isFocusable()) {
			if(c.equals(btnBack) || c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave)) {
				c.transferFocusBackward();
			} else if(c.equals(btnAdd)) {
				btnBack.requestFocus();
			}
			
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT && c.isFocusable()) {
			if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd)) {
				c.transferFocus();
			} else if(c.equals(btnBack)) {
				btnAdd.requestFocus();
			}
		} else if(e.getSource().equals("Report") && e.getKeyCode() == KeyEvent.VK_P) {
			if(((JTable) e.getSource()).getSelectedRow() != 0 && ((JTable) e.getSource()).getRowCount() > -1) {
				int x = ((JTable) e.getSource()).getSelectedRow();
				try {
					print(x);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "Select any one and press the 'P' button then take a Duplicate Copy", "Duplicate Receipt", JOptionPane.ERROR_MESSAGE);
			}				
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void focusGained(FocusEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd) || c.equals(btnBack)) {
			Border border = new RoundButton(5);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd) || c.equals(btnBack)) {
			Border border = new RoundButton(25);
			c.setForeground(Color.black);
			c.setBorder(border);
		}
		
	}
	
	public void print(int x) throws Exception {
		try {
			x = tr.printData();
			Print print = new Print();
			PrintModel model = new PrintModel();
			Appcommon.customerID = lstReport.get(x).getCustomerid();
			model.setCollectionReportModels(print.customerCollection(Appcommon.customerID));
			model.setReportModels(print.customerDetails(Appcommon.customerID));
			new PrinterJobFile(216, 600, model);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
