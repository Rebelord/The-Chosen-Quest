/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author ryandanielwebb
 */
public class Player implements Serializable{
    
    // class instance variables
    private String name;
    private int characterSheet;

    public Player() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + this.characterSheet;
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
        final Player other = (Player) obj;
        if (this.characterSheet != other.characterSheet) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", characterSheet=" + characterSheet + '}';
    }

    
    public String getName() {
        return name;
    }

    public int getCharacterSheet() {
        return characterSheet;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCharacterSheet(int characterSheet) {
        this.characterSheet = characterSheet;
    }
}
