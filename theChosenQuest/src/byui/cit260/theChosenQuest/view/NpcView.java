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
public class NpcView {
    
    private String chatMenu;
    
    public NpcView() {
        
        this.chatMenu = "\n   An old beggar stumbles into you clumsily smelling of"
                      + "\n moonshine, and devilweed. After falling over, and giving"
                      + "\n a frightful paranoid look, he slowly extends a shaky"
                      + "\n boil encrusted hand."
                      + "\n"
                      + "\n   Do you wish to..."
                      + "\n"
                      + "\n   A. Ignore him, and continue walking by."
                      + "\n   B. Throw a few measealy coins in his direction."
                      + "\n   C. Intiate combat for his insolence."
                      + "\n   D. Offer advice on breaking devilweed addiction."
                      + "\n";
    }
    
    public void displayNpcView() {
        
        boolean done = false;
        do {
            String chatOption = this.getChatOption();
            if (chatOption.toUpperCase().equals("A")) // User wishes to ignore the NPC.
                return; // Exit the NPC interaction.
            
            // Do the reqauested action, and display the next view.
            done = this.doAction(chatOption);
    } while (!done);
}

    private String getChatOption() {
        Scanner keyboard = new Scanner(System.in); // Get infile for keyboard.
        String value = ""; // Value to be returned.
        boolean valid = false; // Set flag to not done.
        
        while (!valid) { // Loop while an invalid value is enter.
            System.out.println("\n" + this.chatMenu);
            
            value = keyboard.nextLine(); // Get the next line typed on the keyboard.
            value = value.trim(); // Trim off the blanks.
            
            if (value.length() < 1){
               System.out.println("\n Choose an input to deal with this beggar.");
               continue;
            }
            
            break; // end the look
        }
    return value; // return the value entered 
    }

    private boolean doAction(String chatOption) {
        chatOption = chatOption.toUpperCase(); // Convert choice to Lowercase.
        System.out.println(chatOption);
        switch (chatOption) {
            case "B": // Select travel South.
                this.optionB();
                break;
            case "C": // Select travel East.
                this.optionC();
                break;
            case "D": // Select travel West.
                this.optionD();
                break;
            default:
                System.out.println("\n Need a real answer on this issue.");
                break;
        }
        
        return false;
    }

    private void optionB() {
        System.out.println("\n The beggar blinded by flying coins laughed joyfully at the gift.");
    }

    private void optionC() {
        System.out.println("\n Sure, beat up an old bum!");
    }

    private void optionD() {
        System.out.println("\n The beggar offended by your condescending tone decides to throw feces at you.");
    }
}
