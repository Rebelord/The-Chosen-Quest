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
        boolean addItem = true;
        boolean subtractItem = true;
        int itemWeight = 10;
        int bagSize = 50;
        int bagWeight = 20;
        int playerMaxWeight = 0;
        InventoryController instance = new InventoryController();
        int expResultA = 10;
        int expResultB = 0;
        int result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);

        // Test Case 2
        System.out.println("InventoryController Test Case #2");
        addItem = false;
        subtractItem = true;
        itemWeight = 10;
        bagSize = 50;
        bagWeight = 2;
        playerMaxWeight = 150;
        expResultA = -1;
        result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);
        
        // Test Case 3
        System.out.println("InventoryController Test Case #3");
        addItem = true;
        subtractItem = false;
        itemWeight = -10;
        bagSize = 10;
        bagWeight = 8;
        playerMaxWeight = 100;
        expResultA = -3;
        result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);
        
        // Test Case 4
        System.out.println("InventoryController Test Case #4");
        addItem = false;
        subtractItem = true;
        itemWeight = 5;
        bagSize = 20;
        bagWeight = 15;
        playerMaxWeight = 75;
        expResultA = 10;
        result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);
        
        // Test Case 5
        System.out.println("InventoryController Test Case #5");
        addItem = true;
        subtractItem = false;
        itemWeight = 10;
        bagSize = 5;
        bagWeight = 5;
        playerMaxWeight = 90;
        expResultA = -1;
        result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);
     
        // Test Case 6
        System.out.println("InventoryController Test Case #6");
        addItem = false;
        subtractItem = false;
        itemWeight = 5;
        bagSize = 15;
        bagWeight = 10;
        playerMaxWeight = 125;
        expResultA = 10;
        result = instance.inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight, bagWeight);
        assertEquals(expResultA, result);
    }
    
}
