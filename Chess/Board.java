import info.gridworld.actor.Actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.BoundedGrid;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;

public class Board {

	public static void main(String[] args)
    {
		BoundedGrid gr = new BoundedGrid(8, 8);
        ActorWorld world = new ActorWorld(gr);
        
        /**
         * Placing Pawns on the board
         */
	        for (int i = 0; i < gr.getNumCols(); i++){
	        	world.add(new Location(1, i), new Pawn(false));
	        }
	        
	        for (int i = 0; i < gr.getNumCols(); i++){
	        	world.add(new Location(6, i), new Pawn(true));
	        }
	        
	    /**
	     * Placing Rooks on the board
	     */
	        world.add(new Location(0, 0), new Rook(false));
	        world.add(new Location(0, 7), new Rook(false));
	        
	        world.add(new Location(7, 0), new Rook(true));
	        world.add(new Location(7, 7), new Rook(true));
	        
	     /**
	      * Placing Knights on the board
	      */
	        world.add(new Location(0, 1), new Knight(false));
	        world.add(new Location(0, 6), new Knight(false));
	        
	        world.add(new Location(7, 1), new Knight(true));
	        world.add(new Location(7, 6), new Knight(true));
	        
	     /**
	      * Placing Bishops on the board
	      */
	        world.add(new Location(0, 2), new Bishop(false));
	        world.add(new Location(0, 5), new Bishop(false));
	        
	        world.add(new Location(7, 2), new Bishop(true));
	        world.add(new Location(7, 5), new Bishop(true));
	        
	     /**
	      * Placing Queens on the board
	      */
	        world.add(new Location(0, 3), new Queen(false));
	        
	        world.add(new Location(7, 3), new Queen(true));
	        
	     /**
	      * Placing Kings on the board
	      */
	        world.add(new Location(0, 4), new King(false));
	        
	        world.add(new Location(7, 4), new King(true));
	        
        world.show();
    }
}
