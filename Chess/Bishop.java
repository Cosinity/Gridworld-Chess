import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;

public class Bishop extends Piece {

	/**
	 * Default constructor- makes a white Bishop
	 */
	public Bishop() {
		super(true);
	}

	/**
	 * Modified constructor
	 */
	public Bishop(boolean color) {
		super(color);
	}

	/**
	 * Move method
	 * Moves in a given direction a given number of spaces
	 * Can only move on diagonals
	 */
	public void move(String direct, int steps){
		
		int direction = super.setDirections(direct);
		
		if ((direction % 90) != 0){
			super.move(direction, steps);
			super.capture(direction);
		}
	}
	
	/**
	 * Capture method
	 * Can only capture pieces diagonal relative to itself
	 */
	private void capture(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		
		if ((direction % 90 != 0))
			super.capture(direction);
	}
}
