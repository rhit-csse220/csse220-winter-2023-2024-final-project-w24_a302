package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;

//TODO we should create a level loader method to implement the levels

public class MainAppComponent extends JComponent {
	protected Hero hero;
	protected ArrayList<Coin> coins;
	protected ArrayList<Barriers> Barriers;
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		Hero hero = new Hero(10,500,10);
		this.hero = hero;
		Coin coin1 = new Coin(600,600);
		Coin coin2 = new Coin(400,400);
		Coin coin3 = new Coin(500,500);
		hero.drawOn(g2);
	}
	public void update() {
		hero.update();		
	}
}
