package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class PathMissile extends Missiles {

	public PathMissile(int x, int y) {
		super(x, y);
	}

	public void updateMissile() {
		if(x <= 0) {
			x = 1500;
			x-=speed;
		}
		x -= speed;
		
	}
	
	
	public Rectangle getBox() {
		return new Rectangle(x,y,10,50);
	}


	
}
