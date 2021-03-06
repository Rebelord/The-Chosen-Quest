/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import static byui.cit260.theChosenQuest.model.LocationType.Encampment;
import static byui.cit260.theChosenQuest.model.LocationType.Shop;
import static byui.cit260.theChosenQuest.model.LocationType.Tavern;
import java.io.Serializable;

/**
 *
 * @author Ryan D Webb
 */

/** during game play map seemed off. */

public class Map implements Serializable {
    
    public static final int NUM_ROWS = 5;
    public static final int NUM_COLS = 5;
    
    private Location[][] matrix;
    
    public Map() {
        matrix = new Location[NUM_ROWS][NUM_COLS];
        mapMaker();
    }

    public void mapMaker() {
        
            // Initalize vairable.
            int shopMax = 0;
            int campMax = 0;
            int tavernMax = 0;
    
            // Loop for random map generation.
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int col = 0; col < NUM_COLS; col++) {
                    Location loc = new Location();
                    
                    // Create a random location type
                    loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
                    
                    // Prevent more than 3 Shops.
                    if (loc.getType() == Shop) {
                        shopMax++;
                    }
                    if (shopMax > 2) {
                        while (loc.getType() == Shop) {
                            loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
                        }
                    }
                    
                    // Prevent more than 3 Tavern.
                    if (loc.getType() == Tavern) {
                        tavernMax++;
                    }
                    if (tavernMax > 2) {
                        while (loc.getType() == Tavern) {
                            loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
                        }
                    }
                    
                    // Prevent more than 3 Camps.
                    if (loc.getType() == Encampment) {
                        campMax++;
                    }
                    if (campMax > 2) {
                        while (loc.getType() == Encampment) {
                            loc.setType(LocationType.values()[(int) (Math.random() * LocationType.values().length)]);
                        }
                    }
                    
                    // Set location.
                    loc.setRow(row);
                    loc.setCol(col);
                    
                    matrix[row][col] = loc;
                }
            }
    }
    
    // Build a map for viewing.
    public String getMapString() {
        
        String map = "";
        
        for (int row = 0; row < NUM_ROWS; row++) {
            for (int col = 0; col < NUM_COLS; col++) {
                map += matrix[row][col].getType().name().charAt(0) + "\t";
           }
            if (row != (NUM_ROWS - 1))
                map += "\n";
        }
        return map;
    }
    
    public Location getLocation(int row, int col) {
            return matrix[row][col];
    }
}
