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
    return -1;
    }   /*int bagWeight = 0;
       int itemWeight = 0;
       boolean subtractItem = true;
       int bagSize = 0;*/
      
     // Controller gets item weight from itemList
     // Controller gets bag size itemList
     // Controller gets playerMaxWeight from CharacterSheet
    public int subtractInventory (boolean subtractItem, int itemWeight, int bagWeight, int bagSize) {
        int newWeight = 0;
        if (subtractItem = true) {
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
        if (addItem = true){
            int newWeight = bagWeight + itemWeight;
            int bagRoom = 0;
            bagRoom++;
            if ((playerMaxWeight > newWeight) | (bagRoom <= bagSize)) {
                bagWeight = newWeight;
            } else if (playerMaxWeight < newWeight){
                bagWeight = -1;       
            }else if (bagRoom > bagSize) {
                bagWeight = -2;
            }
       }
       return bagWeight;
    }
     

    private void subtractItem(boolean subtractItem, int bagWeight, int bagSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

  