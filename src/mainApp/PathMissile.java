package mainApp;

import java.awt.Rectangle;

public class PathMissile extends Missiles {
	private int x;
	private int y;
	private int speed;


	public PathMissile(int x, int y, int speed) {
		super(x, y, speed);
		this.x = x;
		this.y = y;
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		x -= speed;
		
	}
	
	public Rectangle getBox() {
		return new Rectangle(x,y,10,50);
	}

}
