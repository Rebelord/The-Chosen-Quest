/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.GameControl;
import byui.cit260.theChosenQuest.control.MovementController;
import byui.cit260.theChosenQuest.model.Location;
import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.exception.MovementException;
import java.util.Scanner;
import thechosenquest.TheChosenQuest;
import static thechosenquest.TheChosenQuest.player;

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
                  + "\n     L - View Location & Map"
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
            case "L": // Bring up the Game Map & Location
                this.viewMap();
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
        
            try {
                movePlayer.moveNorth(TheChosenQuest.getCurrentGame());
                System.out.println("You move North");
                GameControl find = new GameControl();
                find.findCreature(player);
                find.findShop(player);
            } catch (MovementException me) {
                System.out.println("You cannot move North");
            }
    }

    private void moveSouth() {
        MovementController movePlayer = new MovementController();
       
        try {
            movePlayer.moveNorth(TheChosenQuest.getCurrentGame());
            System.out.println("You move South");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            System.out.println("You cannot move South");
        }
    }

    private void moveEast() {
        MovementController movePlayer = new MovementController();
        try {
                movePlayer.moveNorth(TheChosenQuest.getCurrentGame());
                System.out.println("You move East");
                GameControl find = new GameControl();
                find.findCreature(player);
                find.findShop(player);
            } catch (MovementException me) {
                System.out.println("You cannot move East");
            }
    }

    private void moveWest() {
        MovementController movePlayer = new MovementController();
        try {
                movePlayer.moveNorth(TheChosenQuest.getCurrentGame());
                System.out.println("You move West");
                GameControl find = new GameControl();
                find.findCreature(player);
                find.findShop(player);
            } catch (MovementException me) {
                System.out.println("You cannot move West");
            }
    }

    private void gameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();                        
    }

    private void viewMap() {
        System.out.println(TheChosenQuest.getCurrentGame().getMap().getMapString());
        Location currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation();
        System.out.println("You are currently at: (" + currentLocation.getRow() + "," + currentLocation.getCol() +") Type: " + currentLocation.getType());
    }

}
