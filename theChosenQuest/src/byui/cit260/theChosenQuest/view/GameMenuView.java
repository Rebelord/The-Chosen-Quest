
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import byui.cit260.theChosenQuest.exception.InputErrorException;
import byui.cit260.theChosenQuest.model.CharacterSheet;
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
                  + "\n| C - Character Sheet                                  |"
                  + "\n| I - Inventory                                        |"   
                  + "\n| S - Save Game                                        |"
                  + "\n| L - Load Game                                        |"   
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
            case "S": // Save the current game.
                this.saveGame();
                break;
            case "L":
                this.loadGame();
                break;
            case "H":
                this.helpmenu();
                break;
            case "C": // Display the Character Sheet
                this.characterSheet();
                break;
            case "I":
                this.inventory();
                break;
            case "E":
                System.exit(0);
            
        }
        
        return false;
    }

    private void resumeGame() {
        console.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();        
        }

    private void helpmenu() {
        console.println("Welcome to the Divine Assistance Menu");
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
    
    private void loadGame() {
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
    
        private void characterSheet() {
        console.println("\n*** What do I look like again?");
        CharacterSheet charSheet = new CharacterSheet();
        charSheet.display();
    }
    private void inventory() {
        console.println("What do I have with me that will help?");
        Inventory inventory = new Inventory();
        inventory.display();
    }
}
