/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.CheckHealth;
import byui.cit260.theChosenQuest.control.GameControl;
import byui.cit260.theChosenQuest.control.MovementController;
import byui.cit260.theChosenQuest.exception.LoseGameException;
import byui.cit260.theChosenQuest.model.Location;
import byui.cit260.theChosenQuest.exception.MovementException;
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
                + "\n     R - Rest"
//                + "\n     D - Drink Poison!!!!"
                + "\n     L - View Location & Map"
                + "\n     M - Game Menu");
    }

    @Override
    public boolean doAction(String movementOption) {
        movementOption = movementOption.toUpperCase(); // Convert choice to Lowercase.
        console.println(movementOption);
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
            case "R": // Take time to rest.
                this.takeNap();
                break;
//            case "D": // Drink poison to test poison tracking.
//                this.drinkPoison();
//                break;
            case "L": // Bring up the Game Map & Location
                this.viewMap();
                break;
            case "M":
                this.gameMenu();
                break;
            default:
                console.println("\n Lets try this again, shall we.");
                break;
        }

        return false;
    }

    private void moveNorth() {

        MovementController movePlayer = new MovementController();

        try {
            movePlayer.moveNorth(TheChosenQuest.getCurrentGame());
            console.println("You move North");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            console.println("You cannot move North");
        }
//        // Health check on movement for poisons.
//        try {
//            boolean rest = false;
//            CheckHealth life = new CheckHealth();
//            int health = life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
//            player.setHealth(health);
//        } catch (LoseGameException wipe) {
//            // Yippee Ki Yay Mam
//            console.println("\n***** Wipe yourself off, you dead! *****");
//        } finally {
//            console.println("\nHealth: " + player.getHealth());
//        }
    }

    private void moveSouth() {
        MovementController movePlayer = new MovementController();

        try {
            movePlayer.moveSouth(TheChosenQuest.getCurrentGame());
            console.println("You move South");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            console.println("You cannot move South");
        }   
//        // Health check on movement for poisons.
//        try {
//            boolean rest = false;
//            CheckHealth life = new CheckHealth();
//            int health = life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
//            player.setHealth(health);
//        } catch (LoseGameException wipe) {
//            // Yippee Ki Yay Mam
//            console.println("\n***** Wipe yourself off, you dead! *****");
//        } finally {
//            console.println("\nHealth: " + player.getHealth());
//        }
    }
    private void moveEast() {
        MovementController movePlayer = new MovementController();
        try {
            movePlayer.moveEast(TheChosenQuest.getCurrentGame());
            console.println("You move East");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            console.println("You cannot move East");
        }
//        // Health check on movement for poisons.
//        try {
//            boolean rest = false;
//            CheckHealth life = new CheckHealth();
//            int health = life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
//            player.setHealth(health);
//        } catch (LoseGameException wipe) {
//            // Yippee Ki Yay Mam
//            console.println("\n***** Wipe yourself off, you dead! *****");
//        } finally {
//            console.println("\nHealth: " + player.getHealth());
//        }
    }

    private void moveWest() {
        MovementController movePlayer = new MovementController();
        try {
            movePlayer.moveWest(TheChosenQuest.getCurrentGame());
            console.println("You move West");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            console.println("You cannot move West");
        }
//        // Health check on movement for poisons.
//        try {
//            boolean rest = false;
//            CheckHealth life = new CheckHealth();
//            int health = life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
//            player.setHealth(health);
//        } catch (LoseGameException wipe) {
//            // Yippee Ki Yay Mam
//            console.println("\n***** Wipe yourself off, you dead! *****");
//        } finally {
//            console.println("\nHealth: " + player.getHealth());
//        }
    }

    private void gameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewMap() {
        console.println("\n\n---------------------------------");
        console.println(TheChosenQuest.getCurrentGame().getMap().getMapString());
        console.println("---------------------------------");
        Location currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation();
        console.println("Legend: T - Tavern | S - Shop | C - Crypt | E - Encampment | L - Shallow Lake | F - Field\n");
        console.println("You are currently at: (" + currentLocation.getRow() + "," + currentLocation.getCol() + ") Type: " + currentLocation.getType() + "\n");
    }

    private void takeNap() {
        // Limite rest to Camp and Tavern.
        GameControl find = new GameControl();
        if (find.findRestStop(player)) {
            try {
                // Initalize rest
                boolean rest = true;
                CheckHealth life = new CheckHealth();
                // Check rest state and apply.
                int health = life.checkHealth(player, rest);
                player.setHealth(health);
            } catch (LoseGameException wipe) {
                // Yippee Ki Yay Mam
                console.println("\n***** Wipe yourself off, you dead! *****");
            } finally {
                console.println("\nHealth: " + player.getHealth());
            }
        } else
            console.println("You may only rest at a Tavern or Camp.\n");
    }

//    private void drinkPoison() {
//        try {
//            boolean rest = false;
//            player.setPoison(5); // Muhahahaha!!!!!
//            CheckHealth life = new CheckHealth();
//            int health = life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
//            player.setHealth(health);
//        } catch (LoseGameException wipe) {
//            // Yippee Ki Yay Mam
//            console.println("\n***** Wipe yourself off, you dead! *****");
//        } finally {
//            console.println("\nHealth: " + player.getHealth());
//        }
//    }

}
