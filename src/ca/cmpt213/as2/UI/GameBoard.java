package ca.cmpt213.as2.UI;
import java.util.ArrayList;

import ca.cmpt213.as2.gameLogic.Cell;
import ca.cmpt213.as2.gameLogic.Enemy;

/**
 * GameBoard class models the behavior of Fortress Defense Game, 
 * which users enter a target cell, see if the shot is a hit or 
 * miss, and how defensive fortress structure is by using User
 * class and Cell class. It supports displaying the game board, 
 * the result of each user's shooting.
 */

public class GameBoard {
	private static ArrayList<Cell> cells = new ArrayList<Cell>();

	public static void main(String[] args) {
	
		for (int i = 0; i < 100; i++) {
			cells.add(new Cell());
		}
		gameStart();

	}

	private static void gameStart() {
		Enemy enemy = new Enemy();
		User user = new User();
		int damage;
		System.out.println("----------------------------");
		System.out.println("Welcome to Fortress Defense!");
		System.out.println("by Kathy Cheng & Sunny Luo");
		System.out.println("----------------------------");
		while (!user.isLose()) {
			drawBorad();
			System.out.println("Fortress Structure Left: " + user.getStructure());
			int userInput = user.getInput();
			cells.get(userInput).setIsSelected();
			checkHit(userInput);
			damage = enemy.getDamagesOfAll();
			if (damage == 0) {
				break;
			}
			user.setDamage(damage);

		}
		// if the user wins
		if (!user.isLose()) {
			drawBorad();
			System.out.println("Fortress Structure Left: " + user.getStructure());
			System.out.println("Congratulations! You won!");
		} else {
			lose();
		}

	}
	private static void lose(){
		drawBorad();
		System.out.println("Fortress Structure Left: 0.");
		System.out.println("I'm sorry, your fortress has been smashed!\n");
		System.out.println("Game Board:");
		for (int i = 0; i < 11; i++) {
			if (i == 0) {
				System.out.print("      ");
			} else {
				System.out.print(" " + i + " ");
			}
		}
		System.out.println();

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 11; col++) {
				if (col == 0) {
					System.out.print("    " + changeIntToChar(row) + " ");
				} else {
					int number = row * 10 + col - 1; 
					Cell cell = cells.get(number);
					if (cell.getIsSelected() && (!cells.get(number).getIsTank())) {
						System.out.print(" . "); 
					} else if(!cells.get(number).getIsTank()) {
						System.out.print("   ");
					}else{
						System.out.print(" X ");
					}
				}
			}
			System.out.println();
		}
		System.out.println("Fortress Structure Left: 0.");
	}

	private static void drawBorad() {
		System.out.println("\nGame Board:");
		for (int i = 0; i < 11; i++) {
			if (i == 0) {
				System.out.print("      ");
			} else {
				System.out.print(" " + i + " ");
			}
		}
		System.out.println();

		for (int row = 0; row < 10; row++) {
			for (int col = 0; col < 11; col++) {
				if (col == 0) {
					System.out.print("    " + changeIntToChar(row) + " ");
				} else {
					int index = row * 10 + col - 1;
					Cell c = cells.get(index);
					if (c.getIsSelected()) {
						if (cells.get(index).getIsTank()) {
							System.out.print(" X ");
						} else {
							System.out.print(" . ");
						}
					} else {
						System.out.print(" ~ ");
					}
				}
			}
			System.out.println();

		}
	}

	private static boolean checkHit(int index) {
		Cell cell = cells.get(index);
		boolean hit = cell.getIsTank();
		if (hit) {
			System.out.println("Hit!");
		} else {
			System.out.println("Miss.");
		}
		return hit;
	}

	private static char changeIntToChar(int inputInteger) {
		if (inputInteger == 0) {
			return 'A';
		} else if (inputInteger == 1) {
			return 'B';
		} else if (inputInteger == 2) {
			return 'C';
		} else if (inputInteger == 3) {
			return 'D';
		} else if (inputInteger == 4) {
			return 'E';
		} else if (inputInteger == 5) {
			return 'F';
		} else if (inputInteger == 6) {
			return 'G';
		} else if (inputInteger == 7) {
			return 'H';
		} else if (inputInteger == 8) {
			return 'I';
		} else if (inputInteger == 9) {
			return 'J';
		} else {
			return ' ';
		}
	}

	public static ArrayList<Cell> getCell() {
		return cells;
	}

}
