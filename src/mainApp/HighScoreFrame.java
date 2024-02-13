package mainApp;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import mainApp.HighScoreManager.HighScoreEntry;

public class HighScoreFrame extends JFrame {
	private HighScoreManager highScoreManager;
	
	public HighScoreFrame(HighScoreManager highScoreManager) {
		this.highScoreManager = highScoreManager;
		setTitle("Highscores");
		setSize(400,300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		List<HighScoreEntry> scores = highScoreManager.getHighScores();
		JTextArea textArea = new JTextArea();
		for(int i = 0; i < scores.size(); i++) {
			HighScoreEntry curr = scores.get(i);
			String built = curr.getInitials().concat(":").concat(Integer.toString(curr.getScore()));
			textArea.append((i + 1) + ". " + built + "\n");
		}
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
