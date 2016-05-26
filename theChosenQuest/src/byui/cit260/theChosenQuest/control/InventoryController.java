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
   public int inventoryController (addItem, subtractItem, itemWeight, bagSize, playerMaxWeight){
       int bagWeight = 0;
       int itemWeight = 0;
       boolean subtractItem = true;
       int bagSize = 0;
      
     // Controller gets item weight from itemList
     // Controller gets bag size itemList
     // Controller gets playerMaxWeight from CharacterSheet
     subtractItem (subtractItem, bagWeight,bagSize);{
           if (subtractItem = true) {
               
                int newWeight = bagWeight-itemWeight;
                     if (newWeight<0) { 
                        return = -1 ;}
                        else 
                         return = (bagWeight==newWeight);
                        }
        }
       boolean addItem = false;
       int playerMaxWeight = 0;
     addInventory(addItem, bagWeight,bagSize, playerMaxWeight){
       if (addItem = true){
           int newWeight = bagWeight + itemWeight;
           int bagRoom = 0;
           bagRoom++;
           If (playerMaxWeight > newWeight); and (bagRoom <= bagSize);
           return = (bagWeight == newWeight);
           else (playerMaxWeight < newWeight)then
                   newWeight -= bagWeight;
                   return = "You can not carry this item, it is " + newWeight + "too heavy.";
                   
                   else if (bagRoom > bagSize) then
                           return= "You do not have enought room in your bag for this item";
       }
       }
     }

    private void subtractItem(boolean subtractItem, int bagWeight, int bagSize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

  