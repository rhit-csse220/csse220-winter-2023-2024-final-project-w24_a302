package mainApp;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JComponent;

/**
 * Class: MainAppComponent
 * @author W24_A_302
 * <br>Purpose: MainAppComponent used to handle user input and level aspects for the game. 
 * 				It extends the JComponent class to provide a graphical user interface.
 * <br>Restrictions: None
 */
public class MainAppComponent extends JComponent {
	Hero hero;
	public ArrayList<CollisionObjects> objects = new ArrayList<CollisionObjects>();


	public MainAppComponent() {
		hero = new Hero(10,700,1);
		}
	
	public void checkForCollision() {
		ArrayList<CollisionObjects> clone = new ArrayList<>(objects);
		for(CollisionObjects object : clone) {
			if(hero.heroHitsObjects(object)) {
				if(object.isCoin) {
					object.collisionWithHero(hero);
					objects.remove(object);
				} else {
					object.collisionWithHero(hero);
				}
			}
		}
		
	}
		
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		updateHero();
        try {
		hero.drawOn(g2);
		repaint();
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (CollisionObjects o: this.objects) {
			o.drawOn(g2);
		}
		
		g2.setFont(new Font("Arial", Font.BOLD, 16));
		g2.drawString("Coins: " + hero.coinCount, getWidth() - 100, 20);
		g2.drawString("Lives: " + hero.heroLives, getWidth() - 100, 40);
	}
	
	//Method used to add coins to level loader when level is made
	public void addCoin(String[] coinParts) {
		Coin coin = new Coin(Integer.parseInt(coinParts[1]), Integer.parseInt(coinParts[2]));
		coin.setMainAppComponent(this);
		objects.add(coin);
	}
	
	//Method used to add electrified and non-electrified barriers to level loader when level is made
	public void addBar(String[] barParts) {
		boolean boo;
		if(barParts[4].equals("true")) {
			boo = true;
		}
		else{
			boo = false;
		}
		Barriers bar = new Barriers(Integer.parseInt(barParts[1]), Integer.parseInt(barParts[2]), Integer.parseInt(barParts[3]), boo);
		objects.add(bar);
	}
	
	
	public void updateHero() {
		hero.updateHero();
		checkForCollision();
		repaint();
	}
	
	public void toggleJump(boolean jumping) {
		hero.toggleJump(jumping);
	}
	
	public void removeCollisionObjects(CollisionObjects object) {
		objects.remove(object);
	}
}
