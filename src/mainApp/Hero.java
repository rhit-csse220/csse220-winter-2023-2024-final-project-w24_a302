package mainApp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class: Hero
 * 
 * @author W24_A_302 <br>
 *         Purpose: Hero is used to draw the hero and also give the starting
 *         position of the hero on the level. It also handles the movement of
 *         the hero in the X and Y direction. <br>
 *         Restrictions: None
 */
public class Hero {
	protected int heroX;
	protected int heroY;
	protected int xSpeed;
	protected int ySpeed;
	protected Color heroColor = Color.CYAN;
	protected int heroLives;
	protected boolean isJumping = false;
	protected final int gravity = 0;
	File org = new File("ImageFolder/Hero_character.png");
	protected int coinCount;
	protected boolean isColliding = false;

	// Hero constructor with position and speed
	Hero(int x, int y, int speed) {
		this.heroX = x;
		this.heroY = y;
		this.xSpeed = speed;
		this.ySpeed = 10;
		this.heroLives = 3;
		this.isJumping = false;
		this.coinCount = 0;
		this.isColliding = false;

	}

	// Method used to draw the hero
	public void drawOn(Graphics2D g2) throws IOException {
		try {
			BufferedImage original = ImageIO.read(org);
			g2.drawImage(original, heroX, heroY, 50, 50, null);

		} catch (IOException e) {
			System.out.println(e.getMessage());
			Ellipse2D hero = new Ellipse2D.Double(heroX, heroY, 50, 50);
			g2.setColor(heroColor);
			g2.fill(hero);
		}
	}

	public void updateHero() {
		if (!isJumping) {
			falling();
		} else {
			moveUp();
		}
		sideMove();
	}

	// Method used to move the hero up and stop when it reaches the top of screen
	public void moveUp() {
		heroY -= ySpeed;

		// ySpeed -= gravity;

		if (heroY < 0) {
			heroY = 0;
			isJumping = false;
		}
	}

	public void falling() {
		// ySpeed += gravity;
		heroY += ySpeed;

		if (heroY > 700) {
			heroY = 700;
		}

	}

	// Method used to create horizontal movement as soon as hero spawns and has hero
	// stop when reach right side of the screen
	public void sideMove() {
		if (heroX >= 1435 - xSpeed) {
			heroX = 1435;
		} else {
			heroX = heroX + xSpeed;
		}
	}

	public void toggleJump(boolean jumping) {
		this.isJumping = jumping;
		if (jumping) {
			ySpeed = 1;
		}
	}

	public void updateCoinCount() {
		coinCount += 1;
	}

	public Rectangle getBox() {
		return new Rectangle(heroX, heroY, 50, 50);
	}

	public boolean heroHitsObjects(CollisionObjects object) {
		Rectangle heroBox = getBox();
		Rectangle objectBox = object.getBox();
		boolean collision = heroBox.intersects(objectBox);
		if (collision) {
			System.out.println("Collision detected with " + object.getClass().getSimpleName());
			setColliding(true);
		}
		return collision;

	}

	public boolean isColliding() {
		return isColliding;
	}

	public void setColliding(boolean colliding) {
		isColliding = colliding;

	}
	
	public int getX() {
		return heroX;
	}
	
	public int getY() {
		return heroY;
	}
}
