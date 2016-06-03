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
public class HelpMenuView {
    
    // Intialize string to display help menu options.
    private String menu;
    
    // Display the Help Menu
    public HelpMenuView() {
        this.menu = "\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                Divine Assitance Menu                 |"
                  + "\n--------------------------------------------------------"
                  + "\n| G - The Goal of your Quest.                          |"
                  + "\n| M - Movement and how to use your lower limbs.        |"
                  + "\n| C - Combat, The Idiot's Guide to your Defense.       |"
                  + "\n| N - Non-Sentient beings and their role.              |"
                  + "\n| I - Inventory, Finders Keepers rules apply.          |"
                  + "\n| Q - Quit, stop the divine assistance, please.        |"
                  + "\n--------------------------------------------------------";
    }

    public void displayHelpMenuView() {
        
        boolean done = false; // set flag to not done.
        do {
            String menuOption = this.getMenuOption();
            if (menuOption.toUpperCase().equals("Q")) // User wants to quit Help Menu.
                return; // Exit the Help Menu.
            
            // Do the requested action and display the nexty view
            done = this.doAction(menuOption);
        } while (!done);
    }

    /*** Get input from user for Help Menu Option. ***/
    private String getMenuOption() {
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
            case "G": // Show the Game Goal.
                this.loadGoalInfo();
                break;
            case "M": // Show game movement information.
                this.loadMovementInfo();
                break;
            case "C": // Show game combat information.
                this.loadCombatInfo();
                break;
            case "N": // Show game NPC Interaction info.
                this.loadNpcInfo();
                break;
            case "I": // Show Inventory Management info.
                this.loadInventoryInfo();
                break;
            default:
                System.out.println("\n*** Divine Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void loadGoalInfo() {
        System.out.println("\n*** loadGoalInfo function called ***");
    }

    private void loadMovementInfo() {
        System.out.println("\n*** loadMovementInfo function called ***");
    }

    private void loadCombatInfo() {
        System.out.println("\n*** loadCombatInfo function called ***");
    }

    private void loadNpcInfo() {
        System.out.println("\n*** loadNpcInfo function called ***");
    }

    private void loadInventoryInfo() {
        System.out.println("\n*** loadInventoryInfo function called ***");
    }

}
