import info.gridworld.actor.Actor;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Knight extends Piece {
    /**
     * Default constructor- makes a white Knight
     */
    public Knight() {
        super(true);
    }

    /**
     * Variable constructor
     */
    public Knight(boolean color) {
        super(color);
    }
    
    /**
     * Move method
     * The piece moves two spaces in the first specified direction,
     * then one space in the second specified direction.
     * It is able to jump over other pieces
     */
    public void move(String direct1, String direct2){
        Grid<Actor> gr = getGrid();
        if (gr == null)
            return; 
            
        //Saving the pre-movement location
        Location origin = getLocation();
        //Current location
        Location loc = origin;
        
        /**
         * Setting the degree measure for the first direction
         */
        int direction1 = setDirections(direct1);
        
        /**
         * Settin the degree measure for the second direction
         */
        int direction2 = setDirections(direct2);
        
        /**
         * Making sure the piece is not moving the same direction twice
         * or opposite directions
         */
        
        
        if (direction1 == direction2)
            return;
        if (Math.abs(direction1 - direction2) == 180)
            return;
        
        Location mid = new Location(loc.getCol(), (loc.getRow() + 2));
        moveTo(mid);
        
        loc = getLocation();
        Location next = loc.getAdjacentLocation(direction2);
        Piece target = (Piece) gr.get(next);
        
        if (target.getPieceColor() == getPieceColor()){
            moveTo(origin);
            return;
        }
        else{
            super.capture(direction2);
            moveTo(next);
        }
    }
}
