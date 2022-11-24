package com.bill.DesigningForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import com.bill.Common.Appcommon;
import com.bill.Common.Combo;
import com.bill.DataLayer.LoginOperatorDataLayer;
import com.bill.Model.LoginOperatorModel;

public class Login extends JFrame implements MouseListener,KeyListener {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5628089109623656546L;
	public static final long serialversionuid=1l;
	private JPanel outerpanel;
	private JLabel lablusername,lablpassword,buttonimg,outerlable,loginimage;
	private JComboBox<Combo>cmbusername;
	private JPasswordField password;
	private JButton loginbutton,exitbutton;
	ClassLoader classLoader=Login.class.getClassLoader();
	String pass ,pass1;
	List<LoginOperatorModel> lstOperator = new ArrayList<LoginOperatorModel>();
	LoginOperatorDataLayer dataLayer = new LoginOperatorDataLayer();
	
	public Login() {
		try {
			setLayout(null);
			getContentPane().setPreferredSize(new Dimension(600, 450));
			setBounds(0, 0, 600, 450);
			setTitle("Login");
			setBackground(Color.black);
			setResizable(false);
			setLocationRelativeTo(null);
			setUndecorated(true);
			pack();
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			Outerpanel();
			lstOperator = dataLayer.loginoperator();
			LogDeat();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void Outerpanel() throws Exception {
		try {
			
			outerpanel= new JPanel();
			outerpanel.setBounds(0, 0, 600, 450);
			outerpanel.setVisible(true);
			outerpanel.setLayout(null);
			setTitle("Login");
			
			outerlable = new JLabel(new ImageIcon(classLoader.getResource("bg.jpg")));
			outerlable.setBounds(0, 0, 600, 450);
			outerlable.setVisible(true);
			outerlable.setLayout(null);
			
			loginimage= new JLabel("");
			loginimage.setBounds(240, 80, 100, 108);
			loginimage.setVisible(true);
			loginimage.setLayout(null);
			
			buttonimg = new JLabel();
			buttonimg.setBounds(240, 80, 100, 108);
			buttonimg.setVisible(true);

			getContentPane().add(outerpanel);
			outerpanel.add(outerlable);
			outerlable.add(loginimage);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void LogDeat() {
		
		cmbusername= new JComboBox<Combo>();
		cmbusername.setBounds(180, 210, 240, 35);
		cmbusername.setLightWeightPopupEnabled(true);
		cmbusername.addMouseListener(this);
		cmbusername.addKeyListener(this);
		setBackground(Color.red);
		for(int i= 0; i < lstOperator.size(); i++) {
			LoginOperatorModel model = lstOperator.get(i);
			cmbusername.addItem(new Combo(i, model.getEmpName()));
		}
		cmbusername.setVisible(true);
		outerlable.add(cmbusername);
		
		
		lablusername = new JLabel("U S E R N A M E");
		lablusername.setFont(new Font("Calibiri", Font.BOLD, 12));
		lablusername.setBounds(180, 190, 200, 25);
		lablusername.setEnabled(false);
		lablusername.setVisible(true);
		outerlable.add(lablusername);
		
		password= new JPasswordField();
		password.setEditable(true);
		password.setBounds(180, 270, 240, 35);
		password.setVisible(true);
		password.addMouseListener(this);
		password.addKeyListener(this);
		outerlable.add(password);
		
		lablpassword = new JLabel("P A S S W O R D");
		lablpassword.setFont(new Font("Calibiri", Font.BOLD, 12));
		lablpassword.setBounds(180, 245, 200, 35);
		lablpassword.setEnabled(false);
		lablpassword.setVisible(true);
		outerlable.add(lablpassword);
		
		loginbutton= new JButton();
		loginbutton.setText("L o g i n");
		loginbutton.setBounds(180, 320, 100, 35);
		loginbutton.setFont(new Font("Calibiri", Font.BOLD, 14));
		loginbutton.setBackground(Color.decode("#3AdB85"));
		loginbutton.setForeground(Color.black);
		loginbutton.setVisible(true);
		loginbutton.setBorder(null);
		loginbutton.addMouseListener(this);
		loginbutton.addKeyListener(this);
		outerlable.add(loginbutton);
		
		exitbutton = new JButton();
		exitbutton.setText("E X I T");
		exitbutton.setBounds(320, 320, 100, 35);
		exitbutton.setFont(new Font("Calibiri", Font.BOLD, 14));
		exitbutton.setBackground(Color.decode("#3AdB85"));
		exitbutton.setForeground(Color.black);
		exitbutton.setVisible(true);
		exitbutton.setBorder(null);
		exitbutton.setLayout(null);
		exitbutton.addMouseListener(this);
		exitbutton.addKeyListener(this);
		outerlable.add(exitbutton);
	}
	
	public void keyTyped(KeyEvent e) {
		
		
	}

	@SuppressWarnings("deprecation")
	public void keyPressed(KeyEvent e) {
		
		try {
			Object o = e.getSource();
			
			if(o.equals(cmbusername) && e.getKeyCode() == KeyEvent.VK_ENTER) {
				password.requestFocus();
			} else if(o.equals(password) && e.getKeyCode() == KeyEvent.VK_ENTER) {
				if(password.getText().length() != 0) {
					loginbutton.requestFocus();
				} else {
					password.setText("");
					password.requestFocus();
				}
			} else if(o.equals(exitbutton) && e.getKeyCode() == KeyEvent.VK_ENTER) {
				System.exit(0);
			} else if(o.equals(loginbutton) && e.getKeyCode() == KeyEvent.VK_ENTER) {
				int i = cmbusername.getSelectedIndex();
				
				if(lstOperator.get(i).getEmpPassWord().equals(password.getText())) {
					Appcommon.operCode = lstOperator.get(i).getEmpNo();
					setVisible(false);
					Homepage homepage = new Homepage();
					homepage.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter The Correct Password");
					password.requestFocus();
				}
			}
		} catch (Exception e2) {
			e2.getStackTrace();
		}
		
	}

	public void keyReleased(KeyEvent e) {
		
		
	}

	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent e) {
		try {
			Object o = e.getSource();
			
			if(o.equals(exitbutton)) {
				System.exit(0);
			} else if(o.equals(loginbutton)) {
				int i = cmbusername.getSelectedIndex();
				
				if(lstOperator.get(i).getEmpPassWord().equals(password.getText())) {
					setVisible(false);
					Homepage homepage = new Homepage();
					homepage.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Please Enter The Correct Password");
					password.requestFocus();
				}
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
