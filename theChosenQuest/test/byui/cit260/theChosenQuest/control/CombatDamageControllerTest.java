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
        console.println("combatDamageController test 1");
        int playerAttackBonus = 2;
        int playerDefense = 0;
        int creatureAttackBonus = 0;
        int creatureDefense = 10;
        CombatDamageController instance = new CombatDamageController();
        boolean[] expResult;
        boolean[] attackSuccess;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        boolean[] result;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 2
       
        console.println("combatDamageController test 1");
        playerAttackBonus = 1;
        playerDefense = 0;
        creatureAttackBonus = 0;
        creatureDefense = 10;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 3
        console.println("combatDamageController test 1");
        playerAttackBonus = 3;
        playerDefense = 0;
        creatureAttackBonus = 0;
        creatureDefense = 12;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 4
        console.println("combatDamageController test 1");
        playerAttackBonus = -15;
        playerDefense = 0;
        creatureAttackBonus = 0;
        creatureDefense = 11;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 5
        console.println("combatDamageController test 1");
        playerAttackBonus = 2;
        playerDefense = 0;
        creatureAttackBonus = 0;
        creatureDefense = 10;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
        
        //test 6
        console.println("combatDamageController test 1");
        playerAttackBonus = -3;
        playerDefense = 0;
        creatureAttackBonus = 0;
        creatureDefense = 20;
        attackSuccess = new boolean[2];
        expResult = new boolean[2];
        expResult[0] = true;
        expResult[1] = false;
        result = new boolean[2];
        result = instance.combatDamageController(attackSuccess, playerAttackBonus, playerDefense, creatureAttackBonus, creatureDefense);
        assertEquals(expResult, result);
    }
    
}
