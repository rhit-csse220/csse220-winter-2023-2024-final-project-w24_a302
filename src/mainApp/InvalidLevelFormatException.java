package mainApp;

public class InvalidLevelFormatException extends Exception {
	
	private String error;
	
	public InvalidLevelFormatException(String error) {
		this.error = error;
	}
	
	@Override
	public String getMessage() {
		if(error.equals("coin")) {
			return "'coin' requires exactly 2 integers. Going back to level 1";
		}
		else if(error.equals("barrier")) {
			return "'barriers' requires exactly 3 integers, followed by 1 boolean. Going back to level 1";
		}
		else {
			return "Class '"+ error + "' does not exist. Going back to level 1";
		}
	}
}
