package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * Class: Winner
 * @author W24_A_302
 * <br>Purpose: Winner is used to create the winner frame and give the user to
 * 				either exit or start over.
 * <br>Restrictions: None
 */
public class Winner extends JFrame {
	
	//Constructor for the winner class
	public Winner() {
		
		setTitle("Winner!");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel message = new JLabel("You Win! Try Again?");
		
		JPanel panel = new JPanel();
		panel.add(message);
		add(panel,BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		
		//Exit button
        JButton exitButton = new JButton("Exit");
		panel2.add(exitButton, BorderLayout.EAST);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Start button
        JButton startButton = new JButton("Start Over");
		panel2.add(startButton, BorderLayout.WEST);
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				MainApp.main(null);
				setVisible(false);
			}
		});
		
		add(panel2,BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
