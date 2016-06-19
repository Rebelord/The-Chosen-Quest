/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.CombatDamageController;
import java.util.Scanner;

/**
 *
 * @author ryandanielwebb
 */
public class CombatView extends View{
    
    public CombatView() {
              super("\n You are under attack. Please decide what you want to do."
                  + "\n Please Select the approprate letter"
                  + "\n"
                  + "\n You may ..."
                  + "\n  A - Attack your opponent"
                  + "\n  D - Defend against your opponents attack"
                  + "\n  P - Drink a potion (if you have one)"
                  + "\n  R - Run Away!");
    }

    @Override
    public boolean doAction(String combatOption) {
        combatOption = combatOption.toUpperCase(); // Convert choice to Lowercase.
        System.out.println(combatOption);
        switch (combatOption) {
            case "A": // Select travel North.
                this.Attack();
                break;
            case "D": // Select travel South.
                this.Defend();
                break;
            case "P": // Select travel East.
                this.Potion();
                break;
            case "R": // Select travel West.
                this.Run();
                break;
            default:
                System.out.println("\n Lets try this again, shall we.");
                break;
        }
        
        return false;
    }

    private void Attack() {
        // calls the Combat controller
        /*CombatDamageController combat = new CombatDamageController();
        combat.combatDamageController();*/
        System.out.println("You strike out at your enemy!");
        
    }

    private void Defend() {
        // calls the Combat controller
        /*CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();*/
        System.out.println("Your enemy swings at you with the intent of your demise");
    }

    private void Potion() {
        // calls the Combat controller
        /*CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();*/
        System.out.println("Ugh, you would think after all this time this stuff would taste better.");
    }

    private void Run() {
        /* calls the Combat Controller
        CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();
        */
        System.out.println("RUNNNNNNNN AWWWWAAAAAAYYYY!!!!!!!!!! It's going to eat ME!!!!!!!!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    
}
