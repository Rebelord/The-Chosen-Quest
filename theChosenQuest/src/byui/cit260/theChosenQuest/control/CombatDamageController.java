/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import static thechosenquest.TheChosenQuest.player;

/**
 *
 * @author Zack Durbin
 */
public class CombatDamageController {

    public boolean attackCheck(int attack, int hit) {

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
    
  public int playerAttack(int attack, int defense, int diceChoice, int rolls, int playerStr){
        
        // Intializing variables.
        DiceFaces diceRoll = new DiceFaces();
        int damage = 0;            
        playerStr = player.getStr();
        
        // Calculate attack damage.
        for (int i = 0; i < rolls; i++) {
            damage += diceRoll.rollTheDice(diceChoice);
        }
        damage += attack;
        damage += playerStr;
        damage -= defense;
        
        // Make sure damage isn't negative.
        if (damage < 0)
            damage = 1;
        
        return damage;
    }

  /*  public int attackRoll(int attack, int defense) {

        // Intializing variables.
        DiceFaces diceRoll = new DiceFaces();
        int damage;            
        int finalDamage;
        int playerStr = player.getStr();
        
        // Calculate attack damage.
        
        damage = attack - defense;
        finalDamage = damage + playerStr;
        
        if (damage < 0)
            damage = 0;
        
        return finalDamage;
    }*/
 
    public int creatureAttack(int attack, int defense,int diceChoice, int rolls) {

        // Intializing variables.
        DiceFaces diceRoll = new DiceFaces();
        int damage = 0;            
        
        // Calculate attack damage.
        for (int i = 0; i < rolls; i++) {
            damage += diceRoll.rollTheDice(diceChoice);
        }
        damage += attack;
        
        
        // Make sure damage isn't negative.
        if (damage < 0)
            damage = 1;
        
        return damage;
    }
    
}
