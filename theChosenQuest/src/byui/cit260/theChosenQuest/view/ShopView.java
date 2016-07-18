/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import static byui.cit260.theChosenQuest.control.GameControl.listShopInventory;
import byui.cit260.theChosenQuest.model.Equipment;
import java.util.List;
import java.util.Scanner;
import static thechosenquest.TheChosenQuest.player;

/**
 *
 * @author Zack Durbin
 */
public class ShopView extends View {
    
     public ShopView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                     Shop Menu                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| I - Shop Item List                                   |"
                  + "\n| B - Buy Item                                         |"  
                  + "\n| S - Sell Item                                        |"    
                  + "\n| E - Exit Shop                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // Convert choice to Uppercase.
    
        switch (menuOption) {
            case "I": // Creates Item List
                this.EquipmentList();
                break;
            case "B":
                this.buyItem();
                break;
            case "S":
                this.sellItem();
                break;
            case "E":
                this.resumeGame();
            default:
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void EquipmentList() {
        console.println("\nHere's what I have to offer:\n");
        
        listShopInventory();
    }

    private void buyItem() {
        console.println("\nWhich item would you like to buy?\nType in the item number:");
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

    private void sellItem() {
        console.println("Sell an item");
    }

    private void resumeGame() {
       console.println("\n Good Luck! *low mumble* you'll need it.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
