/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Objects;
import thechosenquest.TheChosenQuest;
import static thechosenquest.TheChosenQuest.player;

/**
 *
 * @author ryandanielwebb
 */
public class CharacterSheet implements Serializable{
    
    // class instance variables
    private int stats;
    private String equipment;
    private String spells;
    private String inventory;
    
    protected final PrintWriter console = TheChosenQuest.getOutFile();
    protected final BufferedReader keyboard = TheChosenQuest.getInFile();

    public CharacterSheet() {
    }

    public int getStats() {
        return stats;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getSpells() {
        return spells;
    }

    public String getInventory() {
        return inventory;
    }

    public void setStats(int stats) {
        this.stats = stats;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setSpells(String spells) {
        this.spells = spells;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.stats;
        hash = 89 * hash + Objects.hashCode(this.equipment);
        hash = 89 * hash + Objects.hashCode(this.spells);
        hash = 89 * hash + Objects.hashCode(this.inventory);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CharacterSheet other = (CharacterSheet) obj;
        if (this.stats != other.stats) {
            return false;
        }
        if (!Objects.equals(this.equipment, other.equipment)) {
            return false;
        }
        if (!Objects.equals(this.spells, other.spells)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CharacterSheet{" + "stats=" + stats + ", equipment=" + equipment + ", spells=" + spells + ", inventory=" + inventory + '}';
    }

    public void display() {
        console.println("--------------------------------");
        console.println("| This is me. \t \t |\n"
                      + "| Name: " + player.getName() + "\n"
                      + "| Race: " + player.getPlayerRace() + "\n" 
                      + "| Class: " + player.getPlayerClass() + "\n" 
                      + "| Health: " + player.getHealth() + "/" + player.getMaxHealth()
                    + "\n| Strength: " + player.getStr() + "\n" + 
                        "| Dexterity: " + player.getDex() + "\n" +
                        "| Constitution: " + player.getCon() + "\n" +
                        "| Intelligance: " + player.getIq() + "\n" +
                        "| Charisma: " + player.getCha());
        console.println("--------------------------------");
    }
    
    
}
