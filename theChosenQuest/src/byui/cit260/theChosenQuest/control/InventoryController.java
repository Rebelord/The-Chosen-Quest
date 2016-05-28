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
    public int inventoryController (boolean addItem, boolean subtractItem, int itemWeight, int playerMaxWeight, int bagWeight){
        int newWeight = 0;
        
        // Sanity Check
        if ((subtractItem == false) && (addItem == false)){
            return -1;
        }
        
        
        if (subtractItem == true) {
                newWeight = bagWeight - itemWeight;
                   if (newWeight < 0) { 
                       return -1;
                    } else {
                        return newWeight;
                    }
               }
        if (addItem == true){
            newWeight = bagWeight + itemWeight;
            if (itemWeight < 0) {
                return -3;
                }else if (playerMaxWeight > newWeight) {
                    return newWeight;
                } else if (playerMaxWeight < newWeight){
                    return -1;       
                }
       }
        return newWeight;
    }   
}

  