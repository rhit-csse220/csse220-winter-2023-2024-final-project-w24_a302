package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JFrame {
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
