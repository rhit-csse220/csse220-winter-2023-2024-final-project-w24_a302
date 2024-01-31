package mainApp;

public class InvalidLevelFormatException extends Exception {
	
	private int actual, allowed;
	
	public InvalidLevelFormatException(int actual, int allowed) {
		this.actual = actual;
		
	}
	@Override
	public String getMessage() {
		int tooManyNumber = this.actual - this.allowed;
		return tooManyNumber + " too many scores. ";
	}
}
