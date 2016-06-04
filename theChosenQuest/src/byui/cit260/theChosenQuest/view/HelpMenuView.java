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
        System.out.println("\n*** Your quest, should you chose to accept it is"
                         +  "\n to transverse the wilds around Elspeth to" +
                            "\n find the cause of all the troubles that have" +
                            "\n befallen the poor towns people. Can you survive" +
                            "\n the hordes of monsters and bring peace back to" +
                            "\n the land?***");
    }

    private void loadMovementInfo() {
        System.out.println("\n*** This option will explain how to move your feet"+
                            "\n so that you can get from one area to the next." +
                            "\n At this time it is not set yet but more than" +
                            "\n likely it will be N to move north, S to move" +
                            "\n south, E for east and W for west.***");
    }

    private void loadCombatInfo() {
        System.out.println("\n*** This option will display an explination of"+
                "\n how to attack, defend, or run away. Default options will" +
                "\n more than likely be A, D, R respectively. It may also contain" +
                "\n how attack success is determined.***");
    }

    private void loadNpcInfo() {
        System.out.println("\n*** This will have information on how to interact" +
                "\n with the NPCs of the game. This would include shops, POI's," +
                "\n and the like. Such interactions of talking, selling, buying," +
                "\n and if truly evil attacking NPCs.***");
    }

    private void loadInventoryInfo() {
        System.out.println("\n*** This will explain how to equip items you find"+
                "\n look at items, and a brief description of the different items***");
    }

}
