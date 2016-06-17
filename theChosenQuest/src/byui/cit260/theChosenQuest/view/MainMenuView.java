/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import java.util.Scanner;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author Zack Durbin
 */
public class MainMenuView extends View {
    
    public MainMenuView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                      Main Menu                       |"
                  + "\n--------------------------------------------------------"
                  + "\n| N - Start a new Game                                 |"
                  + "\n| G - Get and start saved game                         |"
                  + "\n| H - Get help on how to play the game                 |"
                  + "\n| S - Save Game                                        |"
                  + "\n| Q - Quit Game                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "N": // Create and Start a new game.
                this.startNewGame();
                break;
            case "G": // Load up a saved game
                this.startLoadGame();
                break;
            case "H": // Display the help menu.
                this.displayHelpMenu();
                break;
            case "S": // Save the current game.
                this.saveGame();
                break;
            default:
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    /** Create a New Game **/
    
    private void startNewGame() {
        // Call method from the GameControl function.
        GameControl.createNewGame(TheChosenQuest.getPlayer());
        
        // Display the game menu
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void startLoadGame() {
        System.out.println("\n*** startLoadGame function called ***");
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void saveGame() {
        System.out.println("\n*** saveGame function called ***");
    }
    
}
