package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

class Barriers extends OtherObjects{
	protected int rotation;
	protected boolean isCharged;
	protected Color blankColor = Color.GRAY;
	protected Color chargeColor = Color.ORANGE;
	
	Barriers(int x, int y, int rotation, boolean isCharged){
		super(x,y);
		this.rotation = rotation;
		this.isCharged = isCharged;
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
		g2.rotate(Math.toRadians(rotation), x+5, y+50);
        Rectangle bar = new Rectangle(x, y, 10, 100);
        if(isCharged) {
        	g2.setColor(chargeColor);
        }
        else {
        	g2.setColor(blankColor);
        }
        g2.fill(bar);
        g2.rotate(-Math.toRadians(rotation), x+5, y+50);
    }
}
