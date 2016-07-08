
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.exception.InputErrorException;
import byui.cit260.theChosenQuest.model.Location;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author ryandanielwebb
 */
public class GameMenuView extends View {

    public GameMenuView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                     Game Menu                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| R - Resume Game                                      |" 
                  + "\n| O - Options                                          |"    
                  + "\n| H - Help Menu                                        |"    
                  + "\n| E - Exit Game                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
        
        switch (menuOption) {
            case "R": // Create and Start a new game.
                this.resumeGame();
                break;
            case "O":
                this.optionM();
                break;
            case "H":
                this.helpmenu();
                break;
            case "E":
                System.exit(0);
          //  default:
          //      console.println("\n*** Fat Finger Error *** Please try again!");
           //     break;
        }
        
        return false;
    }

    private void resumeGame() {
        console.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();        
        }

    private void optionM() {
        console.println("You have opened the game menu");
        InGameMenuView gameView = new InGameMenuView();
        gameView.display();
    }

    private void helpmenu() {
        console.println("Welcome to the Divine Assistance Menu");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }
}
