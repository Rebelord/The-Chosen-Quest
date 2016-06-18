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
                  + "\n| S - Save Game                                        |"
                  + "\n| L - Load Game                                        |"
                  + "\n| Q - Quit Game                                        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "R": // Create and Start a new game.
                this.resumeGame();
                break;
            case "S": // Load up a saved game
                this.saveGame();
                break;
            case "L": // Display the help menu.
                this.loadGame();
                break;
            case "Q": // Save the current game.
                this.quitGame();
                break;
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
        System.out.println("\n*** Maybe in the future, lol.");
    }

    private void loadGame() {
        System.out.println("\n*** Uh what, lol.");
    }

    private void quitGame() {
        MainMenuView mainMenu = new MainMenuView();
        mainMenu.display();
    }
    
}
