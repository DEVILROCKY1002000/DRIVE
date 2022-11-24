package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

public class ScrollPaneUI extends BasicScrollBarUI {

	private final int THUMBSIZE = 60;
	
	@Override
	protected Dimension getMaximumThumbSize() {
		if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(0, THUMBSIZE);
		} else {
			return new Dimension(THUMBSIZE, 0);
		}
		
	}
	
	@Override
	protected Dimension getMinimumThumbSize() {
		if(scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			return new Dimension(THUMBSIZE, 0);
		} else {
			return new Dimension(0, THUMBSIZE);
		}
		
	}
	
	@Override
	protected JButton createIncreaseButton(int orientation) {
		return new ScrollButton();
	}
	
	@Override
	protected JButton createDecreaseButton(int orientation) {
		return new ScrollButton();
	}
	
	@Override
	protected void paintTrack(Graphics g2, JComponent c, Rectangle trackBounds) {
		
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int oreiantation = scrollbar.getOrientation();
		int size,x,y,width,height;
		
		if(oreiantation == JScrollBar.VERTICAL) {
			size = trackBounds.width / 2;
			x = trackBounds.x + ((trackBounds.width - size)/2);
			y = trackBounds.y;
			width = size;
			height = trackBounds.height;
		} else {
			size = trackBounds.height;
			x = 0;
			y = trackBounds.y + ((trackBounds.height - size));
			width = trackBounds.width;
			height = size;
		}
		g.setColor(new Color(30,30,30));
		g.fillRect(x-2, y-4, width+4, height+4);
	}
	
	@Override
	protected void paintThumb(Graphics g2, JComponent c, Rectangle thumbBounds) {
		Graphics2D g = (Graphics2D) g2;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		int oriantation = scrollbar.getOrientation();
		int x = thumbBounds.x;
		int y = thumbBounds.y;
		int width = thumbBounds.width;
		int height = thumbBounds.height;
		int radius = width * (50/100);
		if(oriantation == JScrollBar.VERTICAL) {
			y+=8;
			height -= 16;
		} else {
			x+=8;
			width -= 16;
		}
		g.setColor(new Color(250,250,250));
		g.fillRoundRect(x, y-10, width, height, radius, radius);
	}
	
	@SuppressWarnings("serial")
	private class ScrollButton extends JButton {
		
		public ScrollButton() {
			setBorder(BorderFactory.createEmptyBorder());
		}
		
	}
}
