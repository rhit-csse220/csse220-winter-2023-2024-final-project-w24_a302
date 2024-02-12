package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class: GameOver
 * @author W24_A_302
 * <br>Purpose: Used to create a game over screen after the hero has lost all of their lives
 * <br>Restrictions: None
 */
public class GameOver extends JFrame {
	
	//constructor that displays the game over frame after the hero has lost all of their lives
	public GameOver() {
		
		setTitle("Game Over");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel message = new JLabel("Game Over - You Lost!");
		
		JPanel panel = new JPanel();
		panel.add(message);
		add(panel);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

}
