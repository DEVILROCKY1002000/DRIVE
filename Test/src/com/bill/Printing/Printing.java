package com.bill.Printing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import com.bill.Model.PrintModel;

public class Printing implements Printable{

	int y = 0, page = 1, turn = 1, pageheight;
	PrinterJob job;
	PrintModel list = new PrintModel();
	
	public Printing(PrintModel model) {
		this.list = model;
	}
	
	@Override
	public int print(Graphics g2d, PageFormat pageFormat, int pageIndex) throws PrinterException {
		
		try {
			
			if (pageIndex >= page) {
				return NO_SUCH_PAGE;
			}
			
			Graphics2D g = (Graphics2D) g2d;			
	        g.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
	        
			if (turn % 2 == 0) {
				y = 20;
				ReceiptPrint r = new ReceiptPrint(list);
				y = r.PrintHeader(g, y);
			}
			
			turn += 1;
			return PAGE_EXISTS;
		} catch (Exception e) {
			e.printStackTrace();
			return NO_SUCH_PAGE;
		}
	}
}
