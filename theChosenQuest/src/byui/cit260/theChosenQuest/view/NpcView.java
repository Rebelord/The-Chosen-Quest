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
public class NpcView extends View {
    
    public NpcView() {
        
                  super("\n   An old beggar stumbles into you clumsily smelling of"
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
                      + "\n   Q. Cross to the other side of the street."
                      + "\n");
    }
    
    @Override
    public boolean doAction(String chatOption) {
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
