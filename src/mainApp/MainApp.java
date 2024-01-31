package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

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
	
	final String frameTitle = "Graphics Display";
    final int frameWidth = 1000;
    final int frameHeight = 600;
    final int frameXLoc = 100;
    final int frameYLoc = 100;
    
	private void runApp() {
		Scanner s = new Scanner(System.in);
		String filename = null;
		while(true) {
			try {
				System.out.println("What level should I load?  (e.g. levelN.txt)");
				filename = s.next();
				runGame(filename);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("File " + filename + " does not exist.  Please try again.");
			}
		}
	}// runApp	
	
	private void runGame(String fileName) throws FileNotFoundException{
		FileReader file = new FileReader(fileName);
		Scanner s = new Scanner(file);
		
	    JFrame frame = new JFrame();
	    frame.setTitle(frameTitle);
	    frame.setSize(frameWidth, frameHeight);
	    frame.setLocation(frameXLoc, frameYLoc);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
        MainAppComponent mainAppComponent = new MainAppComponent();
        frame.add(mainAppComponent);
        
        while(s.hasNext()) {
			String[] level = s.nextLine().split(",");
			if(level[0].equals("coin")) {
				mainAppComponent.addCoin(level);
			}
		}
        
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
	}

	/**
	 * ensures: runs the application
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp();		
	} // main

}