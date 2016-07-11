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
                  + "\n| N - New Game                                         |"
                  + "\n| G - Load Game                                        |"
                  + "\n| H - How to play the game                             |"
                  + "\n| S - Save Game                                        |"
                  + "\n| R - Resume Current Game                              |"    
                  + "\n| E - Quit Game                                        |"
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
            case "E":
                System.exit(0);
            case "R":
                this.resumeGame();
                break;                    
            default:
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    /** Create a New Game **/
    
    private void startNewGame() {
        // Call method from the GameControl function.
        GameControl.createNewGame(TheChosenQuest.getPlayer());
        
        // Display the game menu
       CharacterRace charRace = new CharacterRace();
       charRace.display();
    }

    private void startLoadGame() {
        console.println("\nEnter the file name: ");
        try {
            String fileName = keyboard.readLine();
            GameControl.loadGame(fileName);
            GameMenuView gmv = new GameMenuView();
            gmv.display();
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input!");
        }
    }

    private void displayHelpMenu() {
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void saveGame() {
        console.println("\nEnter the file name: ");
        try {
            String fileName = keyboard.readLine();
            GameControl.saveGame(fileName);
        } catch (Exception e) {
            ErrorView.display(this.getClass().getName(), "Error on input!");
        }
    }
    private void resumeGame() {
        console.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
