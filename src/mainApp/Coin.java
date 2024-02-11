package mainApp;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

/**
 * Class: Coin
 * @author W24_A_302
 * <br>Purpose: Coin is used to set position of coins and draws the coins. This class extends the OtherObects class.
 * <br>Restrictions: None
 */
public class Coin extends CollisionObjects{
	protected Color coinColor = Color.YELLOW;
	
	//Constructor setting the position
	Coin(int x, int y){
		super(x,y,true);
	}
	
	//Method used to draw the coin when called
	@Override
	public void drawOn(Graphics2D g2) {
        Ellipse2D coin = new Ellipse2D.Double(x, y, 25, 25);
        g2.setColor(coinColor);
        g2.fill(coin);
    }

	//updates the coin count if the coin collides with the hero
	@Override
	public void collisionWithHero(Hero hero) {
		hero.updateCoinCount();		
	}
	
	//gets the bounding box for the given coin
	public Rectangle getBox() {
		return new Rectangle(x, y, 25, 25);
	}
	
}
