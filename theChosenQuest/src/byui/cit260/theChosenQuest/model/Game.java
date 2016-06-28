/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import byui.cit260.theChosenQuest.control.ShopController;
import java.io.Serializable;

/**
 *
 * @author Ryan D Webb
 */
public class Game implements Serializable {
    
    //Intialize Game Variables
    private Player player;
    private Map map;
    private ShopController equipment;

    public ShopController getEquipment() {
        return equipment;
    }

    public void setEquipment(ShopController equipment) {
        this.equipment = equipment;
    }

    public Game() {
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }
}
