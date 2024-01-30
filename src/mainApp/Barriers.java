package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

//TODO lets use an abstract class for this and coins to reduce code duplication

class Barriers {
	protected int barX;
	protected int barY;
	protected int rotation;
	protected boolean isCharged;
	protected Color blankColor = Color.GRAY;
	protected Color chargeColor = Color.ORANGE;
	
	Barriers(int x, int y, int rotation, boolean isCharged){
		this.barX = x;
		this.barY = y;
		this.rotation = rotation;
		this.isCharged = isCharged;
	}
	
	public void drawOn(Graphics2D g2) {
		g2.rotate(Math.toRadians(rotation));
        Rectangle bar = new Rectangle(barX, barY, 10, 100);
        if(isCharged) {
        	g2.setColor(chargeColor);
        }
        else {
        	g2.setColor(blankColor);
        }
        g2.fill(bar);
    }
}
