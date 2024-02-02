package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class Missiles extends CollisionObjects {
	protected int speed;
	protected Color missileColor = Color.RED;

	public Missiles(int x, int y, int speed) {
		super(x, y, false);
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void update();

	@Override
	public void drawOn(Graphics2D g2) {
		// TODO Auto-generated method stub
		Rectangle missile = new Rectangle(x, y, 50, 10);
		g2.setColor(missileColor);
		g2.fill(missile);
		g2.setColor(Color.BLACK);
		
		
	}

	@Override
	public void collisionWithHero(Hero hero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rectangle getBox() {
		// TODO Auto-generated method stub
		return null;
	}

}
