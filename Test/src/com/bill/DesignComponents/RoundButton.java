package com.bill.DesignComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.border.Border;

public class RoundButton implements Border {
	
	int radius;
	
	public RoundButton(int radi) {
		this.radius = radi;
	}
	
	public Insets getBorderInsets(Component c) {
        return new Insets(this.radius, this.radius, this.radius, this.radius);
    }
	
    public boolean isBorderOpaque() {
        return true;
    }
    
    public void paintBorder(Component c, Graphics g1, int x, int y, int width, int height) {
//    	Graphics2D g = (Graphics2D) g1.create();
//    	g.drawRoundRect(x, y, c.getWidth()-1, c.getHeight()-1, radius*2, radius*2);
        Graphics2D g= (Graphics2D) g1;
		width = c.getWidth();
		height = c.getHeight();
		int offs = Integer.valueOf((int) (c.getWidth() / 100));
        int size = offs + offs;
        float arc = (radius*2) * offs;
        Shape outer = new RoundRectangle2D.Float(x, y, width, height, arc, arc);
        Shape inner = new RoundRectangle2D.Float(x + offs, y + offs, width - size, height - size, arc, arc);
        Path2D path = new Path2D.Float(Path2D.WIND_EVEN_ODD);
        path.append(outer, false);
        path.append(inner, false);
        g.fill(path);
    	g.setColor(Color.decode("#1be0a8"));
    	if(!c.isEnabled()) {
    		c.setForeground(Color.decode("#1be0a8"));
    		c.setBackground(new Color(30,30,30,5));
    		c.isOpaque();
    	} else {
    		c.setForeground(Color.WHITE);
    		c.isOpaque();
    	}
        g.dispose();
        
    }
    
}
