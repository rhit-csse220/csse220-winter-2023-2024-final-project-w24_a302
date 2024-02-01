package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JComponent;


public class MainAppComponent extends JComponent {
	Hero hero;
	public ArrayList<OtherObjects> objects = new ArrayList<OtherObjects>();

	public MainAppComponent() {
		hero = new Hero(10,500,5);
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
        hero.drawOn(g2);
		for (OtherObjects o: this.objects) {
			o.drawOn(g2);
		}		
	}
	
	public void addCoin(String[] coinParts) {
		Coin coin = new Coin(Integer.parseInt(coinParts[1]), Integer.parseInt(coinParts[2]));
		objects.add(coin);
	}
	
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
	
	public void updateY() {
		hero.moveUp();
		repaint();
	}
	
	public void updateX() {
		hero.sideMove();
		repaint();
	}
	
}
