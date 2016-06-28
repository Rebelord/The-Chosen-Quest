/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.model.Location;
import static java.lang.System.console;
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
                  + "\n| M - View Map                                         |"  
                  + "\n| O - Options                                          |"    
                  + "\n| L - View Location                                    |"
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
            case "M":
                this.viewMap();
                break;
            case "L": // Display the help menu.
                this.viewCurrentLocation();
                break;
            case "H":
                this.helpmenu();
                break;
            case "E":
                System.exit(0);
            default:
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void resumeGame() {
        System.out.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void optionM() {
        System.out.println("You have opened the game menu");
       InGameMenuView gameView = new InGameMenuView();
       gameView.display();
    }

    private void helpmenu() {
        System.out.println("Welcome to the Divine Assistance Menu");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

    private void viewMap() {
        System.out.println(TheChosenQuest.getCurrentGame().getMap().getMapString());
    }

    private void viewCurrentLocation() {
        Location currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation();
        System.out.println("You are currently at: (" + currentLocation.getRow() + "," + currentLocation.getCol() +")");
    }

   
    
}
