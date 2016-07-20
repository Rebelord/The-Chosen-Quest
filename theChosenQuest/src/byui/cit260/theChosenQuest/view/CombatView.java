/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.control.CheckHealth;
import byui.cit260.theChosenQuest.control.CombatDamageController;
import byui.cit260.theChosenQuest.control.GameControl;
import byui.cit260.theChosenQuest.exception.LoseGameException;
import byui.cit260.theChosenQuest.exception.WinGameException;
import byui.cit260.theChosenQuest.model.Creatures;
import byui.cit260.theChosenQuest.model.Player;
import static thechosenquest.TheChosenQuest.player;
import byui.cit260.theChosenQuest.model.Inventory;

/**
 *
 * @author ryandanielwebb
 */
public class CombatView extends View {

    public CombatView(Player player) {
        super(" You are under attack by a " + player.getLocation().getCreatures().getName()
                + "\n"
                + "\n You may ...\n"
                + "\n  A - Attack your opponent"
                + "\n  D - Defend against your opponents attack"
                + "\n  P - Drink a potion (if you have one)"
                + "\n  R - Run Away!\n");

        // Call the Combat controller and HealthCheck.
        GameControl game = new GameControl();

        // Get stats for player and creature for fight.
        Creatures creature = player.getLocation().getCreatures();

        // Change hardcoded defense/attack to match armour & weapon.
        int playerAttack = game.weaponAttack(player);
        int playerDefense = game.armourDefense(player);
        console.println("\n---------------------------------");
        console.println("| HP: " + player.getHealth() + "/" + player.getMaxHealth()
                + "\tATK: " + playerAttack + "\tDEF: " + playerDefense + " |");
        console.println("---------------------------------");

    }

    @Override
    public boolean doAction(String combatOption) {
        combatOption = combatOption.toUpperCase(); // Convert choice to Lowercase.
        console.println(combatOption);
        switch (combatOption) {
            case "A": // Select Attack.
                this.Attack();
                break;
            case "D": // Select Defend.
                this.Defend();
                break;
            case "P": // Select Potion.
                this.Potion();
                break;
            case "R": // Select Run.
                this.Run();
                break;
            default:
                console.println("\n Lets try this again, shall we.");
                break;
        }

        return false;
    }

    private void Attack() {

        // Call the Combat controller and HealthCheck.
        GameControl game = new GameControl();
        CombatDamageController combat = new CombatDamageController();

        // Get stats for player and creature for fight.
        Creatures creature = player.getLocation().getCreatures();

        // *****************
        // * Player Attack *
        // *****************
        // Change hardcoded defense/attack to match armour & weapon.
        int playerAttack = game.weaponAttack(player);
        int playerDefense = game.armourDefense(player);
        int weaponDice = game.weaponDice(player);
        int weaponRoll = game.weaponRoll(player);
        int playerStr = player.getStr();

        // Check if player attack was successful.
        boolean attackScucces = combat.attackCheck(playerAttack, creature.getHit());

        // Calculate damage or miss.
        if (attackScucces) {

            // Get damage from attack.
            int damage = combat.playerAttack(playerAttack, creature.getDefense(), weaponDice, weaponRoll, playerStr);
            console.println("\n--------- Player --------");
            console.println("\nYou hit " + creature.getName()
                    + " for " + damage + " damage.\n");

            // Apply damage to creature.
            player.getLocation().getCreatures().setHp(creature.getHp() - damage);

            // Check if creature is still alive.
            if (creature.getHp() > 0) {
                console.println(creature.getName() + " is still alive.\n");
            } else {

                // Display message to user upon creature defeat.
                console.println("*** You've defeated the " + creature.getName() + " ***\n");
                console.println("---------------------------");

                // Disperse rewards to player sometimes.
                Inventory inventory = player.getInventory();
                inventory.setGold(inventory.getGold() + creature.getGoldDrop());
                player.setInventory(inventory);
                console.println("\nYou receive " + creature.getGoldDrop() + " gold.\tGold: "
                        + player.getInventory().getGold() + "\n");

                // Display player current statsm.
                console.println("\n---------------------------------");
                console.println("| HP: " + player.getHealth() + "/" + player.getMaxHealth()
                        + "\tATK: " + playerAttack + "\tDEF: " + playerDefense + " |");
                console.println("---------------------------------");

                // Check for Win Game.
                try {
                    GameControl gameControl = new GameControl();
                    gameControl.dragonCheck(player);
                } catch (WinGameException wge) {
                    console.println("*** You WIN! ***\n");
                    System.exit(0);
                }

                //Remove defeated creature from map.
                game.removeCreature(player);

                // Return player to movement.
                MovementView moveMe = new MovementView();
                moveMe.display();
            }
        } else {
            console.println("\n--------- Player --------");
            console.println("\n*** Your attack missed! ***\n");
        }

        // *******************
        // * Creature Attack *
        // *******************
        // Check if creature attack was successful.
        attackScucces = combat.attackCheck(creature.getAttack(), playerDefense);

        // Calculate damage or miss.
        if (attackScucces) {
            
            // Get damage from attack.
            int damage = combat.creatureAttack(creature.getAttack(), playerDefense, creature.getDice(), creature.getRolls());
            
            console.println("--------- " + creature.getName() + " --------");
            console.println("\n" + creature.getName() + " attacks you for " + damage + " damage.\n");

            // Apply damage to player.
            player.setHealth(player.getHealth() - damage);

        } else {
            console.println("\n" + creature.getName() + "'s attack missed!\n");
        }

        // Initalize rest
        boolean rest = false;
        CheckHealth check = new CheckHealth();

        // Check if player is still alive.
        try {
            check.checkHealth(player, rest);
        } catch (LoseGameException lge) {
            console.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            console.println("\n\tYou have been defeated by " + creature.getName() + "");
            console.println("\n\tWipe yourself off " + player.getName() + ", you DEAD!");
            console.println("\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
            System.exit(0);
        } finally {
            if (player.getHealth() <= 10) {
                console.println("*** Your health is only " + player.getHealth() + ", you might want to run! ***\n");
            } else {
                console.println("\n---------------------------------");
                console.println("| HP: " + player.getHealth() + "/" + player.getMaxHealth()
                        + "\tATK: " + playerAttack + "\tDEF: " + playerDefense + " |");
                console.println("---------------------------------");
            }
        }
    }

    private void Defend() {
        // calls the Combat controller
        /*CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();*/
        console.println("Your enemy swings at you with the intent of your demise\n");
    }

    private void Potion() {
        // calls the Combat controller
        /*CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();*/
        console.println("Ugh, you would think after all this time this stuff would taste better.\n");
    }

    private void Run() {
        /* calls the Combat Controller
        CombatDamageController combat = new CombatDamageController();
        combat.CombatDamageController();
         */
        console.println("RUNNNNNNNN AWWWWAAAAAAYYYY!!!!!!!!!! It's going to eat ME!!!!!!!!");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

}
