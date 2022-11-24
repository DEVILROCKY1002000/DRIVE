package com.bill.DesignComponents;

import java.awt.Component;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.bill.Common.YESORNO;

public class YesOrNo implements ActionListener,MouseListener {
	
	JPanel panel;
	ButtonGroup btngrp;
	private Font lblFont = new Font("Tahoma" , Font.BOLD, 16);
	int width = 150,height=35;
	YesOrNo y;
	String value;
	List<String> lst = new ArrayList<String>();
	public ButtonGroup btngrp(ButtonGroup btngrp,JPanel panel, int xPos, int yPos) throws Exception {
		try {
			btngrp = new ButtonGroup();
			for(Object s : YESORNO.values()) {
				JRadioButton btn = new JRadioButton(s.toString());
				btn.setBounds(xPos, yPos, width, height);
				btn.setBackground(null);
				btn.setLayout(null);
				btn.setFont(lblFont);
				btn.setVisible(true);
				btn.setName(btngrp.toString()+s.toString());
				panel.add(btn);
				btngrp.add(btn);
				btn.addActionListener(this);
				btn.addMouseListener(this);
				xPos+=200;
			}
			this.btngrp = btngrp;
			return btngrp;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public List<String> selected() throws Exception {
		return lst;
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
//			Enumeration<AbstractButton> bngrp = btngrp.getElements();
//			while (bngrp.hasMoreElements()) {
//				JRadioButton abstractButton = (JRadioButton) bngrp.nextElement();
//				if(abstractButton.isSelected()) {
//					selectedValue(abstractButton.getText());
//					break;
//				}
//			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public void mouseClicked(MouseEvent e) {
		Component o = (Component) e.getSource();
		try {
			lst.add(o.getName());
		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (Exception e1) {
			e1.printStackTrace();
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
