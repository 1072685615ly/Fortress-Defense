package ca.cmpt213.as2.gameLogic;
import java.util.ArrayList;


/**
 * Enemy class is the information about all the tank cells
 * on the game board. Data includes the index of each tank
 * cell for each tank. It supports setting and returning its 
 * data to the calling method.
 */

public class Enemy {
	private static ArrayList<Integer> indices = new ArrayList<Integer>();
	private static ArrayList<Tank> tanks = new ArrayList<Tank>();
	private static ArrayList<Tetromino> tetrominos = new ArrayList<Tetromino>();
	
	public Enemy(){
		for (int i = 0; i < 100; i++) {
			indices.add(i);
		}
		getTanks();
	}

	public static int getDamagesOfAll(){
		int damage=0;
		for(int i = 0; i < tanks.size(); i++){
			Tank tank = tanks.get(i);
			damage = damage + tank.getDamage();
			
		}
		return damage;
	}

	private void getTanks(){
		for (int i = 0; i < 5; i++) {
			java.util.Collections.shuffle(indices);
			int location = indices.get(0);
			indices.remove(0);
			tetrominos.add(new Tetromino(location));
			tetrominos.get(i).generatorTetromino();
			ArrayList<Integer> indexes = tetrominos.get(i).getLocations();
			tanks.add(new Tank(indexes));
		}
	}
	
	public static ArrayList<Integer> getIndice() {
		return indices;
	}
}
