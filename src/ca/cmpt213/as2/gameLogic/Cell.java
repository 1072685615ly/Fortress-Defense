package ca.cmpt213.as2.gameLogic;

/**
 * Cell class is the information about each cell on 
 * the game board. Data includes the state of a cell;
 * that is, whether it is a tank cell and whether it 
 * has been hit. It supports setting and returning its 
 * data to the calling method.
 */

public class Cell {
	private boolean isTank;
	private boolean isSelected;
	
	public Cell(){
		isTank=false;
		isSelected=false;
	}
	public void setIsSelected(){
		isSelected=true;
	}
	public boolean getIsSelected(){
		return isSelected;
	}
	public void setIsTank(){

		isTank=true;
	}
	public boolean getIsTank(){
		return isTank;
	}
	
}
