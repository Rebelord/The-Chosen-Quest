/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zack Durbin
 */
public class InventoryControllerTest {
    
    public InventoryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of subtractInventory method, of class InventoryController.
     */
    @Test
    public void testInventoryController() {
        // Test Case 1 Requires variables to be declared as well. 
        System.out.println("InventoryController Test Case #1");
        int addItem = 0;
        boolean subtractItem = true;
        int itemWeight = 10;
        int bagSize = 50;
        int bagWeight = 20;
        int playerMaxWeight = 0;
        InventoryController instance = new InventoryController();
        int expResult = 10;
        int result = instance.subtractInventory (subtractItem, itemWeight, bagWeight, bagSize);
        assertEquals(expResult, result);
        // Test Case 2
        System.out.println("InventoryController Test Case #2");
        subtractItem = true;
        itemWeight = 10;
        bagWeight = 2;
        bagSize = 50;
        expResult = -1;
        result = instance.subtractInventory (subtractItem, itemWeight, bagWeight, bagSize);
        assertEquals(expResult, result);
     
    }
    
}
