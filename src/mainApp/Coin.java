package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

//TODO Make an inheritance class for this and barriers reduce code duplication

public class Coin {
	protected int coinX;
	protected int coinY;
	protected Color coinColor = Color.YELLOW;
	
	Coin(int x, int y){
		this.coinX = x;
		this.coinY = y;
	}
	
	public void drawOn(Graphics2D g2) {
        Ellipse2D coin = new Ellipse2D.Double(coinX, coinY, 25, 25);
        g2.setColor(coinColor);
        g2.fill(coin);
    }
}
