package mainApp;

import java.awt.Graphics2D;

public abstract class OtherObjects {
	protected int x;
	protected int y;
	
	public OtherObjects(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public abstract void drawOn(Graphics2D g2);
}
