/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechosenquest;

import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.view.StartProgramView;
import byui.cit260.theChosenQuest.model.Game;

/**
 *
 * @author ryandanielwebb
 */
public class TheChosenQuest {
    private static Game currentGame;
    public static Player player;

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        TheChosenQuest.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        TheChosenQuest.player = player;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = new StartProgramView();
        
        startProgramView.displayStartProgramView();   
    }
    
}
