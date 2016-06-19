/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

/**
 *
 * @author ryandanielwebb
 */
public class GameMenuView extends View {

    public GameMenuView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                     Game Menu                        |"
                  + "\n--------------------------------------------------------"
                  + "\n| R - Resume Game                                      |"
                  + "\n| M - Menu Options                                     |"    
                  + "\n| S - Save Game                                        |"
                  + "\n| L - Load Game                                        |"
                  + "\n| H - Help Menu                                        |"    
                  + "\n| E - Exit Game                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "R": // Create and Start a new game.
                this.resumeGame();
                break;
            case "M":
                this.optionM();
                break;
            case "S": // Load up a saved game
                this.saveGame();
                break;
            case "L": // Display the help menu.
                this.loadGame();
                break;
            case "H":
                this.helpmenu();
                break;
            case "E":
                System.exit(0);
            default:
                System.out.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void resumeGame() {
        System.out.println("\n*** Good Luck!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void saveGame() {
        System.out.println("\n*** Save Game fucntion called");
    }

    private void loadGame() {
        System.out.println("\n*** Load game function called.");
    }

    private void optionM() {
        System.out.println("You have opened the game menu");
       InGameMenuView gameView = new InGameMenuView();
       gameView.display();
    }

    private void helpmenu() {
        System.out.println("Welcome to the Divine Assistance Menu");
        HelpMenuView helpMenuView = new HelpMenuView();
        helpMenuView.display();
    }

   
    
}
