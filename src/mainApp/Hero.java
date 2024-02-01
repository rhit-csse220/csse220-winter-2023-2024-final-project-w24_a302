package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class: Hero
 * @author W24_A_302
 * <br>Purpose: Hero is used to draw the hero and also give the starting position of the hero on the level.
 * 				It also handles the movement of the hero in the X and Y direction.
 * <br>Restrictions: None
 */
public class Hero {
	protected int heroX;
	protected int heroY;
	protected int xSpeed;
	protected int ySpeed;
	protected Color heroColor = Color.CYAN;
	protected int heroLives;
	protected boolean isJumping = false;
	protected final int Gravity = 1;
	File org = new File("ImageFolder/Hero_character.png");

	//Hero constructor with position and speed
	Hero(int x, int y, int speed) {
		this.heroX = x;
		this.heroY = y;
		this.xSpeed = speed;
		this.ySpeed = 20;
		this.heroLives = 3;

	}

	//Method used to draw the hero
	public void drawOn(Graphics2D g2) throws IOException {
		try {
			BufferedImage original = ImageIO.read(org);
			g2.drawImage(original, heroX, heroY, 50, 50, null);
		
		}
		 catch(IOException e) {
			System.out.println(e.getMessage()); 
			Ellipse2D hero = new Ellipse2D.Double(heroX, heroY, 50, 50);
			g2.setColor(heroColor);
			g2.fill(hero);
		}
	}

	//Method used to move the hero up and stop when it reaches the top of screen
	public void moveUp() {
		heroY -= ySpeed;
		if(heroY < 0) {
			heroY = 0;
		}
	}
	
	//Method used to create horizontal movement as soon as hero spawns and has hero stop when reach right side of the screen
	public void sideMove() {
		if (heroX >= 935 - xSpeed) {
			heroX = 935;
		} else {
			heroX = heroX + xSpeed;
		}
	}
}
