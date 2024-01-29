package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.Timer;

/**
 * Class: MainApp
 * @author Put your team name here
 * <br>Purpose: Top level class for CSSE220 Project containing main methods
 * <br>Restrictions: None
 */
public class MainApp {
	
	
	private void runApp() {
		final String frameTitle = "Graphics Display";
        final int frameWidth = 1000;
        final int frameHeight = 600;
        final int frameXLoc = 100;
        final int frameYLoc = 100;

        JFrame frame = new JFrame();
        frame.setTitle(frameTitle);
        frame.setSize(frameWidth, frameHeight);
        frame.setLocation(frameXLoc, frameYLoc);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainAppComponent mainAppComponent = new MainAppComponent();
        frame.add(mainAppComponent);
        
        Timer t = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mainAppComponent.update();
				mainAppComponent.repaint();
				frame.repaint();
			}
		});
		t.start();

        frame.setVisible(true);
    }// runApp

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}