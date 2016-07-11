/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.model.CharacterSheet;

/**
 *
 * @author Ryan D Webb
 */
public class InGameMenuView extends View {
    
    public InGameMenuView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                   Option Menu                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| R - Resume Game                                      |"
                  + "\n| M - Main Menu                                        |"
                  + "\n| C - Character Sheet                                  |"
                  + "\n| I - Inventory                                        |"
                  + "\n| P - Print Player to File                             |" 
                  + "\n| Q - Quit Game                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "R": // Create and Start a new game.
                this.resumeGame();
                break;
            case "M": // Load up the main menu
                this.mainMenu();
                break;
            case "C": // Display the Character Sheet
                this.characterSheet();
                break;
            case "I":
                this.inventory();
                break;
            case "Q":
                this.GameMenuView();
                break;
            case "P":
                this.printPlayer();
                break;
            default:
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void resumeGame() {
        console.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void mainMenu() {
        console.println("\n*** Do you want to save?");
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
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

    private void GameMenuView() {
        GameMenuView GameMenuView =  new GameMenuView();
        GameMenuView.display();
    }

    private void printPlayer() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
