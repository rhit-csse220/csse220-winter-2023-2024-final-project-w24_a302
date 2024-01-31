package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;


public class Hero {
	protected int heroX = 0;
	protected int heroY= 0;
	protected int xSpeed = 0;
	protected Color heroColor = Color.CYAN;
	protected int heroLives;
	
	Hero(int x, int y, int speed){
		heroX = x;
		heroY = y;
		xSpeed = speed;
		heroLives = 3;
	}
	
	public void drawOn(Graphics2D g2) {
        Ellipse2D hero = new Ellipse2D.Double(heroX, heroY, 50, 50);
        g2.setColor(heroColor);
        g2.fill(hero);
    }
	
}



