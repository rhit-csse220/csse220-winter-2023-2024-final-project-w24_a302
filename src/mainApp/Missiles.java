package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * Class: Missiles
 * 
 * @author W24_A_302 <br>
 *         Purpose: Abstract class that contains data and functions for both 
 *         tracking and path missiles <br>
 *         Restrictions: None
 */
public abstract class Missiles {
	protected int speed;
	protected Color missileColor = Color.RED;
	protected int x;
	protected int y;
	File org = new File("ImageFolder/Missile.png");

	//Constructor that sets variable values
	public Missiles(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.speed = 5;
	}
	
	//abstract function that the subclasses will have to implement
	public abstract void updateMissile();
	
	//draws any missile's onto the screen when given the needed x and y values that are stored
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
		

		

	public Rectangle getBox() {
		return new Rectangle(x, y, 50, 10);
	}
	
	public void collisionWithHero(Hero hero) {
		hero.heroLives--;
		hero.heroX = 10;
		hero.heroY = 710;
	}

}
