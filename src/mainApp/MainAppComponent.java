package mainApp;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.util.ArrayList;

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
		hero = new Hero(10,700,5);
		}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
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
	}
	
	//Method used to add coins to level loader when level is made
	public void addCoin(String[] coinParts) {
		Coin coin = new Coin(Integer.parseInt(coinParts[1]), Integer.parseInt(coinParts[2]));
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
	
	//Method used to update the hero's Y position
	public void updateY() {
		hero.moveUp();
		repaint();
	}
	
	//Method used to update the hero's X position
	public void updateX() {
		hero.sideMove();
		repaint();
	}
	
}
