package mainApp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Winner extends JFrame {
	
	
	public Winner() {
		
		setTitle("Winner!");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel message = new JLabel("You Win! Try Again?");
		
		JPanel panel = new JPanel();
		panel.add(message);
		add(panel,BorderLayout.NORTH);
		
		JPanel panel2 = new JPanel();
		
        JButton exitButton = new JButton("Exit");
		panel2.add(exitButton, BorderLayout.EAST);
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
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
