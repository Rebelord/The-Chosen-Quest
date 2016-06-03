/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;

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

    public void displayMainMenuView() {
    
        boolean done = false; // set flag to not done
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q"))// user wants to quit
                return; // exit the game
            
            //do the requested action and display the next view
            done = this.doAction(menuOption);
        } while (!done);
    }

    private String getMenuOption() {
        Scanner keyboard = new Scanner(System.in); // Get infile for keyboard.
        String value = ""; // Value to be returned.
        boolean valid = false; // Set flag to not done.
        
        while (!valid) { // Loop while an invalid value is enter.
            System.out.println("\n" + this.promptMessage);
            
            value = keyboard.nextLine(); // Get the next line typed on the keyboard.
            value = value.trim(); // Trim off the blanks.
            
            if (value.length() < 1){
               System.out.println("\nInvalid value: Value can not be blank");
               continue;
            }
            
            break; // end the loop
        }
            
    return value; // return the value entered      
    }
    

    private boolean doAction(String menuOption) {
        System.out.println("\n*** doAction() function called ***");
        return true;
    }
    
}
