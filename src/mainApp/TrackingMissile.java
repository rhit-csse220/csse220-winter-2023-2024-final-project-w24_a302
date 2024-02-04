package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class TrackingMissile extends Missiles {
	private Hero target;
	private int speed;

	public TrackingMissile(int x, int y, Hero target) {
		super(x, y);
		this.target = target;
		this.speed = 3;
	}

	@Override
	public void updateMissile() {
		double dx = target.getX() - x;
		double dy = target.getY() - y;
		double angle = Math.atan2(dy, dx);
		
		double vx = this.speed * Math.cos(angle);
		double vy = this.speed * Math.sin(angle);
		
		x += vx;   
		y += vy;
		
	}

	@Override
	public Rectangle getBox() {
		return null;
	}


}
