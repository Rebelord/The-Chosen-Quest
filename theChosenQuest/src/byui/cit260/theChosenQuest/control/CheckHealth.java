/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.exception.LoseGameException;

/**
 *
 * @author Zack Durbin
 */
public class CheckHealth {
    public int checkHealth (int health, int poison, boolean rest, int charMaxHealth) throws LoseGameException {
        
        // Perform Sanity Checks
        if ((poison <= 0) && (rest == false)) {
            return -1;
        }
        if (health <= 0) {
            throw new LoseGameException('Wipe yourself off, you dead.');
        }
        
        // Lets make some changes to your health.
        if (rest == true) {
            return charMaxHealth;
        }
        if (poison > 0) {
            health -= poison;
            if (health <= 0) {
                throw new LoseGameException('Wipe yourself off, you dead.');
            }
        }
        // If it got here without doing something, then there's an error.
        return health;
    }
}
//This controller will inform the user of their health after attacks have been done. If hp <= 0 Game is over.

