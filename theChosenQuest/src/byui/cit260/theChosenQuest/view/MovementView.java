/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;

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
                  + "\n     Q - None");
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
            default:
                System.out.println("\n Lets try this again, shall we.");
                break;
        }
        
        return false;
    }

    private void moveNorth() {
        System.out.println("\n You begin to travel North!");
        NpcView npcChat = new NpcView();
        npcChat.display();
    }

    private void moveSouth() {
        System.out.println("\n You begin to travel South!");
        NpcView npcChat = new NpcView();
        npcChat.display();
    }

    private void moveEast() {
        System.out.println("\n You begin to travel East!");
        NpcView npcChat = new NpcView();
        npcChat.display();
    }

    private void moveWest() {
        System.out.println("\n You begin to travel West!");
        NpcView npcChat = new NpcView();
        npcChat.display();
    }

}
