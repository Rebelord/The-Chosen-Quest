/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

/**
 * If we want to separate this out heres a good break down. -Ryan Webb
 * @author Zack Durbin
 */
class subtractItem {
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
}
