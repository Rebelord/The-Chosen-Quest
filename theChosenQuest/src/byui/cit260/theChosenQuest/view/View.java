/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.exception.InputErrorException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zack Durbin
 */
public abstract class View implements ViewInterface {
    
    protected String displayMessage;


public View() {
    
}

public View(String message) {
    this.displayMessage = message;
}

    @Override
    public void display() {

        boolean done = false;
        do {
             // prompt for and get players name
            String value = this.getInput();
            if ((value.toUpperCase().equals("Q")) && !(this instanceof InGameMenuView)){
              return;  
           // Need to add a condition to check the game status
           // for proper Game Control and Flow
           
            //InGameMenuView inGameMenu = new InGameMenuView();
            //inGameMenu.display();
            }
            done = this.doAction(value);
        } while (!done);
    
    }
    @Override
    public String getInput(){
        Scanner keyboard = new Scanner(System.in); // Get infile for keyboard.
        String value = ""; // Value to be returned.
        boolean valid = false; // Set flag to not done.
        
        while (!valid) { // Loop while an invalid value is enter.
            System.out.println("\n" + this.displayMessage);
            
            value = keyboard.nextLine(); // Get the next line typed on the keyboard.
            value = value.trim(); // Trim off the blanks.
            
                       
            if (value.length() < 1) {
               System.out.println("\n Invalid input: please try again");
               continue;
            }
//            if(!valid){
//            try {
//                throw new InputErrorException ("\n Invalid Input, please try again");
//            } catch (InputErrorException ex) {
//                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
            
    
            
            break; // end the look
        }
    return value; // return the value entered 
    }
}    











