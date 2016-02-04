package ca.cmpt213.as2.UI;
import java.util.Scanner;

/**
 * User class is the information about user input and the
 * fortress structure. Data includes condition of the fortress 
 * structure. It supports getting, translating user input string
 * to integer, verifying user input, and returning the data to 
 * the calling method in GameBoard class. 
 */

public class User {
	private int structure;
	private final int invalidNum = 101;

	public User() {
		structure = 1500;
	}

	public int getStructure() {
		return structure;
	}
	//check whether User is Lose
	public boolean isLose() {
		if (structure <= 0) {
			return true;
		}
		return false;
	}

	public int getInput() {
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			System.out.print("Enter your move: ");
			String userInput = scan.nextLine();
			
			if (userInput.length() == 2 || userInput.length() == 3) {
				if (stringToInt(userInput.substring(0, 1)) != 10) {
					try {
						
						int result = inputToInt(userInput);
						if (result < 100 && result >= 0) {
							return result;
						}
					} catch (NumberFormatException exception) {

					}
				}
			}
			System.out.println("Invalid target. Please enter a corrdinate such as D10.");
		}
	}

	public int setDamage(int damage) {
		structure -= damage;
		return structure;
	}

	private int stringToInt(String inputChar) {
		if (inputChar.toLowerCase().equals("a")) {
			return 0;
		} else if (inputChar.toLowerCase().equals("b")) {
			return 1;
		} else if (inputChar.toLowerCase().equals("c")) {
			return 2;
		} else if (inputChar.toLowerCase().equals("d")) {
			return 3;
		} else if (inputChar.toLowerCase().equals("e")) {
			return 4;
		} else if (inputChar.toLowerCase().equals("f")) {
			return 5;
		} else if (inputChar.toLowerCase().equals("g")) {
			return 6;
		} else if (inputChar.toLowerCase().equals("h")) {
			return 7;
		} else if (inputChar.toLowerCase().equals("i")) {
			return 8;
		} else if (inputChar.toLowerCase().equals("j")) {
			return 9;
		} else {
			return 10;// wrong type
		}
	}

	private int inputToInt(String userInput) {
		String firstLetter = userInput.substring(0, 1);

		String secondLetter = userInput.substring(1);

		int col = Integer.parseInt(secondLetter);
		if (col >= 11 || col < 1) { 
			return invalidNum;
		}
		int row = stringToInt(firstLetter);
		int result = row * 10 + col - 1;
		return result;

	}
}
