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
            case "R": // Take time to rest.
                this.takeNap();
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
        // Health check on movement for poisons.
        try {
            boolean rest = false;
            CheckHealth life = new CheckHealth();
            life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
        } catch (LoseGameException wipe) {
            // Yippee Ki Yay Mam
            System.out.println("***** Wipe yourself off, you dead! *****");
        }
    }

    private void moveSouth() {
        MovementController movePlayer = new MovementController();

        try {
            movePlayer.moveSouth(TheChosenQuest.getCurrentGame());
            System.out.println("You move South");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            System.out.println("You cannot move South");
        }
        // Health check on movement for poisons.
        try {
            boolean rest = false;
            CheckHealth life = new CheckHealth();
            life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
        } catch (LoseGameException wipe) {
            // Yippee Ki Yay Mam
            System.out.println("***** Wipe yourself off, you dead! *****");
        }
    }

    private void moveEast() {
        MovementController movePlayer = new MovementController();
        try {
            movePlayer.moveEast(TheChosenQuest.getCurrentGame());
            System.out.println("You move East");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            System.out.println("You cannot move East");
        }
        // Health check on movement for poisons.
        try {
            boolean rest = false;
            CheckHealth life = new CheckHealth();
            life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
        } catch (LoseGameException wipe) {
            // Yippee Ki Yay Mam
            System.out.println("***** Wipe yourself off, you dead! *****");
        }
    }

    private void moveWest() {
        MovementController movePlayer = new MovementController();
        try {
            movePlayer.moveWest(TheChosenQuest.getCurrentGame());
            System.out.println("You move West");
            GameControl find = new GameControl();
            find.findCreature(player);
            find.findShop(player);
        } catch (MovementException me) {
            System.out.println("You cannot move West");
        }
        // Health check on movement for poisons.
        try {
            boolean rest = false;
            CheckHealth life = new CheckHealth();
            life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
        } catch (LoseGameException wipe) {
            // Yippee Ki Yay Mam
            System.out.println("***** Wipe yourself off, you dead! *****");
        }
    }

    private void gameMenu() {
        GameMenuView gameMenu = new GameMenuView();
        gameMenu.display();
    }

    private void viewMap() {
        Scanner keyboard = new Scanner(System.in);
        // Will move this later to an option to give a bum money.
        String input = "";
        try {
            input = keyboard.nextLine();
        } catch (Exception e) {
            //buried
        }

        int myNum = 0;
        try {
            myNum = Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            System.out.println("Bad number input.");
        }

        System.out.println(TheChosenQuest.getCurrentGame().getMap().getMapString());
        Location currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation();
        System.out.println("You are currently at: (" + currentLocation.getRow() + "," + currentLocation.getCol() + ") Type: " + currentLocation.getType());
    }

    private void takeNap() {
        // Health check on movement for poisons.
        try {
            boolean rest = true;
            CheckHealth life = new CheckHealth();
            life.checkHealth(player.getHealth(), player.getPoison(), rest, player.getMaxHealth());
        } catch (LoseGameException wipe) {
            // Yippee Ki Yay Mam
            System.out.println("***** Wipe yourself off, you dead! *****");
        }
    }

}
