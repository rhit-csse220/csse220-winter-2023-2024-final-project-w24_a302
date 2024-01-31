package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Coin extends OtherObjects{
	protected Color coinColor = Color.YELLOW;
	
	Coin(int x, int y){
		super(x,y);
	}
	
	@Override
	public void drawOn(Graphics2D g2) {
        Ellipse2D coin = new Ellipse2D.Double(x, y, 25, 25);
        g2.setColor(coinColor);
        g2.fill(coin);
    }
}
