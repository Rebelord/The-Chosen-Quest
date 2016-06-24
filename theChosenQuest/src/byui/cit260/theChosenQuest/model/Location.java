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
public class Location implements Serializable {
    
    private LocationType type;
    private String description;
    private int row;
    private int col;
    // Add more stuff

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
    
    public Location() {
        
    }

    public LocationType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setType(LocationType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Location(LocationType type, String description) {
        this.type = type;
        this.description = description;
    }
    
    
}
