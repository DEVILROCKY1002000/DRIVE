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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import com.bill.DataLayer.View;
import com.bill.DesignComponents.RoundButton;
import com.bill.Model.PrintModel;

public class FilterData extends JFrame implements MouseListener,FocusListener,KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5787271183063637863L;
	private JPanel entryPanel, mainPanel, headerPanel, btnpanel;
	private JButton btnAdd,btnView,btnCancel,btnClear,btnExit;
	private JLabel lblClose,lblFromDate,lblToDate,lblDate,lblTime;
	private JSpinner fromDateSpinner, toDateSpinner;
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	private int x = 30, y = 30, width = 150, height = 50, dx = 200 , dy = 50, twidth = 350, theight = 35;
	private Font lblFont = new Font("Tahoma" , Font.BOLD, 16);
	View view = new View();
	SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	String headName;
	
	public FilterData(String str) throws Exception {
		try {
			this.headName = str;
			setLayout(null);
			getContentPane().setPreferredSize(new Dimension(1500, 900));
			setBounds(0, 0, 1500, 900);
			setTitle("Master");
			setResizable(false);
			setLocationRelativeTo(null);
			setUndecorated(true);
			pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			panel();
			filter();
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
			
			JLabel label = new JLabel(headName.toUpperCase(), JLabel.CENTER);
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
	
	private void filter() throws Exception {
		try {
			Border line = new EmptyBorder(1, 1, 1, 1);
			lblFromDate = new JLabel("From Date");
			lblFromDate.setBounds(x, y, width, height);
			lblFromDate.setVisible(true);
			lblFromDate.setLayout(null);
			lblFromDate.setFont(lblFont);
			entryPanel.add(lblFromDate);
			
			Date fromDate = new Date();
			SpinnerDateModel fromDateSM = new SpinnerDateModel(fromDate, null, null, Calendar.SHORT_FORMAT);
			fromDateSpinner = new JSpinner(fromDateSM);
			fromDateSpinner.setFont(new Font("Tahoma", Font.BOLD, 26));
			fromDateSpinner.setBounds(x+dx, y, twidth, theight);
			fromDateSpinner.setBackground(Color.white);
			fromDateSpinner.setForeground(Color.black);
			fromDateSpinner.setOpaque(false);
			fromDateSpinner.setVisible(true);
			fromDateSpinner.setBorder(line);
			entryPanel.add(fromDateSpinner);
			
			lblToDate = new JLabel("To Date");
			lblToDate.setBounds(x, y+(1*dy), width, height);
			lblToDate.setVisible(true);
			lblToDate.setLayout(null);
			lblToDate.setFont(lblFont);
			entryPanel.add(lblToDate);
			
			Date toDate = new Date();
			SpinnerDateModel toDateSM = new SpinnerDateModel(toDate, null, null, Calendar.SHORT_FORMAT);
			toDateSpinner = new JSpinner(toDateSM);
			toDateSpinner.setFont(new Font("Tahoma", Font.BOLD, 26));
			toDateSpinner.setBounds(x+dx, y+(1*dy), twidth, theight);
			toDateSpinner.setBackground(Color.white);
			toDateSpinner.setForeground(Color.black);
			toDateSpinner.setOpaque(false);
			toDateSpinner.setVisible(true);
			toDateSpinner.setBorder(line);
			entryPanel.add(toDateSpinner);
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
			
			btnView = new JButton("V I E W");
			btnView.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnView.setBounds(320, 10, 150, 50);
			btnView.setBackground(Color.white);
			btnView.setForeground(Color.black);
			btnView.setOpaque(false);
			btnView.setVisible(true);
			btnView.setBorder(line);
			btnView.setMnemonic('V');
			btnView.addMouseListener(this);
			btnView.addFocusListener(this);
			btnView.addKeyListener(this);
			btnView.setContentAreaFilled(false);
			btnpanel.add(btnView);
			
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
			
			btnExit = new JButton("E X I T");
			btnExit.setFont(new Font("Tahoma", Font.BOLD, 26));
			btnExit.setBounds(1090, 10, 150, 50);
			btnExit.setBackground(Color.white);
			btnExit.setForeground(Color.black);
			btnExit.setOpaque(false);
			btnExit.setVisible(true);
			btnExit.setBorder(line);
			btnExit.setMnemonic('X');
			btnExit.addMouseListener(this);
			btnExit.addFocusListener(this);
			btnExit.addKeyListener(this);
			btnExit.setContentAreaFilled(false);
			btnpanel.add(btnExit);
			
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
		Component c = (Component) e.getSource();
		if(e.getKeyCode() == KeyEvent.VK_LEFT && c.isFocusable()) {
			if(c.equals(btnExit) || c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView)) {
				c.transferFocusBackward();
			} else if(c.equals(btnAdd)) {
				btnExit.requestFocus();
			}
			
		} else if(e.getKeyCode() == KeyEvent.VK_RIGHT && c.isFocusable()) {
			if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView) || c.equals(btnAdd)) {
				c.transferFocus();
			} else if(c.equals(btnExit)) {
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
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView) || c.equals(btnAdd) || c.equals(btnExit)) {
			Border border = new RoundButton(5);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}
		
	}
	@Override
	public void focusLost(FocusEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView) || c.equals(btnAdd) || c.equals(btnExit)) {
			Border border = new RoundButton(25);
			c.setForeground(Color.black);
			c.setBorder(border);
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		try {
			Component c = (Component) e.getSource();
			
			if(c.equals(btnExit) || c.equals(lblClose)) {
				setVisible(false);
				if(headName.equals("R E P O R T")) {
					Homepage home = new Homepage();
					home.setVisible(true);
				}
				
			} else if (c.equals(toDateSpinner)) {
				if(toDateSpinner.getValue() == fromDateSpinner.getValue()) {
					fromDateSpinner.requestFocus();
				}
			} else if (c.equals(btnView)) {
				PrintModel model = new PrintModel();
				Object fromDate = dateformat.format(fromDateSpinner.getValue());
				Object toDate = dateformat.format(toDateSpinner.getValue());
				model.setCollectionReportModels(view.collectionReport(fromDate, toDate));
				model.setReportModels(view.report(fromDate, toDate));
				setVisible(false);
				fromDate = dateFormat.format(fromDateSpinner.getValue());
				toDate = dateFormat.format(toDateSpinner.getValue());
				if(headName.equals("R E P O R T")) {
					Report report = new Report(model);
					report.setVisible(true);
				}
				
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
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView) || c.equals(btnAdd) || c.equals(btnExit)) {
			Border border = new RoundButton(5);
			c.setForeground(Color.WHITE);
			c.setBorder(border);
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		JButton c = (JButton) e.getSource();
		if(c.equals(btnCancel) || c.equals(btnClear) || c.equals(btnView) || c.equals(btnAdd) || c.equals(btnExit)) {
			Border border = new RoundButton(25);
			c.setForeground(Color.BLACK);
			c.setBorder(border);
		}
	}
	
	
}
