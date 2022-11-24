package com.bill.Printing;

import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;

import com.bill.Model.PrintModel;

public class PrinterJobFile  {
	
	PrinterJobFile job;
	int paperSizeWidth, paperSizeHeight;
	PrintModel list = new PrintModel();
	public PrinterJobFile(int paperWidth, int paperHeight, PrintModel model) throws Exception {
		this.paperSizeWidth = paperWidth;
		this.paperSizeHeight = paperHeight;
		this.list = model;
		printerpaper();
	}
	
	public void printerpaper() throws Exception {
		try {
			
			Paper paper = new Paper();
			paper.setSize(paperSizeWidth, paperSizeHeight);
			paper.setImageableArea(0, 0, paperSizeWidth, paperSizeHeight);
			PageFormat pageFormat = new PageFormat();
			pageFormat.setPaper(paper);
			PrintService[] service = PrintServiceLookup.lookupPrintServices(null ,null);
			PrintService service2 = PrintServiceLookup.lookupDefaultPrintService();
			if(service2 != null) {
				PrinterJob job = PrinterJob.getPrinterJob();
				job.setPrintService(service2);
				job.setPrintable(new Printing(list), pageFormat);
				job.setCopies(1);
				job.print();
			} else {
				for(PrintService serv:  service) {
					if(serv.getName().equalsIgnoreCase("")) {
						PrinterJob job = PrinterJob.getPrinterJob();
						job.setPrintService(serv);
						job.setPrintable(new Printing(list), pageFormat);
						job.setCopies(2);
						job.print();
					}
				}
			}
		} catch (Exception e) {
			if(e.getStackTrace() != null) {
				JOptionPane.showMessageDialog(null, "Printing cancelled..");
			} else {
				e.printStackTrace();
				throw e;
			}
			
		}
	}
}
