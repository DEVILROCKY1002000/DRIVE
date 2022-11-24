package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Path2D;

import javax.swing.border.Border;

public class TextFieldBorder implements Border {
	
    public boolean isBorderOpaque() {
        return true;
    }
    
    public void paintBorder(Component c, Graphics g1, int x, int y, int width, int height) {
        Graphics2D g= (Graphics2D) g1;
		width = c.getWidth();
		height = c.getHeight();
        Shape outer = new Rectangle.Float(x, y, width, height);
        Shape inner = new Rectangle.Float(x+1, y+1, width-2, height-2);
        Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
        path.append(outer, false);
        path.append(inner, false);
        g.fill(path);
        c.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				c.setBackground(Color.WHITE);
				c.setForeground(Color.BLACK);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				c.setBackground(Color.decode("#1be0a8"));
				c.setForeground(Color.WHITE);
			}
			
		});
        g.dispose();
        
    }

	@Override
	public Insets getBorderInsets(Component c) {
		return new Insets(1, 1, 1, 1);
	}
    
}
