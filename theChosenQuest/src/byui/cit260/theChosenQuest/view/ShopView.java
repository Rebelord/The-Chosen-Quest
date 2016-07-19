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
            console.println("Your Choice: " + choice);
        } catch (NumberFormatException nfe) {
            console.println("Bad number input.");
        }

        List<Equipment> equipmentList = GameControl.createEquipmentList();
        List<Equipment> playerEquipment = player.getPlayerEquipment();
        byui.cit260.theChosenQuest.model.Inventory inventory = player.getInventory();

        choice -= 1;
        int gold = player.getInventory().getGold();
        int cost = equipmentList.get(choice).getCost();
        int left = gold - cost;

        if (left < 0) {
            console.println("\n*** You don't have enough gold for that item. ***");
        } else {
            String value = ""; // Value to be returned.
            boolean valid = false; // Set flag to not done.

            while (!valid) { // Loop while an invalid value is enter.
                console.println("You have " + gold + " gold.\tGold after purchase: " + left + " gold");
                console.println("Buying: " + equipmentList.get(choice).getName() + "\tPrice: " + cost);
                console.println("\nConfirm ye purchase Y/N:");

                try {
                    value = keyboard.nextLine(); // Get the next line typed on the keyboard.
                } catch (Exception e) {
                    throw new RuntimeException("Error reading input");
                }

                value = value.trim(); // Trim off the blanks.
                value = value.toUpperCase(); // Uppercase.
                console.println(value);
                
                if (value.length() < 1) {
                    console.println("\n Invalid input: please try again");
                    continue;
                }

                break; // end the look
            }

            switch (value) {
                case "Y":
                    // Apply cost
                    gold -= cost;
                    inventory.setGold(gold);
                    player.setInventory(inventory);

                    // Add Item to equipment
                    playerEquipment.add(equipmentList.get(choice));
                    player.setPlayerEquipment(playerEquipment);

                    console.println("You have purchased: " + equipmentList.get(choice).getName() + "\tGold after purchase: " + left + " gold");
                    break;
                case "N": // Use Item
                    console.println("*** Purchase Cancelled! ***");
                    break;
                default:
                    console.println("\n*** Butterfingers Error *** Please try again!");
                    break;
            }
            
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
