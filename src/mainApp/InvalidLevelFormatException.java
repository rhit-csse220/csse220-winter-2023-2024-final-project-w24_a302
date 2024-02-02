package mainApp;

/**
 * Class: InvalidLevelFormatException
 * @author W24_A_302
 * <br>Purpose: Used to create an Exception when there is an Invalid Level Format
 * <br>Restrictions: None
 */
public class InvalidLevelFormatException extends Exception {
	
	private String error;
	
	//Constructor to make an error
	public InvalidLevelFormatException(String error) {
		this.error = error;
	}
	
	//Method used to give message for specific invalid level format
	@Override
	public String getMessage() {
		if(error.equals("coin")) {
			return "'coin' requires exactly 2 integers. Going back to level 1";
		}
		else if(error.equals("barrier")) {
			return "'barriers' requires exactly 3 integers, followed by 1 boolean. Going back to level 1";
		}
		else if(error.equals("pathmissile")) {
			return "'pathmissile' requires exactly 3 integers. Going back to level 1";
		}
		else {
			return "Class '"+ error + "' does not exist. Going back to level 1";
		}
	}
}
