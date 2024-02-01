package mainApp;

import java.awt.Graphics2D;

/**
 * Class: CollisionObjects
 * @author W24_A_302
 * <br>Purpose: Used to provide inheritance for objects that are fixed and have collisions with the hero.
 * <br>Restrictions: None
 */
public abstract class CollisionObjects {
	protected int x;
	protected int y;
	
	//Constructor for the position of the object
	public CollisionObjects(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//Abstract method for drawOn
	public abstract void drawOn(Graphics2D g2);
}
