/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import static byui.cit260.theChosenQuest.control.GameControl.showPlayerEquipment;
import byui.cit260.theChosenQuest.control.InventoryController;
import byui.cit260.theChosenQuest.exception.InventoryError;

/**
 *
 * @author ryandanielwebb
 */
public class InventoryView extends View {
    
    public InventoryView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                     Inventory                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| S - Show Inventory                                   |"
                  + "\n| U - Use Item                                         |"
                  + "\n| D - Drop an Item from Inventory                      |"
                  + "\n| E - Equip Item on your Character                     |"
                  + "\n| Q - Resume Game                                      |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String inventoryOption) {
    inventoryOption = inventoryOption.toUpperCase(); // Convert choice to Uppercase.
    
        switch (inventoryOption) {
            case "S":
                this.showInventory();
                break;
            case "U": // Use Item
                this.loadUseItem();
                break;
            case "D": // Drop Item
                this.loadDropItem();
                break;
            case "E": // Equip Item
                this.loadEquipItem();
                break;
            case "Q":
                this.GameMenuView();
                break;
            default:
                console.println("\n*** Butterfingers Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void loadUseItem() {
        console.println("\n*** Call UseItem Stub ***");
    }

    private void loadDropItem() {
        try {
            boolean addItem = false;
            boolean subtractItem = false;
            int itemWeight = 10;
            int playerMaxWeight = 100;
            int bagWeight = 50;
            
            // Add some real working variables.
            InventoryController bagMule = new InventoryController();
            bagMule.inventoryController(addItem, subtractItem, itemWeight, playerMaxWeight, bagWeight);
        } catch (InventoryError ie) {
            console.println("You must drop an item");
        }
    }

    private void loadEquipItem() {
        console.println("\n*** Call EquipItem Stub ***");
    }

    private void GameMenuView() {
        GameMenuView GameMenuView =  new GameMenuView();
        GameMenuView.display();
    }

    private void showInventory() {
        // Display players equipment.
        showPlayerEquipment();
    }
}