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
public class CharacterClass {
    private String menu;
    
    public CharacterClass() {
        this.menu = "\n"
                +"\n-----------------------------------------------------------"
                +"\n|                  Class Selection                         |"
                +"\n-----------------------------------------------------------"
                +"\n| F - Fighter                                              "
                +"\n| M - Mage                                                 "
                +"\n| R - Rouge                                                "
                +"\n| H - Hunter                                                 "
                +"\n| Q - Quit                                                 "
                +"\n-----------------------------------------------------------";
    }
    
    public void displayCharacterClass() {
    
        boolean done = false; // set flag to not done
        do {
            String raceOption = this.getRaceOption();
            if (raceOption.toUpperCase().equals("Q"))// user wants to quit
                return; // exit the game
            
            //do the requested action and display the next view
            done = this.doAction(raceOption);
        } while (!done);
    }

    private String getRaceOption() {
        Scanner keyboard = new Scanner(System.in); // Get infile for keyboard.
        String value = ""; // Value to be returned.
        boolean valid = false; // Set flag to not done.
        
        while (!valid) { // Loop while an invalid value is enter.
            System.out.println("\n" + this.menu);
            
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
    

    private boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "F": // Choose to play as a fighter.
                this.fighter();
                break;
            case "M": // Choose to play as a Mage.
                this.mage();
                break;
            case "R": // Chose to play as a Rouge.
                this.rouge();
                break;
            case "H": //  Choose to play as a Hunter.
                this.hunter();
                break;
            default:
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void fighter() {
        System.out.println("You have chosen the way of the Sword. You are the epitome of bladed fury. You are the mighty fighter.");
    }

    private void mage() {
        System.out.println("You have chosen the way of the Mind. Wielder of the sacred arts. You are the brilliant mage.");
    }

    private void rouge() {
        System.out.println("You have chosen the way of the Shadows. You strike your enemies weak points. You are the crafty rogue.");
    }

    private void hunter() {
        System.out.println("You have chosen the way of the Bow. Your arrows fly unerringly with deadly accuracy. You are the nimble hunter.");
    }
    
    

   
}
