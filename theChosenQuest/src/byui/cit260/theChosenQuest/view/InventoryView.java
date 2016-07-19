/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import static byui.cit260.theChosenQuest.control.GameControl.showPlayerEquipment;
import byui.cit260.theChosenQuest.model.Equipment;
import java.util.List;
import java.util.Scanner;
import static thechosenquest.TheChosenQuest.player;

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
        console.println("\nWhich item would you like to drop?\nType in the item number:");
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        try {
            input = keyboard.nextLine();
        } catch (Exception e) {
            //buried
        }

        int choice = 0;
        try {
            choice = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            console.println("Bad number input.");
        }
        
        List<Equipment> equipmentList = GameControl.createEquipmentList();
        List<Equipment> playerEquipment = player.getPlayerEquipment();
        byui.cit260.theChosenQuest.model.Inventory inventory = player.getInventory();
        
        choice =+ 1;
        int gold = player.getInventory().getGold();
        int cost = equipmentList.get(choice).getCost();
        console.println(gold + "gold " + cost + "cost");
        
        // Check if player can afford item.
        if (gold >= cost) {
            
            // Apply cost
            gold -= cost;
            inventory.setGold(gold);
            player.setInventory(inventory);
            
            // Add Item to equipment
            playerEquipment.add(equipmentList.get(choice));
            player.setPlayerEquipment(playerEquipment);
            
        } else {
            
            console.println("\n*** You don't have enough gold for that item. ***");
            
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