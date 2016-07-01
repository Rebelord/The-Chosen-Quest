/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import static byui.cit260.theChosenQuest.control.GameControl.listShopInventory;
import byui.cit260.theChosenQuest.model.Equipment;
import byui.cit260.theChosenQuest.model.Game;
import thechosenquest.TheChosenQuest;

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
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
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
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void EquipmentList() {
        System.out.println("Here is what I have to offer:");
        
        listShopInventory();
    }

    private void buyItem() {
        System.out.println("buy an item");
    }

    private void sellItem() {
        System.out.println("Sell an item");
    }

    private void resumeGame() {
       System.out.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
