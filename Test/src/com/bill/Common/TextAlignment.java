package com.bill.Common;

import java.awt.Graphics;

public class TextAlignment {
	
	public static int printText(Graphics g, String data, int y, Position x, Alignment align) {
		
		if(Alignment.RIGHT.equals(align)) {
			g.drawString(data, x.x+(30 - g.getFontMetrics().stringWidth(data)) , y);
		} else if(Alignment.CENTER.equals(align)) {
			g.drawString(data, x.x+(30 - g.getFontMetrics().stringWidth(data) / 2) , y);
		} else if(Alignment.LEFT.equals(align)) {
			g.drawString(data, x.x, y);
		}
		
		return y;
	}	
}
