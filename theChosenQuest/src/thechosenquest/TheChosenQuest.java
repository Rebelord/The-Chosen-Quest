/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechosenquest;

import byui.cit260.theChosenQuest.model.CharacterSheet;
import byui.cit260.theChosenQuest.model.Player;

/**
 *
 * @author ryandanielwebb
 */
public class TheChosenQuest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player playerOne = new Player();
        
        playerOne.setName("Frank Castle");
        playerOne.setCharacterSheet(7);
        
        String playerInfo = playerOne.toString();
        System.out.println(playerInfo);
        
        CharacterSheet characterSheet = new CharacterSheet();
        
        characterSheet.setStats(20);
        characterSheet.setSpells("Magic Missle");
        characterSheet.setEquipment("Chestplate");
        characterSheet.setInventory("Bag of Holding");
        
        String characterSheetInfo = characterSheet.toString();
        System.out.println(characterSheetInfo);
        
    }
    
}
