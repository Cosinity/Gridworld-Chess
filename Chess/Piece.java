import java.awt.Color;

import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public abstract class Piece extends Actor {
	
	/**
	 * Color of the piece; true = white, false = black
	 */
	private boolean color;
	
	/**
	 * Default constructor- creates a white piece
	 */
	public Piece(){
		color = true;
		
		setColor(new Color(255, 211, 155));
	}
	
	public Piece(boolean color){
		this.color = color;
		 
		if (color){
			setColor(new Color(255, 211, 155));
		}
		else{
			setColor(new Color(139, 69, 19));
		}
	}
	
	public void act(){}
	
	 /** 
	  * Basic move method to be called in subclasses
	  */
	protected void move(int direction, int steps){
		Grid<Actor> gr = getGrid();
		if (gr == null) 
			return;
		
		Location loc = getLocation();
		int stepCount = 0;
		
		Actor target = gr.get(loc.getAdjacentLocation(direction));
		
		while ( target == null && stepCount < steps){
			moveTo(loc.getAdjacentLocation(direction));
			stepCount++;
			loc = getLocation();
			target = gr.get(loc.getAdjacentLocation(direction));
		}
	}
	
	/**
	 * Basic capture method to be called in subclasses
	 */
	protected void capture(int direction){
		Grid<Actor> gr = getGrid();
		if (gr == null)
			return;
		
		Location loc = getLocation();
		Piece target = (Piece) gr.get(loc.getAdjacentLocation(direction));
		
		/**
		 * Exit the method if the target location does not contain
		 * an actor, or the piece in the target location is the same
		 * color as the attacking piece
		 * 
		 * Otherwise, capture the piece
		 */
		if ( target == null || target.getPieceColor() == getPieceColor())
			return;
		else{
			target.removeSelfFromGrid();
			moveTo(loc.getAdjacentLocation(direction));
		}
	}
	
	/**
	 * Get the color of the piece
	 */
	protected boolean getPieceColor(){
		if (color)
			return true;
		else
			return false;
	}
	
	/**
	 * To change the color if needed
	 */
	protected void setPieceColor(boolean pieceColor){
		color = pieceColor;
	}

	protected int setDirections(String direct){
		
        /**
         * Set direction based on the input string
         */
		if (direct.compareToIgnoreCase("up") == 0)
			return 0;
		else if (direct.compareToIgnoreCase("down") == 0)
			return 180;
		else if (direct.compareToIgnoreCase("left") == 0)
			return 270;
		else if (direct.compareToIgnoreCase("right") == 0)
			return 90;
		else if (direct.compareToIgnoreCase("upleft") == 0)
			return 315;
		else if (direct.compareToIgnoreCase("upright") == 0)
			return 45;
		else if (direct.compareToIgnoreCase("downleft") == 0)
			return 225;
		else if (direct.compareToIgnoreCase("downright") == 0)
			return 135;
		else
			return -1;
    }
}
