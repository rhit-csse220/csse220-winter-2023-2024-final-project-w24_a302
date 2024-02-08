package mainApp;

import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: CollisionObjects
 * @author W24_A_302
 * <br>Purpose: Used to provide inheritance for objects that are fixed and have collisions with the hero.
 * <br>Restrictions: None
 */
public abstract class CollisionObjects {
	protected int x;
	protected int y;
	protected boolean isCoin;
	
	//Constructor for the position of the object
	public CollisionObjects(int x, int y, boolean isCoin) {
		this.x = x;
		this.y = y;
		this.isCoin = isCoin;
	}
	
	//Abstract method for drawOn
	public abstract void drawOn(Graphics2D g2);
	
	//Abstract method for collision with hero
	public abstract void collisionWithHero(Hero hero);
	
	//Abstract method for getBox
	public abstract Rectangle getBox();
	
	//Hello
	
}
