package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Missiles {
	protected int speed;
	protected Color missileColor = Color.RED;
	protected int x;
	protected int y;

	public Missiles(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.speed = 5;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void updateMissile();
	
	public void drawOn(Graphics2D g2) {
		Rectangle missile = new Rectangle(x, y, 50, 10);
		g2.setColor(missileColor);
		g2.fill(missile);
		g2.setColor(Color.BLACK);
	}

		

	public abstract Rectangle getBox();

}
