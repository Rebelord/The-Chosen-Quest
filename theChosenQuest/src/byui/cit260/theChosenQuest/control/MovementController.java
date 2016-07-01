/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.model.Game;
import byui.cit260.theChosenQuest.model.Location;
import byui.cit260.theChosenQuest.model.Map;
import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.exception.MovementException;

/**
 *
 * @author Zack Durbin
 */
public class MovementController {
    
    public boolean moveNorth(Game game) throws MovementException {
        
        Player player = game.getPlayer();
        Location currentLocation = player.getLocation();
        Map map = game.getMap();
        
        if(currentLocation.getRow() == 0) {
            throw new MovementException("You cannot move North");
        }
        
        int currentCol = currentLocation.getCol();
        int currentRow = currentLocation.getRow();
        int newRow = currentRow - 1;
        
        Location newLocation = map.getLocation(newRow, currentCol);
        player.setLocation(newLocation);
        
        return true;
    }
    
    public boolean moveEast(Game game) throws MovementException {
        
        Player player = game.getPlayer();
        Location currentLocation = player.getLocation();
        Map map = game.getMap();
        
        if(currentLocation.getCol() == Map.NUM_COLS - 1) {
            throw new MovementException("You cannot move East");
        }
        
        player.setLocation(map.getLocation(currentLocation.getRow(), currentLocation.getCol() + 1));
        
        return true;
    }
    
    public boolean moveSouth(Game game) throws MovementException {
        
        Player player = game.getPlayer();
        Location currentLocation = player.getLocation();
        Map map = game.getMap();
        
        if(currentLocation.getRow() == Map.NUM_ROWS - 1) {
            throw new MovementException("You cannot move South");
        }
        
        player.setLocation(map.getLocation(currentLocation.getRow() + 1, currentLocation.getCol()));
        
        return true;
    }
    
    public boolean moveWest(Game game) throws MovementException {
        
        Player player = game.getPlayer();
        Location currentLocation = player.getLocation();
        Map map = game.getMap();
        
        if(currentLocation.getCol() == 0) {
            throw new MovementException("You cannot move West");
        }
        
        player.setLocation(map.getLocation(currentLocation.getRow(), currentLocation.getCol() - 1));
        
        return true;
    }
}
