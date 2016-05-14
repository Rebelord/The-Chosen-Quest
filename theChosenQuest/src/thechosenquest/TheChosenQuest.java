/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechosenquest;

import byui.cit260.theChosenQuest.control.Combat;
import byui.cit260.theChosenQuest.control.DiceFaces;
import byui.cit260.theChosenQuest.control.RandomRoll;
import byui.cit260.theChosenQuest.model.CharacterSheet;
import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.model.Spells;
import byui.cit260.theChosenQuest.model.Stats;
import byui.cit260.theChosenQuest.view.CombatAreas;
import byui.cit260.theChosenQuest.view.Map;
import byui.cit260.theChosenQuest.view.Town;

/**
 *
 * @author ryandanielwebb
 */
public class TheChosenQuest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Player Class
        Player playerOne = new Player();
        
        playerOne.setName("Frank Castle");
        playerOne.setCharacterSheet(7);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        // Character Sheet Class
        CharacterSheet characterSheet = new CharacterSheet();
        
        characterSheet.setStats(20);
        characterSheet.setSpells("Magic Missle");
        characterSheet.setEquipment("Chestplate");
        characterSheet.setInventory("Bag of Holding");
        
        String characterSheetInfo = characterSheet.toString();
        System.out.println(characterSheetInfo);
        
        // Player Stats Class
        Stats playerStats = new Stats();
        
        playerStats.setCharisma(10);
        playerStats.setConstitution(20);
        playerStats.setDexterity(5);
        playerStats.setStrength(20);
        
        String playerStatsInfo = playerStats.toString();
        System.out.println(playerStatsInfo);
        
        // Player Spells Class
        Spells playerSpells = new Spells();
        
        playerSpells.setAttack("Magma Ball");
        playerSpells.setDescription("A glowey firey round sphere of desctruction.");
        playerSpells.setType("Fire");
        
        String playerSpellsInfo = playerSpells.toString();
        System.out.println(playerSpellsInfo);
        
        // Map Class
        Map playerLocation = new Map();
        
        playerLocation.setLocation("Lion's Pride Inn");
        playerLocation.setMove("Up");
        playerLocation.setLegend("Stuff");
        
        String playerLocationInfo = playerLocation.toString();
        System.out.println(playerLocationInfo);
        
        // Random Roll Dice Class
        RandomRoll playerDice = new RandomRoll();
        
        playerDice.setDiceFace(20);
        
        String playerDiceRoll = playerDice.toString();
        System.out.println(playerDiceRoll);
        
        // Dice Face Class
        DiceFaces playerDieChoice = new DiceFaces();
        
        playerDieChoice.setSixSided(6);
        playerDieChoice.setEightSided(8);
        playerDieChoice.setTenSided(10);
        playerDieChoice.setTwentySided(20);
        
        String playerDieUse = playerDieChoice.toString();
        System.out.println(playerDieChoice);
        
        // Combat Class
        Combat playerCombat = new Combat();
        
        playerCombat.setAttackPower(30);
        playerCombat.setAttackRoll(20);
        playerCombat.setDefensePower(5);
        playerCombat.setDefenseRoll(2);
        playerCombat.setFleeRoll(10);
        
        String playerCombatInfo = playerCombat.toString();
        System.out.println(playerCombatInfo);
        
        //Town Class
        
        Town playerTown = new Town();
        
        playerTown.setInn("Hometown");
        playerTown.setNpc("Bob");
        playerTown.setShop("weapons Galor");
        playerTown.setTavern("The Green Dragon");
        
        String playerTownInfo = playerTown.toString();
        System.out.println(playerTownInfo);
        
        //Combat Areas
        
        CombatAreas playerArea = new CombatAreas();
        
        playerArea.setCreatures ("Goblin");
        playerArea.setItems("Spell Book");
        playerArea.setTraps("Spike Trap");
        
        String playerAreaInfo = playerArea.toString();
        System.out.println(playerAreaInfo);
        
        
        
    }
    
}
