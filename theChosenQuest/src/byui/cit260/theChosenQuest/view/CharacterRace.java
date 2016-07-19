/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.util.Scanner;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author ryandanielwebb
 */
public class CharacterRace extends View {

    public CharacterRace() {
           super("\n"
                +"\n-----------------------------------------------------------"
                +"\n|                  Race Selection                         |"
                +"\n-----------------------------------------------------------"
                +"\n| D - Dwarf                                               |"
                +"\n| H - Human                                               |"
                +"\n| L - Halfling                                            |"
                +"\n| E - Elf                                                 |"
                +"\n| Q - Return to Main Menu                                 |"
                +"\n-----------------------------------------------------------");
    }
    
    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "D": // Create and Start a new Dwarf Hero.
                this.dwarf();
                break;
            case "H": // Create and Start a new Human Hero.
                this.human();
                break;
            case "L": // Create and Start a new Halfling Hero.
                this.halfling();
                break;
            case "E": // Create and Start a new Elf Hero.
                this.elf();
                break;
            default:
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }
    
    private void dwarf() {
        TheChosenQuest.player.setPlayerRace("Dwarf");
        TheChosenQuest.player.setHealth(100);
        TheChosenQuest.player.setMaxHealth(100);
        TheChosenQuest.player.setPoison(0);
        console.println ("You have chosen the stoutheardy Dwarf, immoveable as the mountain.");
        CharacterClass charClass = new CharacterClass();
        charClass.display();
    }

    private void human() {
        TheChosenQuest.player.setPlayerRace("Human");
        TheChosenQuest.player.setHealth(90);
        TheChosenQuest.player.setMaxHealth(90);
        TheChosenQuest.player.setPoison(0);
        console.println ("You have chosen the flexable human, as fluid as the river.");
        CharacterClass charClass = new CharacterClass();
        charClass.display();
    }

    private void halfling() {
        TheChosenQuest.player.setPlayerRace("Halfling");
        TheChosenQuest.player.setHealth(70);
        TheChosenQuest.player.setMaxHealth(70);
        TheChosenQuest.player.setPoison(0);
        console.println ("You have chosen the whimsical Halfling, as free as the wind.");
        CharacterClass charClass = new CharacterClass();
        charClass.display();
    }

    private void elf() {
        TheChosenQuest.player.setPlayerRace("Elf");
        TheChosenQuest.player.setHealth(80);
        TheChosenQuest.player.setMaxHealth(80);
        TheChosenQuest.player.setPoison(0);
        console.println ("You have chosen the mystical Elf, as ever changing as the forest");
        CharacterClass charClass = new CharacterClass();
        charClass.display();
    }
}
