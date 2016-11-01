import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;

public class Rook extends Piece {
	
	private boolean hasMoved;
	
	/**
	 * Default constructor- creates a white Rook
	 */
	public Rook(){
		super(true);
		hasMoved = false;
	}
	
	/**
	 * Modified constructor
	 */
	public Rook(boolean color){
		super(color);
		hasMoved = false;
	}
	
	/**
	 * Move method
	 * Moves in a given direction a given number of spaces
	 * Can only move up, down, left, or right
	 */
	public void move(String direct, int steps){
		
		int direction = super.setDirections(direct);
		
		if ((direction % 90) == 0){
			super.move(direction, steps);
			super.capture(direction);
		}
		
		hasMoved = true;
	}
	
	/**
	 * Capture method
	 * Can only capture pieces above, below, to the left, or to the right
	 * of itself
	 */
	private void capture(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		
		if ((direction % 90 == 0))
			super.capture(direction);
		
		hasMoved = true;
	}
	
	public boolean canCastle(){
		if (!hasMoved)
			return true;
		else
			return false;
	}
	

}
