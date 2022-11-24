package com.bill.Printing;

import java.awt.Font;
import java.awt.Graphics;

import com.bill.Common.Alignment;
import com.bill.Common.Appcommon;
import com.bill.Common.Position;
import com.bill.Common.TextAlignment;
import com.bill.Model.CollectionReportModel;
import com.bill.Model.PrintModel;
import com.bill.Model.ReportModel;

public class ReceiptPrint {

	PrintModel list = new PrintModel();
	public ReceiptPrint(PrintModel model) {
		this.list = model;
	}
	
	public int PrintHeader(Graphics g, int y) throws Exception {
		try {
			int dy = 20;
			g.setFont(new Font("Garamond", Font.PLAIN, 13));
			for (ReportModel model : list.getReportModels()) {
				y = TextAlignment.printText(g, "NAME", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, model.getCustomerName(), y, Position.POS3, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, "ID", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, model.getCustomerid(), y, Position.POS3, Alignment.LEFT);
				y = TextAlignment.printText(g, "AMOUNT", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, Appcommon.amountFormat.format(model.getAmount()), y, Position.POS3, Alignment.LEFT);
				y = TextAlignment.printText(g, "AREA", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, model.getArea(), y, Position.POS3, Alignment.LEFT);
				y = TextAlignment.printText(g, "CITY", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, model.getCity(), y, Position.POS3, Alignment.LEFT);
				y = TextAlignment.printText(g, "Mob.No", y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, model.getMobilenumber(), y, Position.POS3, Alignment.LEFT);
			}
			g.setFont(new Font("Garamond", Font.BOLD, 16));
			g.drawLine(0, y+=dy, 300, y);
			y = TextAlignment.printText(g, "Payment Details", y+=dy, Position.PAGECENTER, Alignment.CENTER);
			g.drawLine(0, y+=dy-8, 300, y);
			for (CollectionReportModel model : list.getCollectionReportModels()) {
				y = TextAlignment.printText(g, model.getModeofPay(), y+=dy, Position.POS1, Alignment.LEFT);
				y = TextAlignment.printText(g, ":", y, Position.POS2, Alignment.LEFT);
				y = TextAlignment.printText(g, Appcommon.amountFormat.format(model.getAmount()), y, Position.POS4, Alignment.RIGHT);
			}
			
			return y;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
