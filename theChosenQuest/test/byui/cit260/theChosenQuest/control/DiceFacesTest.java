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
public class DiceFacesTest {
    
    public DiceFacesTest() {
    }

    /**
     * Test of rollTheDice method, of class DiceFaces.
     */
    @Test
    public void testRollTheDice() {
        int diceChoice;
        int expResult;
        int result;
        DiceFaces instance = new DiceFaces();
        
        System.out.println("rollTheDice Test Case #1");
        diceChoice = 5;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
        
        System.out.println("rollTheDice Test Case #2");
        diceChoice = 20;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
        
        System.out.println("rollTheDice Test Case #3");
        diceChoice = 5;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
        
        System.out.println("rollTheDice Test Case #4");
        diceChoice = 5;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
        
        System.out.println("rollTheDice Test Case #5");
        diceChoice = 5;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
        
        System.out.println("rollTheDice Test Case #6");
        diceChoice = 5;
        expResult = -1;
        result = instance.rollTheDice(diceChoice);
        assertEquals(expResult, result);
    }
    
}
