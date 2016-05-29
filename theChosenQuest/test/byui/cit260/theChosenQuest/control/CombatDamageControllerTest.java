/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zack Durbin
 */
public class CombatDamageControllerTest {
    
    public CombatDamageControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of combatDamageController method, of class CombatDamageController.
     */
    @Test
    public void testCombatDamageController() {
        System.out.println("combatDamageController test 1");
        int playerAttackBonus = 2;
        int playerDefense = 0;
        int creatureAttackBonus = 0;
        int creatureDefense = 10;
        CombatDamageController instance = new CombatDamageController();
        int expResult = -1;
        int result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 2
        System.out.println("combatDamageController test 2");
         playerAttackBonus = 1;
         playerDefense = 0;
         creatureAttackBonus = 0;
         creatureDefense = 7;
         expResult = -1;
         result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 3
        System.out.println("combatDamageController test 3");
         playerAttackBonus = 0;
         playerDefense = 0;
         creatureAttackBonus = 0;
         creatureDefense = 0;
         expResult = -1;
         result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 4
        System.out.println("combatDamageController test 4");
         playerAttackBonus = 3;
         playerDefense = 0;
         creatureAttackBonus = 0;
         creatureDefense = 0;
         expResult = 3;
         result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 5
        System.out.println("combatDamageController test 5");
         playerAttackBonus = 0;
         playerDefense = 0;
         
         
         creatureAttackBonus = 0;
         creatureDefense = 0;
         expResult = -1;
         result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 6
        System.out.println("combatDamageController test 6");
         playerAttackBonus = 0;
         playerDefense = 0;
         creatureAttackBonus = 0;
         creatureDefense = 0;
         expResult = -1;
         result = instance.combatDamageController(playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        
      
       
    }
    
}
