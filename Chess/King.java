import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class King extends Piece {
	
	private boolean hasMoved;

	public King() {
		super(true);
		hasMoved = false;
	}

	public King(boolean color) {
		super(color);
		hasMoved = false;
	}
	
	/**
	 * Move method
	 * Can move one space in any direction
	 */
	public void move(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		super.move(direction, 1);
		
		hasMoved = true;
	}
	
	/**
	 * Capture method
	 * Can capture a piece one space away in any direction
	 */
	private void capture(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		super.capture(direction);
		
		hasMoved = true;
	}
	
	/**
	 * Castle method
	 * Can only castle if neither the king nor rook has moved,
	 * and there are no pieces between them
	 */
	public void castle(String direct){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		int direction = super.setDirections(direct);
		if (Math.abs(direction - 180) != 90)
			return;
		
		Location loc = getLocation();
		Rook rook = new Rook();
		
		if (direction == 90){
			for (int i = 0; i < 2; i++){
				if (gr.get(loc.getAdjacentLocation(direction)) instanceof Actor)
					return;
				loc = loc.getAdjacentLocation(direction);
			}
			
			rook = (Rook) gr.get(loc.getAdjacentLocation(direction));
		}
		
		if (direction == 270){
			for (int i = 0; i < 3; i++){
				if (gr.get(loc.getAdjacentLocation(direction)) instanceof Actor)
					return;
				loc = loc.getAdjacentLocation(direction);
			}
			
			rook = (Rook) gr.get(loc.getAdjacentLocation(direction));
		}
		
		if (rook.canCastle() && !(hasMoved)){
			super.move(direction, 2);
			
			Location rookLoc = rook.getLocation();
			
			if (direction == 90){
				Location rookMove = new Location(rookLoc.getRow(), (rookLoc.getCol() - 2));
				rook.moveTo(rookMove);
			}
			
			if (direction == 270){
				Location rookMove = new Location(rookLoc.getRow(), (rookLoc.getCol() + 3));
				rook.moveTo(rookMove);
			}
		}
	}

}
