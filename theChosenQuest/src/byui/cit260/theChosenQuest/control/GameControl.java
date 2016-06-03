/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.model.Player;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author Zack Durbin
 */
public class GameControl {

  public static Player createPlayer(String playersName) {
       
           
           if (playersName == null) {
                return null;
           }
           Player player = new Player();
           player.setName(playersName);
           
           TheChosenQuest.setPlayer(player); // save the player
           
           return player;
       }
    }
    

