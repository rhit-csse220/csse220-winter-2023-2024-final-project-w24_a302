package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Ellipse2D;

public class Hero {
	protected int heroX;
	protected int heroY;
	protected int xSpeed;
	protected int ySpeed;
	protected Color heroColor = Color.CYAN;
	protected int heroLives;
	protected boolean isJumping = false;
	protected final int Gravity = 1;

	Hero(int x, int y, int speed) {
		this.heroX = x;
		this.heroY = y;
		this.xSpeed = speed;
		this.ySpeed = 20;
		this.heroLives = 3;

	}

	public void drawOn(Graphics2D g2) {
		Ellipse2D hero = new Ellipse2D.Double(heroX, heroY, 50, 50);
		g2.setColor(heroColor);
		g2.fill(hero);
	}

	public void moveUp() {
		heroY -= ySpeed;
		if(heroY < 0) {
			heroY = 0;
		}
	}
	

	public void sideMove() {
		if (heroX >= 935 - xSpeed) {
			heroX = 935;
		} else {
			heroX = heroX + xSpeed;
		}
	}
}
