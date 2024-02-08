package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: Tracking Missiles
 * 
 * @author W24_A_302 <br>
 *         Purpose: Tracking Missiles extends from missiles, which contain the data for these
 *         missiles and can update the missiile's position and get the missiles box <br>
 *         Restrictions: None
 */
public class TrackingMissile extends Missiles {
	private Hero target;
	private int speed;

	//constructor for tracking missiles that access the super class and sets its target
	public TrackingMissile(int x, int y, Hero target) {
		super(x, y);
		this.target = target;
		this.speed = 3;
	}

	//updates the tracking missile to track the target
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

	//gets the bounding box of the missile that is used for missile collisions
	

	


}
