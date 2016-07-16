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
import byui.cit260.theChosenQuest.model.Player;
import static thechosenquest.TheChosenQuest.player;

/**
 *
 * @author ryandanielwebb
 */
public class CombatView extends View {

    public CombatView(Player player) {
        super("\n You are under attack by a " + player.getLocation().getCreatures().getName()
                + "\n Please decide what you want to do."
                + "\n"
                + "\n You may ..."
                + "\n  A - Attack your opponent"
                + "\n  D - Defend against your opponents attack"
                + "\n  P - Drink a potion (if you have one)"
                + "\n  R - Run Away!");
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
        String creatureName = player.getLocation().getCreatures().getName();
        int creatureAttack = player.getLocation().getCreatures().getAttack();
        int creatureHealth = player.getLocation().getCreatures().getHp();
        int creatureDefense = player.getLocation().getCreatures().getDefense();
        int creatureHit = player.getLocation().getCreatures().getHit();
        int playerHealth = player.getHealth();
        
        // *****************
        // * Player Attack *
        // *****************
        
        // Change hardcoded defense/attack to match armour & weapon.
        int playerDefense = 0;
        int playerAttack = 10;
        
        // Check if player attack was successful.
        boolean attackScucces = combat.AttackCheck(playerAttack, creatureHit);

        // Calculate damage or miss.
        if (attackScucces) {

            // Get damage from attack.
            int damage = combat.AttackRoll(playerAttack, creatureDefense);
            console.println("\nYou hit " + creatureName
                    + " for " + damage + " damage.\n");

            // Apply damage to creature.
            creatureHealth -= damage;
            player.getLocation().getCreatures().setHp(creatureHealth - damage);

            // Check if creature is still alive.
            if (creatureHealth > 0) 
                console.println(creatureName + " is still alive.\n");
            else {
                // Display message to user upon creature defeat.
                console.println("***You've defeated the " + creatureName + "***\n");

                //Remove defeated creature from map.
                game.removeCreature(player);
                
                // Display player current health.
                console.println("Your health is at " + playerHealth + "\n");

                // Return player to movement.
                MovementView moveMe = new MovementView();
                moveMe.display();
            }
        } else {
            console.println("\nYour attack missed!\n");
        }
        
        // *******************
        // * Creature Attack *
        // *******************
        
        // Check if creature attack was successful.
        attackScucces = combat.AttackCheck(creatureAttack, playerDefense);

        // Calculate damage or miss.
        if (attackScucces) {

            // Get damage from attack.
            int damage = combat.AttackRoll(creatureAttack, playerDefense);
            console.println("\nThe creature attacks you for " + damage + " damage.\n");

            // Apply damage to player.
            playerHealth -= damage;
            player.setHealth(playerHealth);

        } else
            console.println("\n" + creatureName + "'s attack missed!\n");
        
        
        // Initalize rest
        boolean rest = false;
        CheckHealth check = new CheckHealth();
        
        // Check if player is still alive.
        try {
            check.checkHealth(player, rest);
        } catch (LoseGameException wipe) {
            console.println("\n*** You have been defeated by " + creatureName +  " ***");
            System.exit(0);
        } finally {
            console.println("Your health is at " + playerHealth + "\n");
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
