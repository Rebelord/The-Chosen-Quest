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

    public boolean AttackCheck(int attack, int hit) {

        // Sanity check
        if (attack <= 0) {
            return false;
        }

        if ((hit <= 0) && (attack > 0)) {
            return true;
        }

        // Intializing the Dice Random.
        DiceFaces diceRoll = new DiceFaces();

        int attackRoll;
        int combatSuccess;

        attackRoll = attack + diceRoll.rollTheDice(20);
        combatSuccess = attackRoll - hit;
        return combatSuccess > 0;
    }

    public int AttackRoll(int attack, int defense) {

        // Intializing the Dice Random.
        DiceFaces diceRoll = new DiceFaces();

        int damage;

        // Calculate attack damage.
        damage = attack - defense;
        return damage;
    }
}
