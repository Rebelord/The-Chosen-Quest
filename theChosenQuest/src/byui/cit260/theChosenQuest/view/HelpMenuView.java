/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

/**
 *
 * @author Zack Durbin
 */
public class HelpMenuView extends View{
    
    // Display the Help Menu
    public HelpMenuView() {
              super("\n"
                  + "\n--------------------------------------------------------"
                  + "\n|                Divine Assitance Menu                 |"
                  + "\n--------------------------------------------------------"
                  + "\n| G - The Goal of your Quest.                          |"
                  + "\n| M - Movement and how to use your lower limbs.        |"
                  + "\n| L - Map & Legend guide.                              |"
                  + "\n| C - Combat, The Idiot's Guide to your Defense.       |"
                  + "\n| N - Non-Sentient beings and their role.              |"
                  + "\n| I - Inventory, Finders Keepers rules apply.          |"
                  + "\n| Q - Quit, stop the divine assistance, please.        |"
                  + "\n--------------------------------------------------------");
    }

    @Override
    public boolean doAction(String menuOption) {
    menuOption = menuOption.toUpperCase(); // Convert choice to Uppercase.
    
        switch (menuOption) {
            case "G": // Show the Game Goal.
                this.loadGoalInfo();
                break;
            case "M": // Show game movement information.
                this.loadMovementInfo();
                break;
            case "C": // Show game combat information.
                this.loadCombatInfo();
                break;
            case "N": // Show game NPC Interaction info.
                this.loadNpcInfo();
                break;
            case "I": // Show Inventory Management info.
                this.loadInventoryInfo();
                break;
            case "L":
                this.loadLegendInfo();
                break;
            default:
                console.println("\n*** Divine Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void loadGoalInfo() {
        console.println("\n*** Your quest, should you chose to accept it is"
                         +  "\n to transverse the town of Elspeth to find the" +
                            "\n cause of all the troubles that have befallen" +
                            "\n the poor towns people. Can you survive the " +
                            "\n hordes of monsters and bring peace back to" +
                            "\n the land?*** You must locate and defeat the" +
                            "\n Dragon to bring peace back to the land. Be" +
                            "\n wary player, for you are crunchy and taste good" +
                            "\n with ketchup!");
    }

    private void loadMovementInfo() {
        console.println("\n*** This option will explain how to move your feet"+
                            "\n so that you can get from one area to the next." +
                            "\n If you wish to move North, provided you are able" +
                            "\n press 'N', 'S' for south, 'E' for east and" +
                            "\n 'W' for west.***");
    }

    private void loadCombatInfo() {
        console.println("\n*** As you transverse the map you will come across" +
                "\n monsters that will engage you in combat. To attack press 'A'" +
                "\n to defend press 'D', to use a potion press 'P' and to run " +
                "\n press 'R'. Hitting your enemy and them hitting you is randomly" +
                "\n determined. Damage done is based a predetermined dice roll added" +
                "\n to your strength and attack bonus (displayed).***");
    }

    private void loadNpcInfo() {
        console.println("\n*** This will have information on how to interact" +
                "\n with the NPCs of the game. This would include shops, POI's," +
                "\n and the like. NPCs will occasionally appear in Taverns and" +
                "\n Encampments to give you information that may help you along" +
                "\n your quest. The shop keeper will also buy and sell you new" +
                "\n equipment to help further your cause.***");
    }

    private void loadInventoryInfo() {
        console.println("\n*** This will explain how to equip items you find"+
                "\n look at items, and a brief description of the different items***");
    }

    private void loadLegendInfo() {
        console.println("\n *** This is an explination on how to read your map." +
                        "\n You start in the location 0,0 which is in the top" +
                        "\n left corner of the map. Each letter represents a" +
                        "\n certain location type.\n\nThose location types are as follows:" +
                        "\n T - Tavern" +
                        "\t S - Shop" +
                        "\n E - Encampment" +
                        "\t C - Crypt" +
                        "\n L - Shallow Lake" +
                        "\t F - Field"+
                        "\n Thou mayest only slumber at Taverns and Encampments.");
    }

}
