package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;

import com.bill.Common.Appcommon;
import com.bill.DataLayer.Print;
import com.bill.Model.PrintModel;
import com.bill.Printing.PrinterJobFile;

@SuppressWarnings("serial")
public class TableReport extends JTable implements KeyListener {
	
	JPanel panel;
	JTable table;
	DefaultTableModel tblModel;
	String[] columns;
	List<String[]> lstRows = new ArrayList<String[]>();
//	Map<String[], String[]> map = new HashMap<String[], String[]>();
	int x,y,width,height,selectedRow;
	String tableName;
	
	public TableReport(JPanel panels, String name,
			String[] tableColumns, List<String[]> listRows, int x, int y, int width, int height) throws Exception {
		try {
			panel = panels;
			columns = tableColumns;
			lstRows = listRows;
//			map = map1;
			this.x=x;
			this.y=y;
			this.width=width;
			this.height=height;
			this.tableName = name;
			createTable();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private void createTable() throws Exception {
		try {
			tblModel = new DefaultTableModel(columns,0);
			table = new JTable(tblModel){
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Arial black", Font.BOLD, 14));
			header.setDefaultRenderer(new Header());
			header.setAutoscrolls(true);
			header.setEnabled(false);
			((DefaultTableCellRenderer)header.getDefaultRenderer()).setHorizontalAlignment((int) JLabel.CENTER_ALIGNMENT);
			table.setDefaultRenderer(Object.class, new Rows());
			table.setFont(new Font("Tahoma", Font.CENTER_BASELINE, 12));
			table.setSelectionBackground(new Color(232,57,95));
			table.setIntercellSpacing(new Dimension(0,0));
			table.setShowVerticalLines(false);
			table.setName(tableName);
			table.removeEditor();
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.setAutoscrolls(true);
			
			JScrollPane pane = new JScrollPane(table);
			pane.setAutoscrolls(true);
			table.setBounds(10, 10, 300, 300);
			table.setVisible(true);
			table.setLayout(null);
			table.setRowHeight(30);
			table.addKeyListener(this);
			
			pane.setBounds(x, y, width, height);
			JPanel corner = new JPanel();
			corner.setBackground(new Color(30,30,30));
			pane.setCorner(JScrollPane.UPPER_RIGHT_CORNER, corner);
//			pane.setVerticalScrollBar(new ScrollBar());
//			pane.setHorizontalScrollBar(new ScrollBar());
			pane.getViewport().setBackground(Color.LIGHT_GRAY);
			table.setToolTipText("Should not be edit the Report Data");
			for(String[] s : lstRows) {
				tblModel.addRow(s);
			}
			panel.add(pane);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private class Header extends DefaultTableCellRenderer {
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			c.setBackground(new Color(30,30,30));
			c.setForeground(Color.WHITE);
			c.setPreferredSize(new Dimension(0, 35));
			return c;
		}
	}
	
	private class Rows extends DefaultTableCellRenderer {
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			setBorder(new EmptyBorder(0,0,0,0));
			table.setSelectionBackground(new Color(232,57,95));
			table.setIntercellSpacing(new Dimension(0,0));
			table.getColumnModel().getColumn(column).setPreferredWidth(175);
			if(table.isCellSelected(row, column) && (row != lstRows.size() - 1)) {
				table.setSelectionBackground(new Color(232,57,95));
				table.setIntercellSpacing(new Dimension(0,0));
			} else {
				if(row % 2 == 0 && (row != lstRows.size() - 1)) {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				} else if (row == lstRows.size() - 1){
					c.setBackground(new Color(32,136,203));
					c.setForeground(Color.BLACK);
				} else if(row % 2 != 0 && (row != lstRows.size() - 1)) {
					c.setBackground(Color.WHITE);
					c.setForeground(Color.BLACK);
				}
			}
			
//			if(table.isCellSelected(row, column) && (row != map.size() - 1)) {
//				table.setSelectionBackground(new Color(232,57,95));
//				table.setIntercellSpacing(new Dimension(0,0));
//			} else {
//				if(row % 2 == 0 && (row != map.size() - 1)) {
//					c.setBackground(Color.WHITE);
//					c.setForeground(Color.BLACK);
//				} else if (row == map.size() - 1){
//					c.setBackground(new Color(32,136,203));
//					c.setForeground(Color.BLACK);
//				} else if(row % 2 != 0 && (row != map.size() - 1)) {
//					c.setBackground(Color.WHITE);
//					c.setForeground(Color.BLACK);
//				}
//			}
			
			return c;
		}
	}
	
	public int printData() throws Exception {
		try {
			return selectedRow;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@SuppressWarnings("unused")
	private class ScrollBar extends JScrollBar {
		
		@SuppressWarnings("unused")
		public ScrollBar() {
			setUI(new ScrollPaneUI());
			setPreferredSize(new Dimension(8,8));
			setForeground(new Color(48,144,216));
			setBackground(Color.WHITE);
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		
		try {
			if(e.getKeyCode() == KeyEvent.VK_P && ((JTable) e.getSource()).getName().equals("Report")) {
				if(((JTable) e.getSource()).getSelectedRow() != 0 && ((JTable) e.getSource()).getRowCount() > -1) {
					Print print = new Print();
					PrintModel model = new PrintModel();
					Appcommon.customerID = (String) ((JTable) e.getSource()).getValueAt(
							((JTable) e.getSource()).getSelectedRow(), 2);
					model.setCollectionReportModels(print.customerCollection(Appcommon.customerID));
					model.setReportModels(print.customerDetails(Appcommon.customerID));
					new PrinterJobFile(216, 600, model);
				} else {
					JOptionPane.showMessageDialog(null, "Select any one and press the 'P' button then take a Duplicate Copy", "Duplicate Receipt", JOptionPane.ERROR_MESSAGE);
				}
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}


	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
	public void filter(String searchText) throws Exception {
		try {
			TableRowSorter<DefaultTableModel> t= new TableRowSorter<DefaultTableModel>(tblModel);
			table.setRowSorter(t);
			if(!searchText.isEmpty()) {
				t.setRowFilter(RowFilter.regexFilter(searchText));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
