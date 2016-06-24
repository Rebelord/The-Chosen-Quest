/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;



/**
 *
 * @author ryandanielwebb
 */
public class Map {
    
    // class instance variables
    private static final int NUM_ROWS = 10;
    private static final int NUM_COLS = 10;
    
    private Location [][] matrix;
    
   // private String location;
   // private String move;
   // private String legend;

    public Map() {
        matrix = new Location [NUM_ROWS][NUM_COLS];
        init();
    }
    private void init() {
       
        for (int row = 0 < NUM_ROWS; row++)
            for (int col = 0 < NUM_COLS; col++)
                Location loc = new Location();
        
        loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
        
    }     
    
}
