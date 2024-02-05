package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class Missiles {
	protected int speed;
	protected Color missileColor = Color.RED;
	protected int x;
	protected int y;
	File org = new File("ImageFolder/Missile.png");

	public Missiles(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.speed = 5;
		// TODO Auto-generated constructor stub
	}
	
	public abstract void updateMissile();
	
	public void drawOn(Graphics2D g2) {
		try {
			BufferedImage original = ImageIO.read(org);
			g2.drawImage(original, x, y, 50, 10, null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			Rectangle missile = new Rectangle(x, y, 50, 10);
			g2.setColor(missileColor);
			g2.fill(missile);
			g2.setColor(Color.BLACK);
			
		}
	}
		

		

	public abstract Rectangle getBox();

}
