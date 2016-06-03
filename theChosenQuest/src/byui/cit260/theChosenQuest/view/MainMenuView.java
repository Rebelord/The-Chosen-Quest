/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

/**
 *
 * @author Zack Durbin
 */
public class MainMenuView {
    
    private String menu;
    
    public MainMenuView() {
        this.menu = "\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                      Main Menu                       |"
                  + "\n--------------------------------------------------------"
                  + "\nN - Start a new Game"
                  + "\nG - Get and start saved game"
                  + "\nH - Get help on how to play the game"
                  + "\nS - Save Game"
                  + "\nQ - Quit Game"
                  + "\n--------------------------------------------------------";
    }

    void displayMainMenuView() {
    System.out.println("\n*** displayMenu() fuction called ***");
    }
    
}
