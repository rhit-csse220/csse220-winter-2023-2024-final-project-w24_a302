package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

/**
 * Class: Path Missiles
 * 
 * @author W24_A_302 <br>
 *         Purpose: Path Missiles extends from missiles, which contain the data for these
 *         missiles and can update the missiile's position and get the missiles box <br>
 *         Restrictions: None
 */
public class PathMissile extends Missiles {

	//constructor that accesses the super class of missiles
	public PathMissile(int x, int y) {
		super(x, y);
	}

	//updates the missiles x value to fly in a straight line
	public void updateMissile() {
		if(x <= 0) {
			x = 1500;
			x-=speed;
		}
		x -= speed;
		
	}
}
