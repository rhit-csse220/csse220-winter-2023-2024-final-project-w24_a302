package mainApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class HighScoreManager {
	private static final String HIGH_SCORE_FILE = "src/mainApp/highscores.txt";
	private List<HighScoreEntry> highScores;
	private static final int maxHighscores = 5;
	
	
	public HighScoreManager() {
		highScores = new ArrayList<HighScoreEntry>();
		loadHighScores();
	}
	
	private void loadHighScores() {
		BufferedReader reader = null;
		String line = null;
		try {
			reader = new BufferedReader(new FileReader(HIGH_SCORE_FILE));
			System.out.println(reader.ready());
			while((line = reader.readLine()) != null) {
				String[] parts = line.split(",(?=\\d)");
		        String stringPart = parts[0];
		        int integerPart = Integer.parseInt(parts[1]);		  
		        HighScoreEntry scoreEntry = new HighScoreEntry(stringPart, integerPart);
				highScores.add(scoreEntry);
			}
			reader.close();
			} catch(IOException e) {
			System.out.println("Something bad happened" + e.getMessage());
		} 	
	}
	
	public void saveHighScores() {
		BufferedWriter writer = null;
		int bound = Math.min(maxHighscores, highScores.size());
		try {
			writer = new BufferedWriter(new FileWriter(HIGH_SCORE_FILE, false));
			for(int i = 0; i < bound; i++) {
				HighScoreEntry curr = highScores.get(i);
				String built = curr.getInitials().concat(",").concat(Integer.toString(curr.getScore()));
				writer.write(built);
				writer.newLine();
			}
			writer.close();
		} catch(IOException e) {
			System.out.printf("Error writing score to file: %s\n", e);
		}
		
	}
	
	public void addScore(String initials, int score) {
		HighScoreEntry scoreEntry = new HighScoreEntry(initials, score);
		highScores.add(scoreEntry);
		Collections.sort(highScores);
		saveHighScores();
	}
	
	public List<HighScoreEntry> getHighScores() {
		return highScores;
	}
	
	class HighScoreEntry implements Comparable<HighScoreEntry> {
	    private String initials;
	    private int score;

	    public HighScoreEntry(String initials, int score) {
	        this.initials = initials;
	        this.score = score;
	    }

	    public String getInitials() {
	        return initials;
	    }

	    public int getScore() {
	        return score;
	    }

	    @Override
	    public int compareTo(HighScoreEntry other) {
	        return Integer.compare(score, other.score);
	    }
	}

}
