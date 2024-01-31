package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JComponent;



//TODO we should create a level loader method to implement the levels

public class MainAppComponent extends JComponent {
	Hero hero;
	public ArrayList<Coin> coins = new ArrayList<Coin>();
	//public ArrayList<Barriers> Barriers;
	
	public MainAppComponent() {
		hero = new Hero(10,500,5);
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        hero.drawOn(g2);
		for (Coin c: this.coins) {
			c.drawOn(g2);
		}	
	}
	
	public void addCoin(String[] coinParts) {
		Coin coin = new Coin(Integer.parseInt(coinParts[1]), Integer.parseInt(coinParts[2]));
		coins.add(coin);
	}
	
	public void update() {
		hero.heroX = hero.heroX + hero.xSpeed;
	}
}
