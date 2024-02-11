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
	File org = new File("ImageFolder/Hero_character.png");
	protected int coinCount;
	protected double fallTime;

	// Hero constructor with position and speed
	Hero(int x, int y, int speed) {
		this.heroX = x;
		this.heroY = y;
		this.xSpeed = speed;
		this.ySpeed = 10;
		this.heroLives = 3;
		this.isJumping = false;
		this.coinCount = 0;

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

	//updates hero depending on whether it is jumping or falling
	public void updateHero() {
		if (!isJumping) {
			this.fallTime += 0.01;
			falling();
		} else {
			moveUp();
		}
		sideMove();                       
	}

	// Method used to move the hero up and stop when it reaches the top of screen
	public void moveUp() {
		heroY -= ySpeed;

		if (heroY < 0) {
			heroY = 0;
			isJumping = false;
		}
	}

	//updates the heroY when it is falling and depending how much time it has been doing so
	public void falling() {
		heroY += Math.pow(2, fallTime);

		if (heroY > 710) {
			this.fallTime = 0;
			heroY = 710;
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

	//toggles when the hero is jumping or falling and sets the ySpeed if jumping
	public void toggleJump(boolean jumping) {
		this.isJumping = jumping;
		if (jumping) {
			this.fallTime = 0;
			ySpeed = 2;
		}
	}

	//updates the coin count to go +1 when prompted
	public void updateCoinCount() {
		coinCount += 1;
	}


	//gets the bounding box for the hero that is used for collisions
	public Rectangle getBox() {
		return new Rectangle(heroX, heroY, 50, 50);
	}

	//says whether the hero is hit by an objects and does the corresponding action for what the hero hit
	public boolean heroHitsObjects(CollisionObjects object) {
		Rectangle heroBox = getBox();
		Rectangle objectBox = object.getBox();
		boolean collision = heroBox.intersects(objectBox);
		if (collision) {
			System.out.println("Collision detected with " + object.getClass().getSimpleName());
		}
		return collision;
	}
	
	//determines whether the hero has been hit by a missile by comparing their hit boxes
	public boolean heroHitsMissile(Missiles missile) {
		Rectangle heroBox = getBox();
		Rectangle missileBox = missile.getBox();
		boolean collision = heroBox.intersects(missileBox);
		if (collision) {
			System.out.println("Collision detected with " + missile.getClass().getSimpleName());
		}
		return collision;
	}
	
	//returns the heroX value
	public int getX() {
		return heroX;
	}
	
	//returns the heroY value
	public int getY() {
		return heroY;
	}

}
