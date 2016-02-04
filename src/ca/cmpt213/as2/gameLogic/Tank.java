package ca.cmpt213.as2.gameLogic;
import java.util.ArrayList;

import ca.cmpt213.as2.UI.GameBoard;

/**
 * Tank class is the information about all the tank cells of a tank.
 * Data includes the index of each tank cell, the number of undamaged 
 * cells, state of the tank, and condition of each cell on the board 
 * by using the GameBoard class. It supports setting and returning its
 * data to the calling method in Enemy class.
 */

public class Tank {
	private int undamageCell;
	private ArrayList<Integer> cells;
	private boolean die;
	private ArrayList<Cell> allCells = GameBoard.getCell();
	ArrayList<Integer> indices = new ArrayList<Integer>();

	public Tank(ArrayList<Integer> cells){
		this.cells = cells;
		undamageCell = 4;
		die = false;
	}
	public boolean isDie(){
		return die;
	}
	private int getUndamageCell(){
		int damageCell = 0;
		for(int i = 0; i < cells.size(); i++){
			int index = cells.get(i);
			if(allCells.get(index).getIsSelected()){
				damageCell++;
			}
		}
		undamageCell = 4 - damageCell;
		return undamageCell;
	}
	public int getDamage(){
		int damage = getUndamageCell();
		if(undamageCell == 4){
			damage = 20;
		}else if(undamageCell == 3){
			damage = 5;
		}else if(undamageCell == 2){
			damage = 2;
		}else if(undamageCell==1){
			damage = 1;
		}else{
			damage = 0;
		}
		if(damage!=0){
			System.out.println("You were shot for " + damage + "!");
		}
		
		return damage;
	}
		
}
