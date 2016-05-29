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
public class CombatDamageController {
    public int combatDamageController(int playerAttackBonus, int playerDefense, int creatureAttackBonus, int creatureDefense){
    return -1;
    }
    public int playerAttackroll (int diceChoice, int playerAttackBonus, int creatureDefense) {
            
        // Intializing the Dice Random.
        DiceFaces diceRoll = new DiceFaces();

        int playerAttack = 0;
        int playerAttackRoll;
        playerAttackRoll = playerAttackBonus + diceRoll.rollTheDice(20);
        int playerCombatSuccess;
        playerCombatSuccess = playerAttackRoll - creatureDefense;
            if(playerCombatSuccess <= 0){
                return playerCombatSuccess;
            } else {
                return -1;
            }
            /* Requires a fallback return here, change it to what you need */

        }

    public int creatureAttack (int creatureAttackBonus, int playerDefense) {
        
        // Intializing the Dice Random.
        DiceFaces diceRoll = new DiceFaces();

        int creatureAttackRoll;
            creatureAttackRoll = creatureAttackBonus + diceRoll.rollTheDice(20);
        int creatureCombatSuccess = creatureAttackRoll- playerDefense;

            if(creatureCombatSuccess > 0){
                return creatureCombatSuccess;
            } else {
                return -1;}
        }
}

