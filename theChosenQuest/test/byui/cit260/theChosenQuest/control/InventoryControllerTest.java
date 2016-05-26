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
     * Test of inventoryController method, of class InventoryController.
     */
    @Test
    public void testInventoryController() {
        System.out.println("inventoryController");
        addItem = null;
        subtractItem <error>_2 = null;
        itemWeight <error>_3 = null;
        bagSize <error>_4 = null;
        playerMaxWeight <error>_5 = null;
        InventoryController instance = new InventoryController();
        int expResult = 0;
        int result = instance.inventoryController(<error>, <error>_2, <error>_3, <error>_4, <error>_5);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
