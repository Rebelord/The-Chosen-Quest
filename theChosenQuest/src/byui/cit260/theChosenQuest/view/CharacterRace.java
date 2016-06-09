/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;

/**
 *
 * @author ryandanielwebb
 */
public class CharacterRace {
   
    
    private String menu;
    
    public CharacterRace() {
        this.menu = "\n"
                +"\n-----------------------------------------------------------"
                +"\n|                  Race Selection                         |"
                +"\n-----------------------------------------------------------"
                +"\n| D - Dwarf                                                "
                +"\n| H - Human                                                "
                +"\n| L - Halfling                                             "
                +"\n| E - Elf                                                  "
                +"\n| Q - Quit                                                 "
                +"\n-----------------------------------------------------------";
    }
    
    public void displayCharacterCreation() {
    
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
            case "D": // Create and Start a new Dwarf Hero.
                this.dwarf();
                break;
            case "H": // Create and Start a new Human Hero.
                this.human();
                break;
            case "L": // Create and Start a new Halfling Hero.
                this.halfling();
                break;
            case "E": // Create and Start a new Elf Hero.
                this.elf();
                break;
            default:
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }
    
    

    private void dwarf() {
       System.out.println ("Create a new dwarf hero fuction is called");
    }

    private void human() {
        System.out.println ("Create a new Human hero fuction is called");
    }

    private void halfling() {
        System.out.println ("Create a new Halfling hero fuction is called");
    }

    private void elf() {
        System.out.println ("Create a new Elf hero fuction is called");
    }
}
