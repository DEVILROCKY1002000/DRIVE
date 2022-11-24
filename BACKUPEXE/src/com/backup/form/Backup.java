package com.backup.form;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;

import com.backup.daoimpl.BackupDaoImpl;
import com.backup.start.ApplicationStart;

import javax.swing.JScrollPane;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JProgressBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Backup {

	private JFrame backupFrame;
	private BackupDaoImpl impl = new BackupDaoImpl();
	private List<String> lstdb = new ArrayList<String>();
	private List<String> selectedBox = new ArrayList<String>();
	private List<JCheckBox> checkBoxList = new ArrayList<JCheckBox>();
	private JButton btnExit,btnBackup;
	@SuppressWarnings("rawtypes")
	private JComboBox dbComboBox;
	private JTextField pathTextField;
	private JPanel infoPanel,checkBoxPanel;
	private JScrollPane jScrollPane;
	private JCheckBox dbCheckBox,checkBoxAll;
	private Box box;
	private JProgressBar dbProgressBar;
	ClassLoader cl = ApplicationStart.class.getClassLoader();
	ImageIcon icon = new ImageIcon(cl.getResource("data_replace.png"));
	
	/**
	 * Launch the application.
	 */
	public Backup() throws Exception {
		try {
			
			
			initialize();
			checkbox("");
			actions();
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked", "deprecation" })
	private void initialize() {
		backupFrame = new JFrame();
		backupFrame.setForeground(new Color(0, 255, 204));
		backupFrame.setTitle("BACKUP");
		backupFrame.getContentPane().setBackground(new Color(105, 105, 105));
		backupFrame.setBounds(100, 100, 502, 384);
		backupFrame.setResizable(false);
		backupFrame.setLocationRelativeTo(null);
		backupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		backupFrame.getContentPane().setLayout(null);
		backupFrame.setIconImage(icon.getImage());
		backupFrame.setVisible(true);
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(240, 248, 255));
		topPanel.setBounds(10, 11, 467, 32);
		backupFrame.getContentPane().add(topPanel);
		topPanel.setLayout(null);
		
		JLabel backupLabel = new JLabel("BACKUP");
		backupLabel.setBackground(new Color(173, 216, 230));
		backupLabel.setFont(new Font("Rockwell", Font.BOLD, 27));
		backupLabel.setHorizontalAlignment(SwingConstants.CENTER);
		backupLabel.setBounds(10, 0, 447, 32);
		topPanel.add(backupLabel);
		
		JPanel dataPanel = new JPanel();
		dataPanel.setBackground(new Color(240, 248, 255));
		dataPanel.setBounds(208, 54, 269, 200);
		backupFrame.getContentPane().add(dataPanel);
		dataPanel.setLayout(null);
		
		JLabel pathLabel = new JLabel("Backup Path");
		pathLabel.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
		pathLabel.setBounds(10, 50, 79, 20);
		dataPanel.add(pathLabel);
		
		pathTextField = new JTextField();
		pathTextField.setBounds(97, 50, 162, 20);
		dataPanel.add(pathTextField);
		pathTextField.setColumns(10);
		
		dbComboBox = new JComboBox();
		dbComboBox.setFont(new Font("Segoe UI Historic", Font.BOLD, 13));
		dbComboBox.setForeground(new Color(0, 0, 0));
		dbComboBox.setBackground(new Color(240, 248, 255));
		dbComboBox.setModel(new DefaultComboBoxModel(new String[] {"All Databases", "Sql Databases", "Company Databases"}));
		dbComboBox.setSelectedIndex(0);
		dbComboBox.setBounds(10, 11, 249, 20);
		dbComboBox.requestDefaultFocus();
		dataPanel.add(dbComboBox);
		
		checkBoxAll = new JCheckBox("Select All");
		checkBoxAll.setHorizontalAlignment(SwingConstants.LEFT);
		checkBoxAll.setBackground(new Color(240, 248, 255));
		checkBoxAll.setSelected(true);
		checkBoxAll.setBounds(10, 88, 249, 23);
		dataPanel.add(checkBoxAll);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(240, 248, 255));
		bottomPanel.setBounds(10, 306, 467, 32);
		backupFrame.getContentPane().add(bottomPanel);
		
		btnBackup = new JButton("BACKUP");
		btnBackup.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnBackup.setBackground(new Color(153, 255, 255));
		btnBackup.setBounds(75, 5, 110, 23);
		
		btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnExit.setBackground(new Color(153, 255, 255));
		btnExit.setName("exit");
		btnExit.setBounds(312, 5, 110, 23);
		bottomPanel.setLayout(null);
		bottomPanel.add(btnBackup);
		bottomPanel.add(btnExit);
		backupFrame.setVisible(true);
		
		infoPanel = new JPanel();
		infoPanel.setBackground(new Color(240, 248, 255));
		infoPanel.setBounds(10, 265, 467, 32);
		backupFrame.getContentPane().add(infoPanel);
		
		checkBoxPanel = new JPanel();
		checkBoxPanel.setBackground(new Color(240, 248, 255));
		checkBoxPanel.setBounds(10, 54, 190, 200);
		checkBoxPanel.removeAll();
		checkBoxPanel.updateUI();
		
		box = Box.createVerticalBox();
		box.setBounds(1, 1, 180, 200);
		box.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		box.setBackground(new Color(240, 248, 255));
		checkBoxPanel.add(box);
		
		jScrollPane = new JScrollPane(box);
		jScrollPane.setBounds(1, 1, 180, 200);
		jScrollPane.setPreferredSize(new Dimension(180,190));
		checkBoxPanel.add(jScrollPane);
		
		JPanel progressPanel = new JPanel();
		progressPanel.setBackground(new Color(169, 169, 169));
		progressPanel.setBounds(10, 118, 249, 71);
		dataPanel.add(progressPanel);
		progressPanel.setLayout(null);
		
		dbProgressBar = new JProgressBar();
		dbProgressBar.setFont(new Font("Tahoma", Font.BOLD, 16));
		dbProgressBar.setForeground(new Color(50, 205, 50));
		dbProgressBar.setBounds(10, 46, 233, 14);
		progressPanel.add(dbProgressBar);
		
		backupFrame.getContentPane().add(checkBoxPanel);
		
	}
	
	private ActionListener actions() throws Exception {
		try {
			
			dbComboBox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if(dbComboBox.getSelectedIndex() == 1) {
						try {
							checkbox("where dbid in (1,2,3,4)");
							checkBoxAll.setSelected(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(dbComboBox.getSelectedIndex() == 2) {
						try {
							checkbox("where dbid not in (1,2,3,4)");
							checkBoxAll.setSelected(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					} else if(dbComboBox.getSelectedIndex() == 0) {
						try {
							checkbox("");
							checkBoxAll.setSelected(true);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					
				}
			});
			
			dbComboBox.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(dbComboBox.isFocusable()) {
						if(e.getKeyCode() == KeyEvent.VK_ENTER) {
							pathTextField.requestFocus();
						}
					}
					
				}
			});
			
			pathTextField.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER){
						if(pathTextField.isFocusable()) {
							if(!pathTextField.getText().equalsIgnoreCase("")) {
								checkBoxAll.requestFocus();
							} else {
								pathTextField.requestFocus();
							}
						}
					}
				}
			});
			
			btnExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			btnExit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.exit(0);
					}
				}
			});
			
			checkBoxAll.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(checkBoxAll.isSelected()) {
						for(JCheckBox s: checkBoxList) {
							s.setSelected(true);
						}
					} else {
						for(JCheckBox s: checkBoxList) {
							s.setSelected(false);
						}
					}
				}
			});
			
			checkBoxAll.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						if(checkBoxAll.isFocusable()) {
							btnBackup.requestFocus();
						}
					}
				}
			});
			
			btnBackup.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					if(btnBackup.isFocusable()) {
						try {
							if(!pathTextField.getText().equalsIgnoreCase("")) {
								if(progress() == true) {
									JOptionPane.showMessageDialog(null, "Backup Completed");
//								} else {
//									JOptionPane.showMessageDialog(null, "Error..!");
								}
							} else {
								pathTextField.requestFocus();
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, e1.getMessage());
							e1.printStackTrace();
							System.exit(0);
						}
					}
				}
			});
		} catch (Exception e) {
			throw e;
		}
		return dbComboBox;
	}
	
	private void checkbox(String str) throws Exception {
		try {
			
			lstdb = new ArrayList<String>();
			lstdb = impl.database(str);
			box.removeAll();
			box.updateUI();
			if(lstdb != null) {
				for(String s:lstdb) {
					dbCheckBox = new JCheckBox(s);
					dbCheckBox.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
					dbCheckBox.setSelected(true);
					box.add(dbCheckBox);
					checkBoxList.add(dbCheckBox);
					
				}
			}
			
			backupFrame.getContentPane().add(checkBoxPanel);
			
			int s = lstdb.size();
			JLabel ltotal = new JLabel("No. of Databases:" + s);
			ltotal.setFont(new Font("Rockwell", Font.BOLD, 14));
			ltotal.setHorizontalAlignment(SwingConstants.CENTER);
			ltotal.setBounds(192, 5, 120, 21);
			ltotal.setVisible(true);
			infoPanel.removeAll();
			infoPanel.updateUI();
			infoPanel.add(ltotal);
		} catch (Exception e) {
			throw e;
		}
	}
	
	private boolean progress() throws Exception {
		try {
			
			for(int i = 0; i <= 100 ; i++) {
				dbProgressBar.setValue(i);
				dbProgressBar.setStringPainted(true);
			}
			
			if(!pathTextField.getText().equalsIgnoreCase("")) {
				impl.backup(databases(), pathTextField.getText());
			} else {
				pathTextField.requestFocus();
			}
			
			return false;
		} catch (Exception e) {
			throw e;
		}
	}
	
	private String databases() throws Exception {
		try {
			
			String st = "";
			
			for(JCheckBox s : checkBoxList ) {
				if(s.isSelected() == true) {
					selectedBox.add(s.getText());
				}
			}
			
			for(String s : selectedBox) {
				st = st.concat("'" + s + "',");
			}
			
			return st.substring(0, st.length()-1);
		} catch (Exception e) {
			throw e;
		}
	}
}
