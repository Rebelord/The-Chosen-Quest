/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import byui.cit260.theChosenQuest.model.Player;
import java.util.Scanner;

/**
 *
 * @author ryandanielwebb
 */
public class StartProgramView {
    
    private String promptMessage;
    
    public StartProgramView() {
        this.promptMessage = "\n Thou shalt enter thy name: ";
        // Display the banner when view is created.
        this.displayBanner();
    }

    private void displayBanner() {
        System.out.println(
            "\n**********************************************************"
          + "\n*                                                        *"
          + "\n*     Welcome to the quaint little town of Elspeth       *"
          + "\n* nestled deep within the forest of Alshira. This small  *"
          + "\n* little town sent out a call to all heroes to help with *"
          + "\n* the string of troubles that they have recently         *"
          + "\n* incurred. This call brought you here seeking fame and  *"
          + "\n* glory. Only your actions can bring peace. Will you     *"
          + "\n* succeed or will this be your last adventure?           *"
          + "\n*                                                        *"
          + "\n**********************************************************"
        );
    }
    
    /* Displays the Start Program View */
    
    public void displayStartProgramView() {
        
        boolean done = false; // set flag to not done
        do {
            String playersName = this.getPlayersName();
            
            if (playersName.toUpperCase().equals("Q")) // User wants to quit!
                return; // exit the game
            
            // Do the requested action and display the next view.
            done = this.doAction(playersName);
           
        } while (!done);

    }

    private String getPlayersName() {
        
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
            
            break; // end the look
        }
            
    return value; // return the value entered      
    }

    private boolean doAction(String playersName) {
        // if the length of the playersName < 2 then
        // display "Invalid name: The name must be > 1 character
        // return false        
        if (playersName.length() < 2) {
            System.out.println("\n Invalid players name: " 
                + "The name must be greater than one character in length" );
            return false;
        }
        // create player with specified name
        // if unsuccessful then
            // display "Invalid name: The name is too short
            // return false
        // call createPlayer() control function
        Player player = GameControl.createPlayer(playersName);
        
        if (player == null){ // if unsuccessful
            System.out.println("\nError creating the player.");
            return false;
        }
        // display customized welcome message
        // display mainMenuView
        // return true
        this.displayNextView(player);
        return true; // success!
    }

    private void displayNextView(Player player) {
        // display a custom welcome message
        System.out.println("\n================================================="
                         + "\n   Welcome to Elspeth " + player.getName()
                         + "\n   May you succeed where others have failed."
                         + "\n================================================"
                          );
        // create MainMenuView object
        MainMenuView mainMenuView = new MainMenuView();
        
        //display the main menu view
        mainMenuView.displayMainMenuView();        
    }    
}
