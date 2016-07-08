/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dewy
 */
public class CheckHealthTest {
    
    public CheckHealthTest() {
    }

    /**
     * Test of checkHealth method, of class CheckHealth.
     */
    @Test
    public void testCheckHealth() {
        int health = 0;
        int poison = 0;
        boolean rest = false;
        int charMaxHealth = 0;
        CheckHealth instance = new CheckHealth();
        int expResult = -1;
        int result = instance.checkHealth(health, poison, rest, charMaxHealth);
        
        console.println("checkHealth Test Case #1");
        health = 30;
        poison = 20;
        rest = false;
        charMaxHealth = 100;
        expResult = 10;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
        
        console.println("checkHealth Test Case #2");
        health = 45;
        poison = 5;
        rest = false;
        charMaxHealth = 100;
        expResult = 40;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
        
        console.println("checkHealth Test Case #3");
        health = -20;
        poison = 0;
        rest = false;
        charMaxHealth = 0;
        expResult = -1;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
        
        console.println("checkHealth Test Case #4");
        health = 15;
        poison = 0;
        rest = false;
        charMaxHealth = 0;
        expResult = -1;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
        
        console.println("checkHealth Test Case #5");
        health = 6;
        poison = 0;
        rest = true;
        charMaxHealth = 100;
        expResult = 100;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
        
        console.println("checkHealth Test Case #6");
        health = 10;
        poison = 5;
        rest = false;
        charMaxHealth = 100;
        expResult = 5;
        result = instance.checkHealth(health, poison, rest, charMaxHealth);
        assertEquals(expResult, result);
    }
    
}
