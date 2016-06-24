/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.Serializable;

/**
 *
 * @author Ryan D Webb
 */
public class Map implements Serializable {
    
    public static final int NUM_ROWS = 10;
    public static final int NUM_COLS = 10;
    
    private Location[][] matrix;
    
    public Map() {
        matrix = new Location[NUM_ROWS][NUM_COLS];
        init();
    }

    public void init() {
    
            // Loop for random map generation.
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    Location loc = new Location();
                    
                    // Create a random location type
                    loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
                    
                    matrix[row][col] = loc;
                }
            }
    }
    
    // Build a map for viewing.
    public String getMapString() {
        
        String map = "";
        
        for (int col = 0; col < NUM_COLS; col++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                map += matrix[row][col].getType().name().charAt(0) + "\t";
            }
            
            map += "\n";
        }
        return map;
    }
    
    public Location getLocation(int row, int col) {
            return matrix[row][col];
    }
}