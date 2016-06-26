/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.MovementController;
import java.util.Scanner;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author Dewy
 */
public class MovementView extends View {
    
    public MovementView() {
              super("\n In which direction would thou wish to travel?"
                  + "\n Please type your answer."
                  + "\n"
                  + "\n You may travel..."
                  + "\n     N - North"
                  + "\n     S - South"
                  + "\n     E - East"
                  + "\n     W - West"
                  + "\n     M - Menu");
    }

    @Override
    public boolean doAction(String movementOption) {
        movementOption = movementOption.toUpperCase(); // Convert choice to Lowercase.
        System.out.println(movementOption);
        switch (movementOption) {
            case "N": // Select travel North.
                this.moveNorth();
                break;
            case "S": // Select travel South.
                this.moveSouth();
                break;
            case "E": // Select travel East.
                this.moveEast();
                break;
            case "W": // Select travel West.
                this.moveWest();
                break;
            case "M":
                this.gameMenu();
                break;
            default:
                System.out.println("\n Lets try this again, shall we.");
                break;
        }
        
        return false;
    }

    
    private void moveNorth() {
        MovementController movePlayer = new MovementController();
            if(movePlayer.moveNorth(TheChosenQuest.getCurrentGame()) == false) {
            System.out.println("You cannot move there");
            } 
    }

    private void moveSouth() {
       MovementController movePlayer = new MovementController();
        if(movePlayer.moveSouth(TheChosenQuest.getCurrentGame()) == false) {
            System.out.println("You cannot move there");
        }
        }
        

    private void moveEast() {
       MovementController movePlayer = new MovementController();
        if(movePlayer.moveEast(TheChosenQuest.getCurrentGame()) == false) {
            System.out.println("You cannot move there");
        }
        }
        
        
        

    private void moveWest() {
        MovementController movePlayer = new MovementController();
        if(movePlayer.moveWest(TheChosenQuest.getCurrentGame()) == false) {
            System.out.println("You cannot move there");
        }
        }

    private void gameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();                        
    }

}
