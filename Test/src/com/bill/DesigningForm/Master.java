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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.Timer;
import javax.swing.border.Border;

import com.bill.Common.Appcommon;
import com.bill.DataLayer.CustomerID;
import com.bill.DataLayer.Save;
import com.bill.DesignComponents.RoundButton;
import com.bill.DesignComponents.YesOrNo;
import com.bill.Model.FunctionMasterModel;

public class Master extends JFrame implements MouseListener, KeyListener, FocusListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8151189173421195869L;
	public static final long serailversionuid=1L;
	private JPanel entryPanel, mainPanel, headerPanel, btnPanel;
	private JLabel lblClose,lblFnCode,lblFnName,lblFnHeadName,lblStartDate,lblFnEndDate,lblCoOrdinator,
	lblArea,lblCity,lblMobno,lblCoMob,lblMinPerson,lblMaxPerson,lblActive,lblDate,lblTime;
	private JTextField txtFnCode,txtFnName,txtFnHeadName,txtCoName,txtArea,
	txtCity,txtMobNo,txtCoMob,txtMinPerson,txtMaxPerson;
	private JButton btnAdd,btnSave,btnCancel,btnClear,btnExit;
	private JSpinner fromDateSpinner, toDateSpinner;
	private int x = 70, y = 30, width = 200, height = 50, dx = 350 , dy = 45, twidth = 300, theight = 35;
	private Font lblFont = new Font("Tahoma" , Font.BOLD, 16);
	private List<Component> listField = new ArrayList<Component>();
	private List<JTextField> checkField = new ArrayList<JTextField>();
	Save save = new Save();
	CustomerID code = new CustomerID();
	SimpleDateFormat date = new SimpleDateFormat("dd-MM-yyyy");
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	private ButtonGroup btnActive;
	private YesOrNo yn = new YesOrNo();
	private List<FunctionMasterModel> lstFnMaster = new ArrayList<FunctionMasterModel>();
	
	public Master() throws Exception {
		try {
			setLayout(null);
			getContentPane().setPreferredSize(new Dimension(1500, 900));
			setBounds(0, 0, 1500, 900);
			setTitle("FunctionMaster");
			setResizable(false);
			setLocationRelativeTo(null);
			setUndecorated(true);
			pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			panel();
			field();
			button();
			listFields();
			actions();
			fldValidation();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

 	public void panel() throws Exception {
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
			
			JLabel label = new JLabel("FUNCTION MASTER", JLabel.CENTER);
			label.setBounds(550, 5, 300, 30);
			label.setFont(new Font("Arial black", Font.BOLD, 14));
			label.setForeground(Color.WHITE);
			label.setVisible(true);
			label.setLayout(null);
			headerPanel.add(label);
			
			lblDate = new JLabel();
			lblDate.setBounds(300, 5, 300, 30);
			lblDate.setFont(new Font("Arial black", Font.BOLD, 14));
			lblDate.setForeground(Color.WHITE);
			lblDate.setVisible(true);
			lblDate.setLayout(null);
			headerPanel.add(lblDate);
			showdate();
			
			lblTime = new JLabel();
			lblTime.setBounds(980, 5, 300, 30);
			lblTime.setFont(new Font("Arial black", Font.BOLD, 14));
			lblTime.setForeground(Color.WHITE);
			lblTime.setVisible(true);
			lblTime.setLayout(null);
			headerPanel.add(lblTime);
			showtime();
			
			lblClose = new JLabel(new ImageIcon(classLoader.getResource("close.png")));
			lblClose.setBounds(1325, 5, 30, 30);
			lblClose.setFont(new Font("Arial black", Font.BOLD, 14));
			lblClose.setForeground(Color.WHITE);
			lblClose.setVisible(true);
			lblClose.setLayout(null);
			lblClose.addMouseListener(this);
			headerPanel.add(lblClose);
			
			entryPanel = new JPanel();
			entryPanel.setBounds(300, 50, 800, 625);
			Border line = BorderFactory.createLineBorder(Color.red, 2);
			entryPanel.setBorder(line);
			entryPanel.setVisible(true);
			entryPanel.setLayout(null);
			entryPanel.setBackground(Color.WHITE);
			mainPanel.add(entryPanel);
			
			btnPanel = new JPanel();
			btnPanel.setBounds(0, 700, 1370, 100);
			btnPanel.setVisible(true);
			btnPanel.setLayout(null);
			btnPanel.setBackground(Color.decode("#2d85eb"));
			mainPanel.add(btnPanel);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
 	private void showtime() {
		
		new Timer(0, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Date d = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
				lblTime.setText(sdf.format(d));
			}
		}).start();
		
	}

	private void showdate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		lblDate.setText(sdf.format(d));
	}
 	
	private void field() throws Exception {
		try {
			
			lblFnCode = new JLabel("Function Code *");
			lblFnCode.setBounds(x, y, width, height);
			lblFnCode.setVisible(true);
			lblFnCode.setLayout(null);
			lblFnCode.setFont(lblFont);
			entryPanel.add(lblFnCode);
			
			txtFnCode = new JTextField();
			txtFnCode.setName("Function Code");
			txtFnCode.setBounds(x+dx, y, twidth, theight);
			txtFnCode.setVisible(true);
			txtFnCode.setLayout(null);
			txtFnCode.setFont(lblFont);
			txtFnCode.setEditable(false);
			txtFnCode.setText(Appcommon.functionCode);
			entryPanel.add(txtFnCode);
			
			lblFnName = new JLabel("Function Name");
			lblFnName.setBounds(x, y+(1*dy), width, height);
			lblFnName.setVisible(true);
			lblFnName.setLayout(null);
			lblFnName.setFont(lblFont);
			entryPanel.add(lblFnName);
			
			txtFnName = new JTextField();
			txtFnName.setBounds(x+dx, y+(1*dy), twidth, theight);
			txtFnName.setName("Function Name");
			txtFnName.setVisible(true);
			txtFnName.setLayout(null);
			txtFnName.setFont(lblFont);
			entryPanel.add(txtFnName);
			
			lblFnHeadName = new JLabel("Function Head Name");
			lblFnHeadName.setBounds(x, y+(2*dy), width, height);
			lblFnHeadName.setVisible(true);
			lblFnHeadName.setLayout(null);
			lblFnHeadName.setFont(lblFont);
			entryPanel.add(lblFnHeadName);
			
			txtFnHeadName = new JTextField();
			txtFnHeadName.setName("Function Head Name");
			txtFnHeadName.setBounds(x+dx, y+(2*dy), twidth, theight);
			txtFnHeadName.setVisible(true);
			txtFnHeadName.setLayout(null);
			txtFnHeadName.setFont(lblFont);
			entryPanel.add(txtFnHeadName);
			
			lblStartDate = new JLabel("Start Date");
			lblStartDate.setBounds(x, y+(3*dy), width, height);
			lblStartDate.setVisible(true);
			lblStartDate.setFont(lblFont);
			lblStartDate.setLayout(null);
			entryPanel.add(lblStartDate);
			
			Date fromDate = new Date();
			SpinnerDateModel fromDateSM = new SpinnerDateModel(fromDate, null, null, Calendar.ALL_STYLES);
			fromDateSpinner = new JSpinner(fromDateSM);
			fromDateSpinner.setFont(new Font("Tahoma", Font.BOLD, 26));
			fromDateSpinner.setBounds(x+dx, y+(3*dy), twidth, theight);
			fromDateSpinner.setBackground(Color.white);
			fromDateSpinner.setForeground(Color.black);
			fromDateSpinner.setOpaque(false);
			fromDateSpinner.setVisible(true);
			entryPanel.add(fromDateSpinner);
			
			lblFnEndDate = new JLabel("End Date");
			lblFnEndDate.setBounds(x, y+(4*dy), width, height);
			lblFnEndDate.setVisible(true);
			lblFnEndDate.setLayout(null);
			lblFnEndDate.setFont(lblFont);
			entryPanel.add(lblFnEndDate);
			
			Date toDate = new Date();
			SpinnerDateModel toDateSM = new SpinnerDateModel(toDate, null, null, Calendar.SHORT_FORMAT);
			toDateSpinner = new JSpinner(toDateSM);
			toDateSpinner.setFont(new Font("Tahoma", Font.BOLD, 26));
			toDateSpinner.setBounds(x+dx, y+(4*dy), twidth, theight);
			toDateSpinner.setBackground(Color.white);
			toDateSpinner.setForeground(Color.black);
			toDateSpinner.setOpaque(false);
			toDateSpinner.setVisible(true);
			entryPanel.add(toDateSpinner);
			
			lblCoOrdinator = new JLabel("Co-Ordinator Name");
			lblCoOrdinator.setBounds(x, y+(5*dy), width, height);
			lblCoOrdinator.setVisible(true);
			lblCoOrdinator.setFont(lblFont);
			lblCoOrdinator.setLayout(null);
			entryPanel.add(lblCoOrdinator);
			
			txtCoName = new JTextField();
			txtCoName.setBounds(x+dx, y+(5*dy), twidth, theight);
			txtCoName.setName("Co-Ordinator Name");
			txtCoName.setVisible(true);
			txtCoName.setLayout(null);
			txtCoName.setFont(lblFont);
			entryPanel.add(txtCoName);
			
			lblArea = new JLabel("Area");
			lblArea.setBounds(x, y+(6*dy), width, height);
			lblArea.setVisible(true);
			lblArea.setFont(lblFont);
			lblArea.setLayout(null);
			entryPanel.add(lblArea);
			
			txtArea = new JTextField();
			txtArea.setBounds(x+dx, y+(6*dy), twidth, theight);
			txtArea.setName("Area");
			txtArea.setVisible(true);
			txtArea.setLayout(null);
			txtArea.setFont(lblFont);
			entryPanel.add(txtArea);
			
			lblCity = new JLabel("City");
			lblCity.setBounds(x, y+(7*dy), width, height);
			lblCity.setVisible(true);
			lblCity.setFont(lblFont);
			lblCity.setLayout(null);
			entryPanel.add(lblCity);

			txtCity = new JTextField();
			txtCity.setBounds(x+dx, y+(7*dy), twidth, theight);
			txtCity.setName("City");
			txtCity.setVisible(true);
			txtCity.setLayout(null);
			txtCity.setFont(lblFont);
			entryPanel.add(txtCity);
			
			lblMobno = new JLabel("Mobile No");
			lblMobno.setBounds(x, y+(8*dy), width, height);
			lblMobno.setVisible(true);
			lblMobno.setFont(lblFont);
			lblMobno.setLayout(null);
			entryPanel.add(lblMobno);
			
			txtMobNo = new JTextField();
			txtMobNo.setBounds(x+dx, y+(8*dy), twidth, theight);
			txtMobNo.setName("Mobile No");
			txtMobNo.setVisible(true);
			txtMobNo.setLayout(null);
			txtMobNo.setFont(lblFont);
			entryPanel.add(txtMobNo);
			
			lblCoMob = new JLabel("Co-Ordinator Mobile No");
			lblCoMob.setBounds(x, y+(9*dy), width, height);
			lblCoMob.setVisible(true);
			lblCoMob.setFont(lblFont);
			lblCoMob.setLayout(null);
			entryPanel.add(lblCoMob);
			
			txtCoMob = new JTextField();
			txtCoMob.setBounds(x+dx, y+(9*dy), twidth, theight);
			txtCoMob.setName("Co-Ordinator Mobile No");
			txtCoMob.setVisible(true);
			txtCoMob.setLayout(null);
			txtCoMob.setFont(lblFont);
			entryPanel.add(txtCoMob);
			
			lblMinPerson = new JLabel("Min-Person");
			lblMinPerson.setBounds(x, y+(10*dy), width, height);
			lblMinPerson.setVisible(true);
			lblMinPerson.setFont(lblFont);
			lblMinPerson.setLayout(null);
			entryPanel.add(lblMinPerson);
			
			txtMinPerson = new JTextField();
			txtMinPerson.setBounds(x+dx, y+(10*dy), twidth, theight);
			txtMinPerson.setName("Minimum Person");
			txtMinPerson.setVisible(true);
			txtMinPerson.setLayout(null);
			txtMinPerson.setFont(lblFont);
			entryPanel.add(txtMinPerson);
			
			lblMaxPerson = new JLabel("Max-Person");
			lblMaxPerson.setBounds(x, y+(11*dy), width, height);
			lblMaxPerson.setVisible(true);
			lblMaxPerson.setFont(lblFont);
			lblMaxPerson.setLayout(null);
			entryPanel.add(lblMaxPerson);
			
			txtMaxPerson = new JTextField();
			txtMaxPerson.setBounds(x+dx, y+(11*dy), twidth, theight);
			txtMaxPerson.setName("Max-Person");
			txtMaxPerson.setVisible(true);
			txtMaxPerson.setLayout(null);
			txtMaxPerson.setFont(lblFont);
			entryPanel.add(txtMaxPerson);
			
			lblActive = new JLabel("Active");
			lblActive.setBounds(x, y+(12*dy), width, height);
			lblActive.setVisible(true);
			lblActive.setFont(lblFont);
			lblActive.setLayout(null);
			entryPanel.add(lblActive);
			
			btnActive = yn.btngrp(btnActive, entryPanel, x+(dx), y+(12*dy));
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
			btnAdd.setForeground(Color.WHITE);
			btnAdd.setOpaque(false);
			btnAdd.setVisible(true);
			btnAdd.setBorder(line);
			btnAdd.addMouseListener(this);
			btnAdd.addFocusListener(this);
			btnAdd.addKeyListener(this);
			btnAdd.setContentAreaFilled(false);
			btnAdd.setMnemonic('A');
			btnPanel.add(btnAdd);
			
			btnSave = new JButton("S A V E");
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnSave.setBounds(320, 10, 150, 50);
			btnSave.setForeground(Color.WHITE);
			btnSave.setOpaque(false);
			btnSave.setVisible(true);
			btnSave.setBorder(line);
			btnSave.setMnemonic('S');
			btnSave.addMouseListener(this);
			btnSave.addFocusListener(this);
			btnSave.addKeyListener(this);
			btnSave.setContentAreaFilled(false);
			btnPanel.add(btnSave);
			
			btnClear = new JButton("CLEAR");
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnClear.setBounds(570, 10, 150, 50);
			btnClear.setForeground(Color.WHITE);
			btnClear.setOpaque(false);
			btnClear.setVisible(true);
			btnClear.setBorder(line);
			btnClear.setMnemonic('C');
			btnClear.addMouseListener(this);
			btnClear.addFocusListener(this);
			btnClear.addKeyListener(this);
			btnClear.setContentAreaFilled(false);
			btnPanel.add(btnClear);
			
			btnCancel = new JButton("CANCEL");
			btnCancel.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnCancel.setBounds(820, 10, 160, 50);
			btnCancel.setForeground(Color.WHITE);
			btnCancel.setOpaque(false);
			btnCancel.setVisible(true);
			btnCancel.setBorder(line);
			btnCancel.setMnemonic('L');
			btnCancel.addMouseListener(this);
			btnCancel.addFocusListener(this);
			btnCancel.addKeyListener(this);
			btnCancel.setContentAreaFilled(false);
			btnPanel.add(btnCancel);
			
			btnExit = new JButton("E X I T");
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnExit.setBounds(1090, 10, 150, 50);
			btnExit.setForeground(Color.WHITE);
			btnExit.setOpaque(false);
			btnExit.setVisible(true);
			btnExit.setBorder(line);
			btnExit.setMnemonic('X');
			btnExit.addMouseListener(this);
			btnExit.addFocusListener(this);
			btnExit.addKeyListener(this);
			btnExit.setContentAreaFilled(false);
			btnPanel.add(btnExit);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private String bn(ButtonGroup btngrp) throws Exception {
		try {
			String st = "";
			Enumeration<AbstractButton> absBtn = btngrp.getElements();
			while (absBtn.hasMoreElements()) {
				JRadioButton abstractButton = (JRadioButton) absBtn.nextElement();
				if(abstractButton.isSelected()) {
					st = abstractButton.getText();
				}
			}
			return st;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void listFields() throws Exception{
		try {
			listField.add(txtFnCode);
			listField.add(txtFnName);
			listField.add(txtFnHeadName);
			listField.add(txtCoName);
			listField.add(txtArea);
			listField.add(txtCity);
			listField.add(txtMobNo);
			listField.add(txtCoMob);
			listField.add(txtMinPerson);
			listField.add(txtMaxPerson);
			checkField.add(txtFnCode);
			checkField.add(txtArea);
			checkField.add(txtCity);
			checkField.add(txtMobNo);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
	}
	
	private void actions() {
		try {
			txtFnCode.addKeyListener(this);
			txtFnName.addKeyListener(this);
			txtFnHeadName.addKeyListener(this);
			txtCoName.addKeyListener(this);
			fromDateSpinner.addKeyListener(this);
			toDateSpinner.addKeyListener(this);
			txtArea.addKeyListener(this);
			txtCity.addKeyListener(this);
			txtMinPerson.addKeyListener(this);
			txtMobNo.addKeyListener(this);
			txtCoMob.addKeyListener(this);
			
		} catch (Exception e) {
			
		}
	}
	
	private void c(Component c) throws Exception {
		try {
			int fieldIndex = listField.indexOf(c);
			int checkIndex = checkField.indexOf(c);
			String value = listField.get(fieldIndex).getName();
			
			if(fieldIndex != listField.size() - 1) {
				if(value.equals("ModeOfPay")) {
				} else if(checkIndex > -1 && listField.get(fieldIndex).equals(checkField.get(checkIndex))) {
					if(listField.get(fieldIndex).isFocusable() && ((JTextField) listField.get(fieldIndex)).getText().trim().isEmpty()) {
						JOptionPane.showMessageDialog(null, value + " should not be Empty.!", value.toUpperCase(),JOptionPane.ERROR_MESSAGE);
						listField.get(fieldIndex).requestFocus();
					} else {
						listField.get(fieldIndex + 1).requestFocus();
					}
				} else {
					listField.get(fieldIndex + 1).requestFocus();
				}
			} else {
				
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private boolean checksave() throws Exception {
		try {
			boolean bln = false;
			for(JTextField f : checkField) {
				if(f.getText() != null && !f.getText().trim().isEmpty()) {
					bln = true;
				} else {
					bln = false;
					break;
				}
			}
			
			return bln;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void clearandcancel() throws Exception {
		try {
			txtFnCode.setText(Appcommon.functionCode);
			txtFnName.setText("");
			txtFnHeadName.setText("");
			txtCoName.setText("");
			txtArea.setText("");
			txtCity.setText("");
			txtMobNo.setText("");
			txtCoMob.setText("");
			txtMaxPerson.setText("");
			txtMinPerson.setText("");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
	private void addclear() throws Exception {
		try {
			FunctionMasterModel fn = new FunctionMasterModel(
					Appcommon.functionCode, txtFnName.getText(),
					txtFnHeadName.getText(), txtCoName.getText(), 
					txtArea.getText(), txtCity.getText(), 
					txtMobNo.getText(), txtCoMob.getText(), 
					date.format(fromDateSpinner.getValue()), 
					date.format(toDateSpinner.getValue()), Integer.parseInt(txtMinPerson.getText()), 
					Integer.parseInt(txtMaxPerson.getText()), bn(btnActive));
			
			lstFnMaster.add(fn);
			txtFnCode.setText("");
			txtFnName.setText("");
			txtFnHeadName.setText("");
			txtCoName.setText("");
			txtArea.setText("");
			txtCity.setText("");
			txtMobNo.setText("");
			txtCoMob.setText("");
			txtMaxPerson.setText("");
			txtMinPerson.setText("");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void fldValidation() throws Exception {
		try {
			
			txtMobNo.addKeyListener(new KeyAdapter() { 
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					System.out.println(Character.isDigit(c));
					if((Character.isAlphabetic(c) == true || (c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_ENTER) || txtMobNo.getText().length()>9)) {
						e.consume();
					}
					
					super.keyPressed(e);
				}
				
			});
			
			txtCoMob.addKeyListener(new KeyAdapter() { 
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					System.out.println(Character.isDigit(c));
					if((Character.isAlphabetic(c) == true || (c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_ENTER) || txtCoMob.getText().length()>9)) {
						e.consume();
					}
					
					super.keyPressed(e);
				}
				
			});
			
			txtMinPerson.addKeyListener(new KeyAdapter() { 
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					System.out.println(Character.isDigit(c));
					if((Character.isAlphabetic(c) == true || (c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_ENTER))) {
						e.consume();
					}
					
					super.keyPressed(e);
				}
				
			});
			
			txtMaxPerson.addKeyListener(new KeyAdapter() { 
				
				@Override
				public void keyTyped(KeyEvent e) {
					
					char c = e.getKeyChar();
					System.out.println(Character.isDigit(c));
					if((Character.isAlphabetic(c) == true || (c == KeyEvent.VK_BACK_SPACE) ||
							(c == KeyEvent.VK_ENTER))) {
						e.consume();
					}
					
					super.keyPressed(e);
				}
				
			});
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		try {
			Component c = (Component) e.getSource();
			if(e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(c.equals(btnExit)) {
					this.setVisible(false);
					MasterMenu hm = new MasterMenu();
					hm.setVisible(true);
				} else if(c.equals(btnCancel)) {
					clearandcancel();
				} else if(c.equals(btnClear)) {
					clearandcancel();
				} else if(c.equals(btnSave)) {
					try {
						addclear();
						boolean bln = save.FnMasterSave(lstFnMaster);
						if(bln == true) {
							JOptionPane.showMessageDialog(null, "Function Master Creation Failed...", "FUNCTION MASTER", JOptionPane.ERROR_MESSAGE);
							txtFnName.requestFocus();
						} else {								
							JOptionPane.showMessageDialog(null, "Function Master Saved Successfully...", "FUNCTION MASTER", JOptionPane.PLAIN_MESSAGE);
							clearandcancel();
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				} else if(c.equals(btnAdd)) {
					
				} else {
					c(c);
				}
			} else if(e.getKeyCode() == KeyEvent.VK_LEFT && c.isFocusable()) {
				if(c.equals(btnExit) || c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave)) {
					c.transferFocusBackward();
				} else if(c.equals(btnAdd)) {
					btnExit.requestFocus();
				}
				
			} else if(e.getKeyCode() == KeyEvent.VK_RIGHT && c.isFocusable()) {
				if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd)) {
					c.transferFocus();
				} else if(c.equals(btnExit)) {
					btnAdd.requestFocus();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Component c = (Component) e.getSource();
			if(c.equals(btnExit)) {
				this.setVisible(false);
				MasterMenu hm = new MasterMenu();
				hm.setVisible(true);
			} else if(c.equals(btnCancel)) {
				clearandcancel();
			} else if(c.equals(btnClear)) {
				clearandcancel();
			} else if(c.equals(btnSave)) {
				try {
					addclear();
					boolean bln = save.FnMasterSave(lstFnMaster);
					if(bln == true) {
						JOptionPane.showMessageDialog(null, "Function Master Creation Failed...", "FUNCTION MASTER", JOptionPane.ERROR_MESSAGE);
						txtFnName.requestFocus();
					} else {								
						JOptionPane.showMessageDialog(null, "Function Master Saved Successfully...", "FUNCTION MASTER", JOptionPane.PLAIN_MESSAGE);
						clearandcancel();
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			} else if(c.equals(btnAdd)) {
				
			}
		} catch (Exception e1) {
			e1.printStackTrace();
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
		Border border = new RoundButton(5);
		JButton c = (JButton) e.getSource();
		c.setForeground(Color.WHITE);
		c.setBorder(border);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		Border border = new RoundButton(25);
		JButton c = (JButton) e.getSource();
		c.setForeground(Color.WHITE);
		c.setBorder(border);
	}
	@Override
	public void focusGained(FocusEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnExit) || c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd)) {
			Border border = new RoundButton(5);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}		
	}
	@Override
	public void focusLost(FocusEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnExit) || c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnSave) || c.equals(btnAdd)) {
			Border border = new RoundButton(25);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}
		
	}
	
}
