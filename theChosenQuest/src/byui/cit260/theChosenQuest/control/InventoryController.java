/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

/**
 *
 * @author Zack Durbin
 */
public class InventoryController {
    public int inventoryController (boolean addItem, boolean subtractItem, int itemWeight, int bagSize, int playerMaxWeight, int bagWeight){
       int newWeight = 0;
        if ((subtractItem == false) & (addItem == false)){
            newWeight = -1;
        } else if (subtractItem == true) {
                newWeight = bagWeight - itemWeight;
                   if (newWeight < 0) { 
                       newWeight = -1;
                    } else {
                        return (bagWeight = newWeight);
                    }
               }
        if (addItem == true){
            newWeight = bagWeight + itemWeight;
            int bagRoom = 0;
            bagRoom++;
            if (itemWeight < 0) {
                newWeight = -3;
                }else if ((playerMaxWeight > newWeight) | (bagRoom <= bagSize)) {
                    bagWeight = newWeight;
                } else if (playerMaxWeight < newWeight){
                    bagWeight = -1;       
                } else if (bagRoom > bagSize) {
                    bagWeight = -2;
                }
       }
        return newWeight;
    }
     // Controller gets item weight from itemList
     // Controller gets bag size itemList
     // Controller gets playerMaxWeight from CharacterSheet
    public int subtractInventory (boolean subtractItem, int itemWeight, int bagWeight, int bagSize, boolean addItem) {
        int newWeight = 0;
        if ((subtractItem == false) & (addItem == false)){
            newWeight = -1;
        } else if (subtractItem == true) {
                newWeight = bagWeight - itemWeight;
                   if (newWeight < 0) { 
                       newWeight = -1;
                    } else {
                        return (bagWeight = newWeight);
                    }
               }
        return newWeight;
    }
       /*boolean addItem = false;
       int playerMaxWeight = 0;*/
    public int addInventory (boolean addItem, int itemWeight, int bagWeight, int bagSize, int playerMaxWeight) {
        if (addItem == true){
            int newWeight = bagWeight + itemWeight;
            int bagRoom = 0;
            bagRoom++;
            if (itemWeight < 0) {
                bagWeight = -3;
                }else if ((playerMaxWeight > newWeight) | (bagRoom <= bagSize)) {
                    bagWeight = newWeight;
                } else if (playerMaxWeight < newWeight){
                    bagWeight = -1;       
                } else if (bagRoom > bagSize) {
                    bagWeight = -2;
                }
       }
       return bagWeight;
    }
     

    private void subtractItem(boolean subtractItem, int bagWeight, int bagSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

  