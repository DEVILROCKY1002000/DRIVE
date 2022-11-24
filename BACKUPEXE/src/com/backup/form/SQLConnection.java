package com.backup.form;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.backup.connection.DbConnection;
import com.backup.connection.ServerDetails;
import com.backup.start.ApplicationStart;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;

public class SQLConnection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3409880109694758712L;
	private JPanel panel_1, panel_2;
	private JTextField fldServerName;
	private JTextField fldPort;
	private JTextField fldUsername;
	private JPasswordField fldPass;
	private JButton btnConnect, btnExit;
	public static Connection mastercon;
	private JTextField txtServerName;
	private JTextField txtPortNo;
	private JTextField txtUserName;
	private JTextField txtPassword;
	
	ClassLoader cl = ApplicationStart.class.getClassLoader();
	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public SQLConnection() throws Exception {
		try {
			ImageIcon icon = new ImageIcon(cl.getResource("data_replace.png"));
			setIconImage(icon.getImage());
			setForeground(new Color(0, 255, 204));
			setTitle("CONNECTION");
			getContentPane().setBackground(new Color(105, 105, 105));
			setBounds(100, 100, 458, 470);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			getContentPane().setLayout(null);
			setVisible(true);
			
			components();
			actions();
			
		
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void components() throws Exception {
		try {
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.control);
			panel.setBounds(0, 0, 444, 442);
			getContentPane().add(panel);
			panel.setLayout(null);
			
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(135, 206, 235));
			panel_1.setBounds(10, 11, 424, 41);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblHead = new JLabel("CONNECTION");
			lblHead.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
			lblHead.setHorizontalAlignment(SwingConstants.CENTER);
			lblHead.setBounds(10, 11, 404, 25);
			panel_1.add(lblHead);
			
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(135, 206, 250));
			panel_2.setBounds(10, 63, 424, 316);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			fldServerName = new JTextField();
			fldServerName.setBounds(10, 50, 404, 25);
			fldServerName.setColumns(10);
			panel_2.add(fldServerName);
			if(DbConnection.servername != null && !DbConnection.servername.equalsIgnoreCase("")) {
				fldServerName.setText(DbConnection.servername);
				fldServerName.setEditable(false);
			} else {
				fldServerName.setEditable(true);
			}
			
			fldPort = new JTextField();
			fldPort.setBounds(10, 119, 404, 25);
			fldPort.setColumns(10);
			panel_2.add(fldPort);
			if(DbConnection.portno != null && !DbConnection.portno.equalsIgnoreCase("")) {
				fldPort.setText(DbConnection.portno);
				fldPort.setEditable(false);
			} else {
				fldPort.setEditable(true);
			}
			
			fldUsername = new JTextField();
			fldUsername.setBounds(10, 188, 404, 25);
			fldUsername.setColumns(10);
			panel_2.add(fldUsername);
			if(DbConnection.username != null && !DbConnection.username.equalsIgnoreCase("")) {
				fldUsername.setText(DbConnection.username);
				fldUsername.setEditable(false);
			} else {
				fldUsername.setEditable(true);
			}
			
			fldPass = new JPasswordField();
			fldPass.setBounds(10, 264, 404, 25);
			panel_2.add(fldPass);
			if(DbConnection.password != null && !DbConnection.password.equalsIgnoreCase("")) {
				fldPass.setText(DbConnection.password);
				fldPass.setEditable(false);
			} else {
				fldPass.setEditable(true);
			}
			
			txtServerName = new JTextField();
			txtServerName.setBorder(null);
			txtServerName.setFont(new Font("Tahoma", Font.BOLD, 18));
			txtServerName.setForeground(new Color(255, 255, 255));
			txtServerName.setSize(new Dimension(3, 0));
			txtServerName.setEditable(false);
			txtServerName.setBackground(new Color(135, 206, 250));
			txtServerName.setBounds(10, 18, 404, 20);
			panel_2.add(txtServerName);
			txtServerName.setColumns(10);
			txtServerName.setText("Server Name");
			
			txtPortNo = new JTextField();
			txtPortNo.setBorder(null);
			txtPortNo.setSize(new Dimension(3, 0));
			txtPortNo.setForeground(Color.WHITE);
			txtPortNo.setFont(new Font("Tahoma", Font.BOLD, 18));
			txtPortNo.setEditable(false);
			txtPortNo.setColumns(10);
			txtPortNo.setBackground(new Color(135, 206, 250));
			txtPortNo.setBounds(10, 86, 404, 20);
			panel_2.add(txtPortNo);
			txtPortNo.setText("Port No");
			
			txtUserName = new JTextField();
			txtUserName.setBorder(null);
			txtUserName.setSize(new Dimension(3, 0));
			txtUserName.setForeground(Color.WHITE);
			txtUserName.setFont(new Font("Tahoma", Font.BOLD, 18));
			txtUserName.setEditable(false);
			txtUserName.setColumns(10);
			txtUserName.setBackground(new Color(135, 206, 250));
			txtUserName.setBounds(10, 155, 404, 20);
			panel_2.add(txtUserName);
			txtUserName.setText("User Name");
			
			txtPassword = new JTextField();
			txtPassword.setBorder(null);
			txtPassword.setSize(new Dimension(3, 0));
			txtPassword.setForeground(Color.WHITE);
			txtPassword.setFont(new Font("Tahoma", Font.BOLD, 18));
			txtPassword.setEditable(false);
			txtPassword.setColumns(10);
			txtPassword.setBackground(new Color(135, 206, 250));
			txtPassword.setBounds(10, 233, 404, 20);
			panel_2.add(txtPassword);
			txtPassword.setText("PassWord");
			
			btnConnect = new JButton("CONNECT");
			btnConnect.setBounds(86, 390, 89, 23);
			panel.add(btnConnect);
			btnConnect.setBackground(new Color(255, 248, 220));
			btnConnect.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 250, 154)));
			
			btnExit = new JButton("Exit");
			btnExit.setBounds(243, 390, 89, 23);
			panel.add(btnExit);
			btnExit.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 250, 154)));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void actions() throws Exception {

		try {
			
			btnExit.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						System.exit(0);
					}
				}
			});
			
			btnExit.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			
			
			fldServerName.addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER && !fldServerName.getText().trim().equalsIgnoreCase("")) {
						fldPort.requestFocus();
					}
					super.keyPressed(e);
				}
				
			});
			
			fldPort.addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER && !fldPort.getText().trim().equalsIgnoreCase("")) {
						fldUsername.requestFocus();
					}
					super.keyPressed(e);
				}
				
			});
			
			fldUsername.addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER && !fldUsername.getText().trim().equalsIgnoreCase("")) {
						fldPass.requestFocus();
					}
					super.keyPressed(e);
				}
				
			});
			
			fldPass.addKeyListener(new KeyAdapter() {
				
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnConnect.requestFocus();
					}
					super.keyPressed(e);
				}
				
			});
			
			btnConnect.addKeyListener(new KeyAdapter() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void keyPressed(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						
						try {
							
							if(checkServerConnection() != null) {
								
								JOptionPane.showMessageDialog(null, "Connection success", "CONNECTION", JOptionPane.INFORMATION_MESSAGE);
								
								new ServerDetails(fldServerName.getText(),fldPort.getText(), fldUsername.getText(), fldPass.getText().toString());
								
								mastercon = connection();
								
								setVisible(false);
								
								new Backup();
								
							} else {
								JOptionPane.showMessageDialog(null, "Connection Failure", "CONNECTION", JOptionPane.ERROR_MESSAGE);
								fldServerName.requestFocus();
							}
							
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
					super.keyPressed(e);
				}

				
				
			});
			
			btnConnect.addMouseListener(new MouseAdapter() {
				
				@SuppressWarnings("deprecation")
				@Override
				public void mousePressed(MouseEvent e) {
					try {
						
						if(checkServerConnection() != null) {
							
							JOptionPane.showMessageDialog(null, "Connection success", "CONNECTION", JOptionPane.INFORMATION_MESSAGE);
							
							new ServerDetails(fldServerName.getText(), fldPort.getText(), fldUsername.getText(), fldPass.getText().toString());
							
							mastercon = connection();
							
							setVisible(false);
							
							new Backup();
							
						} else {
							JOptionPane.showMessageDialog(null, "Connection Failure", "CONNECTION", JOptionPane.ERROR_MESSAGE);
							fldServerName.requestFocus();
						}
						
						
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					super.mousePressed(e);
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	
	}
	
	@SuppressWarnings("deprecation")
	private Connection checkServerConnection() throws Exception {
		try {
			
			String databasename ="master";
			String drivername = "net.sourceforge.jtds.jdbc.Driver";
			String connectionstr = "jdbc:jtds:sqlserver://" + fldServerName.getText() +":" + fldPort.getText() + "/" + databasename;
			Class.forName(drivername).newInstance();
			
			return DriverManager.getConnection(connectionstr, fldUsername.getText(), fldPass.getText().toString());
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public Connection connection() throws Exception {
		try {
			
			String databasename ="master";
			String drivername = "net.sourceforge.jtds.jdbc.Driver";
			String connectionstr = "jdbc:jtds:sqlserver://" + DbConnection.servername +":" + DbConnection.portno + "/" + databasename;
			Class.forName(drivername).newInstance();
			
			return DriverManager.getConnection(connectionstr, DbConnection.username, DbConnection.password);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	
}
