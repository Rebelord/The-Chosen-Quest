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
        System.out.println("combatDamageController");
        int playerAttackBonus = 0;
        int playerDefense = 0;
        int DiceFaces = 0;
        int creatureAttackBonus = 0;
        int creatureDefense = 0;
        CombatDamageController instance = new CombatDamageController();
        int expResult = 0;
        int result = instance.combatDamageController(playerAttackBonus, playerDefense, DiceFaces, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
      
       
    }
    
}
