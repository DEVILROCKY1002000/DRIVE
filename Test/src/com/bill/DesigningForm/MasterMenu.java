package com.bill.DesigningForm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.bill.DataLayer.View;

public class MasterMenu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4830212670398255364L;
	private JPanel entryPanel;
	private JMenu functionMaster,Exit;
	private JMenuItem fnMaster,fnView;
	private ClassLoader cl = Login.class.getClassLoader(); 
	View view = new View();
	
	public MasterMenu() throws Exception {
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
			panel();
			label();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void panel() throws Exception {
		try {
			
			entryPanel = new JPanel();
			entryPanel.setBounds(0, 0, 1500, 900);
			entryPanel.setVisible(true);
			entryPanel.setLayout(null);
			entryPanel.setBackground(Color.WHITE);
			getContentPane().add(entryPanel);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void label() throws Exception {
		try {
			
			JMenuBar bar = new JMenuBar();
			bar.setBounds(0, 0, 1500, 150);
			bar.setBackground(Color.LIGHT_GRAY);
			bar.setOpaque(true);
			bar.setVisible(true);
			
			functionMaster = new JMenu("Function Master");
			functionMaster.setBounds(50, 10, 600, 100);
			functionMaster.setVisible(true);
			functionMaster.setLayout(null);
			
			Exit = new JMenu("Exit");
			ImageIcon icon =  new ImageIcon(cl.getResource("logout2.png"));
			icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
			Exit.setIcon(icon);
			Exit.setVisible(true);
			Exit.setLayout(null);
			Exit.addActionListener(this);
			Exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						setVisible(false);
						Homepage h = new Homepage();
						h.setVisible(true);
					} catch (Exception e2) {
						e2.printStackTrace();
					}
					super.mouseClicked(e);
				}
			});
			
			fnMaster = new JMenuItem("Function Master");
			fnMaster.setSize(170, 100);
			fnMaster.setFont(new Font("Times New Roman", Font.BOLD, 15));
			fnMaster.addActionListener(this);
			
			fnView = new JMenuItem("Master View");
			fnView.setSize(170, 100);
			fnView.setFont(new Font("Times New Roman", Font.BOLD, 15));
			fnView.addActionListener(this);
			
			functionMaster.setFont(new Font("Times New Roman", Font.BOLD, 15));
			functionMaster.add(fnMaster);
			functionMaster.add(fnView);
			
			bar.add(functionMaster);
			bar.add(Exit);
			entryPanel.add(bar);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		try {
			
			Object o = e.getSource();
			if(o.equals(fnMaster)) {
				setVisible(false);
				Master master = new Master();
				master.setVisible(true);
			} else if(o.equals(Exit)) {
				setVisible(false);
				Homepage home = new Homepage();
				home.setVisible(true);
			} else if(o.equals(fnView)) {
				setVisible(false);
				MasterView view = new MasterView();
				view.setVisible(true);
			}
			
		} catch (Exception e2) {
			e2.getStackTrace();
		}
	}
}
