import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Pawn extends Piece {
	
	//To determine if the pawn has moved yet
	private boolean hasMoved;
	
	/**
	 * Directions depend on color of the piece
	 */
	private int forward;
	private int upLeft;
	private int upRight;
	
	/**
	 * Default constructor- creates a white pawn
	 */
	public Pawn(){
		super(true);
		hasMoved = false;
		
		forward = 0;
		upLeft = 315;
		upRight = 45;
	}

	/**
	 * Modified constructor
	 */
	public Pawn(boolean color) {
		super(color);
		hasMoved = false;
		
		if (color){
			forward = 0;
			upRight = 45;
			upLeft = 315;
		}
		else {
			forward = 180;
			upLeft = 225;
			upRight = 135;
		}
	}
	
	/**
	 * Move one space forward
	 */
	public void move(){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		Location loc = getLocation();
		Location next = loc.getAdjacentLocation(forward);
		
		if ( !(gr.isValid(next)) )
			return;
		
		if ( !(gr.get(next) instanceof Actor) ){
			moveTo(next);
			hasMoved = true;
		}
	}
	
	/**
	 * Move two spaces forward, but only if it has not moved yet
	 */
	public void move2(){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		if (hasMoved)
			return;
		
		else {
			move();
			move();
		}
			
		hasMoved = true;
		}
		
	/**
	 * Capture a piece in the direction specified
	 * Possible directions: left/Left, right/Right
	 */
	public void capture(String direction){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int next;
		
		/**
		 * Determining which direction was input
		 */
		if (direction.equals("left") || direction.equals("Left"))
			next = upLeft;
		else if (direction.equals("right") || direction.equals("Right"))
			next = upRight;
		else
			return;
		
		super.capture(next);
	}
			
}


