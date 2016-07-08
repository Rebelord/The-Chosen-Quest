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
                      + "\n   M. Open your menu to see what else you can do."    
                      + "\n   Q. Cross to the other side of the street."
                      + "\n");
    }
    
    @Override
    public boolean doAction(String chatOption) {
        chatOption = chatOption.toUpperCase(); // Convert choice to Lowercase.
        System.out.println(chatOption);
        switch (chatOption) {
            case "A": // Select travel South.
                this.optionA();
                break;
            case "B": // Select travel South.
                this.optionB();
                break;
            case "C": // Select travel East.
                this.optionC();
                break;
            case "D": // Select travel West.
                this.optionD();
                break;
            case "E":
                this.optionE();
                break;
            case "M":
                this.optionM();
                break;
            default:
                System.out.println("\n Need a real answer on this issue.");
                break;
        }
        
        return false;
    }

    private void optionA() {
        System.out.println("\n The beggar farts in your general direction as you pass by him.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
    private void optionB() {
        System.out.println("\nHow many coins would you like to throw?");
        Scanner keyboard = new Scanner(System.in);
        // Will move this later to an option to give a bum money.
        String input = "";
        try {
            input = keyboard.nextLine();
        } catch (Exception e) {
            //buried
        }

        int myNum = 0;
        try {
            myNum = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            System.out.println("Bad number input.");
        }
        
        System.out.println("\n The beggar blinded by flying coins laughed joyfully at the gift.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void optionC() {
        System.out.println("\n Sure, beat up an old bum!");
        //CombatView combat = new CombatView();
        //combat.display();
    }

    private void optionD() {
        System.out.println("\n The beggar offended by your condescending tone decides to throw feces at you.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void optionE() {
       System.out.println("You quickly cross the street and continue on your way undisturbed.");
       MovementView moveMe = new MovementView();
       moveMe.display();
    }

    private void optionM() {
       InGameMenuView gameView = new InGameMenuView();
       gameView.display();
    }
}
