package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.bill.DesigningForm.Homepage;

public class HeaderPanel extends JFrame implements MouseListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8729331844992302237L;
	private JPanel headerPanel;
	private JLabel lblDate,lblTime;
	private ClassLoader classLoader= Homepage.class.getClassLoader();
	private JLabel lblClose;
	String time = "";
	String date = "";
	public HeaderPanel(JPanel panel) throws Exception {
		this.headerPanel = panel;
		panel();
	}
	
	private void panel() throws Exception {
		try {			
			
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
	
	public boolean close(JFrame frame) throws Exception {
		try {
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().equals(lblClose)) {
			
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
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
		
	}
}
