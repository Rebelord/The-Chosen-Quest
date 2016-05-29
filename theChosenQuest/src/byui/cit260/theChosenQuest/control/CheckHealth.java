/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

/**
 *
 * @author Zack Durbin
 */
public class CheckHealth {
    public int checkhealth (int health, boolean battle, int attack, boolean rest) {
        
        // Perform Sanity Checks
        if ((battle == false) && (rest == false)) {
            return -1;
        }
        
        if ((battle == true)&& (rest == true)) {
            return -1;
        }
        
        if (battle == true) {
            if (attack >= 0) {
            health -= attack;
        }
        }
        if (rest == true) {
            health = 100;
        }
        
        return -1;
    }
}
//This controller will inform the user of their health after attacks have been done. If hp <= 0 Game is over.

