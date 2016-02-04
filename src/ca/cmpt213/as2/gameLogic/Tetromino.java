package ca.cmpt213.as2.gameLogic;
import java.util.ArrayList;

/**
 * Tetromino class generates Tetromino shape for each tank called it.
 * Data includes the four sides of a cell, the boarder row and column of
 * the game board, the number of undamaged cells, and the index of each tank
 * cell. It supports setting and returning the indices of each tan cell to 
 * the calling method in Tank class.
 */

import ca.cmpt213.as2.UI.GameBoard;

/**
 * Tetromino class generates Tetromino shape for each tank
 * on the game board. Data includes the four sides of a cell,
 * the boarder row and column of the game board, the index of
 * each tank cell. It supports returning the index of each tank 
 * cell to the calling method.
 */

public class Tetromino {
	private final int UP = 0;
	private final int DOWN = 1;
	private final int LEFT = 2;
	private final int RIGHT = 3;
	private final int RIGHTEST_COL = 0;
	private final int LEFTEST_COL = 9;
	private final int TOP_ROW = 10;
	private final int BOTTOM_ROW = 90;
	private final int NUM_ROWS = 10;
	private int location;
	private ArrayList<Cell> allCells = GameBoard.getCell();
	private ArrayList<Integer> locations = new ArrayList<Integer>();
	private ArrayList<Integer> indices = Enemy.getIndice();

	public Tetromino(int location) {
		this.location = location;

		locations.add(location);
		allCells.get(location).setIsTank();
		
	}
	//get the tetromino shape
	public void generatorTetromino() {
		while (locations.size() < 4) {
			addCellsToTank(location);
			java.util.Collections.shuffle(locations);
			location = locations.get(0);
		}
	}
	public ArrayList<Integer> getLocations(){
		return locations;
	}
	private void addCellsToTank(int index) {
		ArrayList<Integer> directions = new ArrayList<Integer>();
		for (int i = 0; i < 4; i++) {
			directions.add(i);
		}
		//check whether we can add tank to cell until find one cell or all direction can't add.
		while (directions.size() > 0) {
			java.util.Collections.shuffle(directions);
			int direction = directions.get(0);

			if (direction == UP) {
				if (checkUp(index)) {
					break;
				} else {
					directions.remove(0);
				}

			} else if (direction == DOWN) {
				if (checkDown(index)) {
					break;
				} else {
					directions.remove(0);
				}

			} else if (direction == LEFT) {
				if (checkLeft(index)) {
					break;
				} else {
					directions.remove(0);
				}

			} else if (direction == RIGHT) {
				if (checkRight(index)) {
					break;
				} else {
					directions.remove(0);
				}
			}

		}
	}

	private boolean checkIsTank(int location) {
		if (!allCells.get(location).getIsTank()) {
			allCells.get(location).setIsTank();
			locations.add(location);
			int l = indices.indexOf(location);
			indices.remove(l);
			return true;
		}
		return false;
	}

	// check left whether can add cells
	private boolean checkLeft(int index) {
		if (index % NUM_ROWS != RIGHTEST_COL) { 
			int location = index - 1;
			if (checkIsTank(location)) {
				return true;
			}
		}
		return false;
	}

	// check Right whether can add cells
	private boolean checkRight(int index) {
		if (index % NUM_ROWS != LEFTEST_COL) { 
			int location = index + 1;
			if (checkIsTank(location)) {
				return true;
			}
		}
		return false;
	}

	// check down whether can add cells
	private boolean checkDown(int index) {
		if (index < BOTTOM_ROW) { 
			int location = index + 10;
			if (checkIsTank(location)) {
				return true;
			}
		}
		return false;
	}

	// check up whether can add cells
	private boolean checkUp(int index) {
		if (index >= TOP_ROW) { 
			int location = index - 10;
			if (checkIsTank(location)) {
				return true;
			}
		}
		return false;
	}

}
