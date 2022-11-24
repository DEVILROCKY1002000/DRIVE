package com.bill.DesigningForm;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.bill.DataLayer.View;
import com.bill.DesignComponents.RoundButton;
import com.bill.DesignComponents.TableReport;
import com.bill.Model.FunctionMasterModel;

public class MasterView extends JFrame implements ActionListener,MouseListener,FocusListener,KeyListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 914079789052714569L;
	private JPanel entryPanel, mainPanel, headerPanel, btnpanel;
	private JButton btnAdd,btnSave,btnCancel,btnClear,btnBack;
	private JTextField txtSearch;
	private JLabel lblClose,lblInfo,lblSearch;
	List<FunctionMasterModel> lstFunctionMaster = new ArrayList<FunctionMasterModel>();
	List<String[]> lstRows1 = new ArrayList<String[]>();
	List<String[]> lstRows2 = new ArrayList<String[]>();
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	
	DecimalFormat amountFormat = new DecimalFormat("#0.00");
	TableReport tr;
	View view = new View();
	int totalamount=0;
	
	public MasterView() throws Exception {
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
			lstFunctionMaster = view.functionMaster();
			panel();
			masterDetails();
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
			headerPanel.setBackground(Color.decode("#2d85eb"));
			mainPanel.add(headerPanel);
			
			JLabel label = new JLabel("M A S T E R  V I E W", JLabel.CENTER);
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
			btnpanel.setBackground(Color.decode("#2d85eb"));
			mainPanel.add(btnpanel);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void reportTable() throws Exception {
		try {
			
			lblSearch = new JLabel("Mobile Number");
			lblSearch.setBounds(50, 10, 250, 30);
			lblSearch.setFont(new Font("Veranda", Font.BOLD, 14));
			lblSearch.setForeground(Color.BLACK);
			lblSearch.setVisible(true);
			lblSearch.setLayout(null);
			entryPanel.add(lblSearch);
			
			txtSearch = new JTextField();
			txtSearch.setBounds(350, 10, 250, 30);
			txtSearch.setFont(new Font("Veranda", Font.BOLD, 14));
			txtSearch.setForeground(Color.BLACK);
			txtSearch.setVisible(true);
			txtSearch.setLayout(null);
			txtSearch.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent e) {
					try {
						char c = e.getKeyChar();
						System.out.println(Character.isDigit(c));
						if((Character.isAlphabetic(c) == true || (c == KeyEvent.VK_BACK_SPACE) ||
								(c == KeyEvent.VK_ENTER) || txtSearch.getText().length()>9)) {
							e.consume();
						} else {
							tr.filter(txtSearch.getText().trim().toLowerCase());
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					super.keyPressed(e);
				}
			});
			entryPanel.add(txtSearch);
			
			String[] column = {
					"Function_Code","FunctionName","Head",
					"CoOrdinator","Area","City","MobileNo","MobileNo2",
					"StartDate","EndDate","MinPerson","MaxPerson","Active"
					};
			tr = new TableReport(entryPanel, "Report", column, lstRows1, 50, 50, 1250, 500);
			lblInfo = new JLabel("Record Count:		" + totalamount);
			lblInfo.setBounds(50, 550, 1250, 30);
			lblInfo.setFont(new Font("Veranda", Font.BOLD, 14));
			lblInfo.setForeground(Color.BLACK);
			lblInfo.setVisible(true);
			lblInfo.setLayout(null);
			entryPanel.add(lblInfo);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void masterDetails() throws Exception {
		
		try {
			
		    for (FunctionMasterModel model : lstFunctionMaster) {
		    	String[] data = {
		    			model.getFunction_Code(),model.getFunctionName(),
		    			model.getHead(),model.getCoOrdinator(),
		    			model.getArea(),model.getCity(),
		    			model.getMobileNo(),model.getCoOrdinateMobile(),
		    			model.getStartDate(),model.getEndDate(),
		    			String.valueOf(model.getMinPerson()),String.valueOf(model.getMaxPerson()),
		    			model.getActive()
		    	};
		    	totalamount += 1;
		    	lstRows1.add(data);
		    }
		    
		    String[] total = {
	    			""
	    			};
		    lstRows1.add(total);
		    
		    
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
				MasterMenu m = new MasterMenu();
				m.setVisible(true);
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
	
}
