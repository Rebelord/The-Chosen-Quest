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
        System.out.println("InventoryController Test Case #1A");
        boolean addItem = true;
        boolean subtractItem = true;
        int itemWeightA = 10;
        int itemWeightB = 0;
        int bagSize = 50;
        int bagWeight = 20;
        int playerMaxWeight = 0;
        InventoryController instance = new InventoryController();
        int expResultA = 10;
        int expResultB = 0;
        int result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #1B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
        // Test Case 2
        System.out.println("InventoryController Test Case #2A");
        addItem = false;
        subtractItem = true;
        itemWeightA = 10;
        itemWeightB = 0;
        bagSize = 50;
        bagWeight = 2;
        playerMaxWeight = 150;
        expResultA = -1;
        expResultB = 0;
        result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #2B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
        // Test Case 3
        System.out.println("InventoryController Test Case #3A");
        addItem = false;
        subtractItem = false;
        itemWeightA = 0;
        itemWeightB = 0;
        bagSize = 0;
        bagWeight = 0;
        playerMaxWeight = 0;
        expResultA = 0;
        expResultB = 0;
        result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #3B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
        
        // Test Case 4
        System.out.println("InventoryController Test Case #4A");
        addItem = false;
        subtractItem = false;
        itemWeightA = 0;
        itemWeightB = 0;
        bagSize = 0;
        bagWeight = 0;
        playerMaxWeight = 0;
        expResultA = 0;
        expResultB = 0;
        result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #4B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
        
        // Test Case 5
        System.out.println("InventoryController Test Case #5A");
        addItem = false;
        subtractItem = false;
        itemWeightA = 0;
        itemWeightB = 0;
        bagSize = 0;
        bagWeight = 0;
        playerMaxWeight = 0;
        expResultA = 0;
        expResultB = 0;
        result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #5B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
     
        // Test Case 6
        System.out.println("InventoryController Test Case #6A");
        addItem = false;
        subtractItem = false;
        itemWeightA = 0;
        itemWeightB = 0;
        bagSize = 0;
        bagWeight = 0;
        playerMaxWeight = 0;
        expResultA = 0;
        expResultB = 0;
        result = instance.subtractInventory (subtractItem, itemWeightA, bagWeight, bagSize);
        assertEquals(expResultA, result);
        System.out.println("InventoryController Test Case #6B");
        result = instance.addInventory (addItem, itemWeightB, bagWeight, bagSize, playerMaxWeight);
        assertEquals(expResultB, result);
     
    }
    
}
