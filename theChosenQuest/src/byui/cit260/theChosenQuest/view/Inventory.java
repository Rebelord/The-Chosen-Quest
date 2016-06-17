/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;

/**
 *
 * @author ryandanielwebb
 */
public class Inventory extends View {
    
    public Inventory() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                     Inventory                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| 1 - (Dynamic List Item, Future Implmentation)        |"
                  + "\n| 2 - (Dynamic List Item, Future Implmentation)        |"
                  + "\n| 3 - (Dynamic List Item, Future Implmentation)        |"
                  + "\n| 4 - (Dynamic List Item, Future Implmentation)        |"
                  + "\n| 5 - (Dynamic List Item, Future Implmentation)        |"
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
            case "1": // Show Dynamic List Item.
            case "2":
            case "3":
            case "4":
            case "5":
                
            case "U": // Use Item
                this.loadUseItem();
                break;
            case "D": // Drop Item
                this.loadDropItem();
                break;
            case "E": // Equip Item
                this.loadEquipItem();
                break;
            default:
                System.out.println("\n*** Butterfingers Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void loadUseItem() {
        System.out.println("\n*** Call UseItem Stub ***");
    }

    private void loadDropItem() {
        System.out.println("\n*** Call DropItem Stub ***");
    }

    private void loadEquipItem() {
        System.out.println("\n*** Call EquipItem Stub ***");
    }
    
}