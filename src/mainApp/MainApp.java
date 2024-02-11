 package mainApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 * Class: MainApp
 * 
 * @author W24_A_302 <br>
 *         Purpose: top level class for CSSE220 Project containing main methods
 *         <br>
 *         Restrictions: None
 */
public class MainApp {

	final String frameTitle = "Graphics Display";
	final int frameWidth = 1500;
	final int frameHeight = 800;
	// final int frameXLoc = 100;
	// final int frameYLoc = 100;

	// Runs the app and gives a message if there is no level or wrong format then
	// returns to level 1
	private void runApp(int levelNumb, int lives, int coins) {
		String filename = "level" + levelNumb + ".txt";
		while (true) {
			try {
				runGame(filename, levelNumb, lives, coins);
				break;
			} catch (FileNotFoundException e) {
				System.out.println("Level " + (levelNumb) + " does not exist. Going back to level 1");
				filename = "level1.txt";
				levelNumb = 1;
				coins = 0;
			} catch (InvalidLevelFormatException e) {
				System.out.println(e.getMessage());
				filename = "level1.txt";
				levelNumb = 1;
				lives = 3;
				coins = 0;
			}
		}
	}// runApp

	// Method used to run the game when given a fileName and levelNumb
	private void runGame(String fileName, int levelNumb, int lives, int coins) throws FileNotFoundException, InvalidLevelFormatException{
	    JFrame frame = new JFrame();
	    frame.setTitle(frameTitle);
	    frame.setSize(frameWidth, frameHeight);
	   // frame.setLocation(frameXLoc, frameYLoc);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
		FileReader file = new FileReader(fileName);
		Scanner s = new Scanner(file);
		
	    //Creates the level based off of which text file is loaded in
        MainAppComponent mainAppComponent = new MainAppComponent();
        frame.add(mainAppComponent);
        
        mainAppComponent.setCoinAndLives(lives, coins);
        
        while(s.hasNext()) {
			String[] level = s.nextLine().split(",");
			if(level[0].equals("coin")) {
				if(level.length != 3) {
					throw new InvalidLevelFormatException(level[0]);
				}
				for (int j = 1; j < 3; j++) {
					try {
				        Integer.parseInt(level[j]);
				    } catch (NumberFormatException e) {
				        throw new InvalidLevelFormatException(level[0]);
				    }
				}
				mainAppComponent.addCoin(level);
			}
			else if(level[0].equals("barrier")) {
				if(level.length != 5) {
					throw new InvalidLevelFormatException(level[0]);
				}
				for (int j = 1; j < 4; j++) {
					try {
				        Integer.parseInt(level[j]);
				    } catch (NumberFormatException e) {
				        throw new InvalidLevelFormatException(level[0]);
				    }
					if(level[4].equals("true")) {}
					else if(level[4].equals("false")){}
					else {
						throw new InvalidLevelFormatException(level[0]);
					}
				}
				
				mainAppComponent.addBar(level);
			}
			else if(level[0].equals("pathmissile")) {
				if(level.length != 3) {
					throw new InvalidLevelFormatException(level[0]);
				}
				for(int j = 1; j < 3; j++) {
					try {
						Integer.parseInt(level[j]);
					} catch (NumberFormatException e) {
						throw new InvalidLevelFormatException(level[0]);
					}
				}
				mainAppComponent.addPathMissile(level);
			}
			else if(level[0].equals("trackmissile")) {
				if(level.length != 3) {
					throw new InvalidLevelFormatException(level[0]);
				}
				for(int j = 1; j < 3; j++) {
					try {
						Integer.parseInt(level[j]);
					} catch (NumberFormatException e) {
						throw new InvalidLevelFormatException(level[0]);
					}
				}
				mainAppComponent.addTrackMissile(level);
			}
		}
        
        frame.addKeyListener(new KeyListener() {
	        @Override
	        public void keyTyped(KeyEvent e) {
	        }
	        //Switches between levels using U key and D key and uses spacebar to move hero up
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	if(e.getKeyCode()==85) {
	        		frame.dispose();
	        		runApp(levelNumb+1, mainAppComponent.getLives(), mainAppComponent.getCoins());
	        	}
	        	if(e.getKeyCode()==68) {
	        		frame.dispose();
	        		runApp(levelNumb-1, mainAppComponent.getLives(), mainAppComponent.getCoins());
	        	}
	        	if(e.getKeyCode()==32) {
	        		mainAppComponent.updateHero();
	        		mainAppComponent.toggleJump(true);
	        	}
	        }

	        @Override
	        public void keyReleased(KeyEvent e) {
	        	if(e.getKeyCode() == 32) {  
	        		mainAppComponent.updateHero();
	        		mainAppComponent.toggleJump(false);
	        	}
	        }
	    });
        
        
        //Timer used to control the x position of the hero
		Timer t = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(mainAppComponent.checkWinner()) {
					frame.dispose();
					runApp(levelNumb+1, mainAppComponent.getLives(), mainAppComponent.getCoins());
				}
				else if(mainAppComponent.checkLoser()) {
					frame.dispose();
					new GameOver();
					
				}
				else {
					mainAppComponent.updateHero();
					mainAppComponent.repaint();
					frame.repaint();
				}
			}
		});
		t.start();
        frame.setVisible(true);
	}

	/**
	 * ensures: runs the application
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		MainApp mainApp = new MainApp();
		mainApp.runApp(1,3,0);
	} // main

}