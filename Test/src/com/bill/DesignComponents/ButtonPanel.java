package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class ButtonPanel extends JFrame implements MouseListener, KeyListener, FocusListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1545026682444125487L;
	private JButton btnAdd,btnSave,btnCancel,btnClear,btnExit;
	private JPanel btnPanel;
	public ButtonPanel(JPanel panel) throws Exception {
		try {
			this.btnPanel = panel;
			button();
		} catch (Exception e) {
			e.printStackTrace();
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

	@Override
	public void focusGained(FocusEvent e) {
		Border border = new RoundButton(5);
		JButton c = (JButton) e.getSource();
		c.setForeground(Color.WHITE);
		c.setBorder(border);
	}
	@Override
	public void focusLost(FocusEvent e) {
		Border border = new RoundButton(25);
		JButton c = (JButton) e.getSource();
		c.setForeground(Color.WHITE);
		c.setBorder(border);
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
					
				} else if(c.equals(btnCancel)) {
					
				} else if(c.equals(btnClear)) {
					
				} else if(c.equals(btnSave)) {
					
				} else if(c.equals(btnAdd)) {
					
				} else {
					
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
		Component c = (Component) e.getSource();
		if(c.equals(btnExit)) {
			
		} else if(c.equals(btnCancel)) {
			
		} else if(c.equals(btnClear)) {
			
		} else if(c.equals(btnSave)) {
			
		} else if(c.equals(btnAdd)) {
			
		} else {
			
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
	
}
