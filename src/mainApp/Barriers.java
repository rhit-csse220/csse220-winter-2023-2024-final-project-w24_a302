package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Class: Barriers
 * 
 * @author W24_A_302 <br>
 *         Purpose: Barriers is used to set position of barriers and draw
 *         barriers. This class extends the OtherObjects class <br>
 *         Restrictions: None
 */
class Barriers extends CollisionObjects {
	protected int rotation;
	protected boolean isCharged;
	protected Color blankColor = Color.GRAY;
	protected Color chargeColor = Color.ORANGE;
	File org = new File("ImageFolder/barrier_electric.png");

	// Constructor setting the position, rotation, and if the barrier is electrified
	Barriers(int x, int y, int rotation, boolean isCharged) {
		super(x, y, false);
		this.rotation = rotation;
		this.isCharged = isCharged;
	}

	// Method used to draw the barrier when called
	@Override
	public void drawOn(Graphics2D g2) {
		g2.rotate(Math.toRadians(rotation), x + 5, y + 50);
		Rectangle bar = new Rectangle(x, y, 10, 100);
		if (isCharged) {
			try {
				BufferedImage original = ImageIO.read(org);
				g2.drawImage(original, x, y, 10, 100, null);

			} catch (IOException e) {
				System.out.println(e.getMessage());
				g2.setColor(chargeColor);
				g2.fill(bar);
			}
		} else {
			g2.setColor(blankColor);
			g2.fill(bar);
		}
		g2.rotate(-Math.toRadians(rotation), x + 5, y + 50);
	}

	//removes a life if the hero collides with the barrier
	@Override
	public void collisionWithHero(Hero hero) {
		if(!isCharged) {
			
			
			Rectangle heroBox = hero.getBox();
			Rectangle barrier = getBox();
			if(heroBox.intersects(barrier)) {
				hero.setColliding(true);
			}
			hero.setColliding(false);
		}
	}

	//gets the bounding box for the given barrier
	@Override
	public Rectangle getBox() {
		return new Rectangle(x, y, 10, 100);
	}
}
