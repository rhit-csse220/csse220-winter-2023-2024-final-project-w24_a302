package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

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
			g2.setColor(chargeColor);
		} else {
			g2.setColor(blankColor);
		}
		g2.fill(bar);
		g2.rotate(-Math.toRadians(rotation), x + 5, y + 50);
	}

	@Override
	public void collisionWithHero(Hero hero) {
		// TODO Auto-generated method stub
		if (!hero.isColliding()) {
			Rectangle heroBox = hero.getBox();
			Rectangle objectBox = getBox();
			boolean collision = heroBox.intersects(objectBox);
			if(collision)
			hero.heroLives -= 1;
			if (hero.heroLives <= 0) {
				hero.heroLives = 0;
			}
			hero.setColliding(true);
		}
	}

	@Override
	public Rectangle getBox() {
		return new Rectangle(x, y, 10, 100);
	}
}
