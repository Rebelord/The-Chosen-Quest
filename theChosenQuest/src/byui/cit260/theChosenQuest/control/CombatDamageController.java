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
    public int combatDamageController(int playerAttackBonus, int playerDefense, int DiceFaces, int creatureAttackBonus, int creatureDefense){
    return -1;
    
    playerAttackroll (playerAttackBonus, DiceFaces, creatureDefense) {
        int playerAttack = 0;
        int playerAttackRoll;
        playerAttackRoll = playerAttackBonus + DiceFaces;
        int playerCombatSuccess;
        playerCombatSuccess = playerAttackRoll - creatureDefense;
            if(playerCombatSuccess > 0);{
                return playerCombatSuccess;
            } else {
                return -1;}
    
    }
    
    creatureAttack (creatureAttackBonus, DiceFaces, playerDefense){
        int creatureAttackRoll;
            creatureAttackRoll = creatureAttackBonus + DiceFaces;
        int creatureCombatSuccess = creatureAttackRoll- playerDefense;
        
            if(creatureCombatSuccess > 0){
                return creatureCombatSuccess;
            } else {
                return -1;}
            }
                
    }

    private void creatureAttack(int creatureAttackBonus, int DiceFaces, int playerDefense) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void playerAttackroll(int playerAttackBonus, int DiceFaces, int creatureDefense) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
                
        
}

