package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;


//TODO need to implement a list to keep track of coins 
//TODO need a variable for lives

public class Hero {
	protected int heroX;
	protected int heroY;
	protected int xSpeed;
	protected Color heroColor = Color.CYAN;
	
	Hero(int x, int y, int speed){
		this.heroX = x;
		this.heroY = y;
		this.xSpeed = speed;
	}
	
	public void drawOn(Graphics2D g2) {
        Ellipse2D hero = new Ellipse2D.Double(heroX, heroY, 50, 50);
        g2.setColor(heroColor);
        g2.fill(hero);
    }
	
	public void update() {
		heroX = heroX + xSpeed;
	}
}



