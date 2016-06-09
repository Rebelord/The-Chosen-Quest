/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;

/**
 *
 * @author Dewy
 */
public class MovementView {
    
    private String menu;
    
    public MovementView() {
        this.menu = "\n In which direction would thou wish to travel?"
                  + "\n Please type your answer."
                  + "\n"
                  + "\n You may travel..."
                  + "\n     North"
                  + "\n     South"
                  + "\n     East"
                  + "\n     West"
                  + "\n     None";
    }
    
    public void displayMovementView() {
        
        boolean done = false;
        do {
            String movementOption = this.getMovementOption();
            if (movementOption.toLowerCase().equals("none")) // User wants to not travel.
                return; // exit the movement menu
                
            // DO the requested action and displat the next view.
            done = this.doAction(movementOption);
        } while (!done);
    }

    private String getMovementOption() {
        Scanner keyboard = new Scanner(System.in); // Get infile for keyboard.
        String value = ""; // Value to be returned.
        boolean valid = false; // Set flag to not done.
        
        while (!valid) { // Loop while an invalid value is enter.
            System.out.println("\n" + this.menu);
            
            value = keyboard.nextLine(); // Get the next line typed on the keyboard.
            value = value.trim(); // Trim off the blanks.
            
            if (value.length() < 4 || value.length() > 5){
               System.out.println("\n Invalid input: Value must be North, South, East, West, or none.");
               continue;
            }
            
            break; // end the look
        }
    return value; // return the value entered 
    }

    private boolean doAction(String movementOption) {
        movementOption = movementOption.toLowerCase(); // Convert choice to Lowercase.
        System.out.println(movementOption);
        switch (movementOption) {
            case "north": // Select travel North.
                this.moveNorth();
                break;
            case "south": // Select travel South.
                this.moveSouth();
                break;
            case "east": // Select travel East.
                this.moveEast();
                break;
            case "west": // Select travel West.
                this.moveWest();
                break;
            default:
                System.out.println("\n Lets try this again, shall we.");
                break;
        }
        
        return false;
    }

    private void moveNorth() {
        System.out.println("\n You wish to travel North!");
    }

    private void moveSouth() {
        System.out.println("\n You wish to travel South!");
    }

    private void moveEast() {
        System.out.println("\n You wish to travel East!");
    }

    private void moveWest() {
        System.out.println("\n You wish to travel West!");
    }

}
