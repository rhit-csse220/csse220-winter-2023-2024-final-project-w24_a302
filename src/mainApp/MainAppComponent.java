package mainApp;

import java.awt.Color;
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
	public ArrayList<Missiles> missiles = new ArrayList<Missiles>();


	public MainAppComponent() {
		hero = new Hero(10,700,2);
		}
	
	public void checkForCollision() {
		ArrayList<CollisionObjects> clone = new ArrayList<>(objects);
		ArrayList<Missiles> cloneM = new ArrayList<>(missiles);
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
		
		for(Missiles missile: cloneM) {
			if(hero.heroHitsMissile(missile)) {
				missile.collisionWithHero(hero);
				missiles.remove(missile);
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
		for (Missiles missile : this.missiles) {
			missile.drawOn(g2);
			missile.updateMissile();
		}
		
		g2.setColor(Color.BLACK);
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
	
	//Method used to add path missiles to level loader when level is made
	public void addPathMissile(String[] pathMissileParts) {
		PathMissile missile = new PathMissile(Integer.parseInt(pathMissileParts[1]), Integer.parseInt(pathMissileParts[2]));
		missiles.add(missile);
	}
	
	//Method used to add tracking missiles to level loader when level is made
	public void addTrackMissile(String[] trackMissileParts) {
		TrackingMissile missile = new TrackingMissile(Integer.parseInt(trackMissileParts[1]), Integer.parseInt(trackMissileParts[2]), hero);
		missiles.add(missile);
	}
	
	
	//Update hero and checks for collision before repainting
	public void updateHero() {
		hero.updateHero();
		checkForCollision();
		repaint();
	}
	
	//toggles whether the character is jumping or falling
	public void toggleJump(boolean jumping) {
		hero.toggleJump(jumping);
	}
	
	//Removes a collision object when prompted
	public void removeCollisionObjects(CollisionObjects object) {
		objects.remove(object);
	}
	
	//check is the hero gets to the right side of the screen
	public boolean checkWinner() {
		if(hero.heroX >= 1435) {
			hero.heroX = 0;
			return true;
		}
		return false;
	}
	
	//sets the coins and lives for the hero
	public void setCoinAndLives(int lives, int coins) {
		hero.coinCount = coins;
		hero.heroLives = lives;
	}
	
	//gets the amount of coins that have been collected throughout the hero's journey
	public int getCoins() {
		return hero.coinCount;
	}
	
	//gets the amount of lives that the hero has left
	public int getLives() {
		return hero.heroLives;
	}
}
