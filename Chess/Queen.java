import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;

public class Queen extends Piece {

	/**
	 * Default constructor- creates a white Queen
	 */
	public Queen() {
		super(true);
	}

	/**
	 * Modified constructor
	 */
	public Queen(boolean color) {
		super(color);
	}

	/**
	 * Move method
	 * Moves in a given direction a given number of spaces
	 * Can move in any direction
	 */
	public void move(String direct, int steps){
		
		int direction = super.setDirections(direct);
		
		super.move(direction, steps);
		super.capture(direction);
	}
	
	/**
	 * Capture method
	 * Can capture pieces in any direction
	 */
	private void capture(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		
		super.capture(direction);
	}
}
