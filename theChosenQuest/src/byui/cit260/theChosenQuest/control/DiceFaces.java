/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

// Imports the needed support for the random function.
import java.util.Random;
/**
 *
 * @author Zack Durbin
 */
public class DiceFaces{
        public int rollTheDice(int diceChoice){
            
            // Intializing needed variables.
            int roll = 0;
            Random rand = new Random();
            
            // Sanity Check
            if ((diceChoice != 20) && (diceChoice != 10) && (diceChoice != 8) && (diceChoice != 8) && (diceChoice != 6)) {
                return -1;
            }
            
            // Roll the dice depending on diceChoice.
            switch (diceChoice) {
                case 20:
                    roll = rand.nextInt(20) + 1;
                    break;
                case 10:
                    roll = rand.nextInt(10) + 1;
                    break;
                case 8:
                    roll = rand.nextInt(8) + 1;
                    break;
                case 6:
                    roll = rand.nextInt(6) + 1;
                    break;
                default:
                    break;
            }
            return roll;
        }
}
