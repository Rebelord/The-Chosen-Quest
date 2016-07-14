/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;
import byui.cit260.theChosenQuest.model.Player;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author Zack Durbin
 */
public class CharacterClass extends View {
    
    public CharacterClass() {
        super("\n"
                +"\n-----------------------------------------------------------"
                +"\n|                  Class Selection                         |"
                +"\n-----------------------------------------------------------"
                +"\n| F - Fighter                                              |"
                +"\n| M - Mage                                                 |"
                +"\n| R - Rouge                                                |"
                +"\n| H - Hunter                                               |"
                +"\n| Q - Return to Race Selection                             |"
                +"\n-----------------------------------------------------------");
    }
    
    @Override
    public boolean doAction(String menuOption) {
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
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void fighter() {
        TheChosenQuest.player.setPlayerClass("Fighter");
        console.println("You have chosen the way of the Sword. You are the epitome of bladed fury. You are the mighty fighter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void mage() {
        TheChosenQuest.player.setPlayerClass("Mage");
        console.println("You have chosen the way of the Mind. Wielder of the sacred arts. You are the brilliant mage.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void rouge() {
        TheChosenQuest.player.setPlayerClass("Rouge");
        console.println("You have chosen the way of the Shadows. You strike your enemies weak points. You are the crafty rogue.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void hunter() {
        TheChosenQuest.player.setPlayerClass("Hunter");
        console.println("You have chosen the way of the Bow. Your arrows fly unerringly with deadly accuracy. You are the nimble hunter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
