/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.Serializable;

/**
 *
 * @author ryandanielwebb
 */
public class Stats implements Serializable{
    
    // class instance variables
    private int strength;
    private int dexterity;
    private int charisma;
    private int constitution;
    private int magic;

    public Stats() {
    }

    public int getStrength() {
        return strength;
    }

    public int getMagic() {
        return magic;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getConstitution() {
        return constitution;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public void setCharisma(int charisma) {
        this.charisma = charisma;
    }

    public void setConstitution(int constitution) {
        this.constitution = constitution;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.strength;
        hash = 41 * hash + this.dexterity;
        hash = 41 * hash + this.charisma;
        hash = 41 * hash + this.constitution;
        hash = 41 * hash + this.magic;
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
        final Stats other = (Stats) obj;
        if (this.strength != other.strength) {
            return false;
        }
        if (this.dexterity != other.dexterity) {
            return false;
        }
        if (this.charisma != other.charisma) {
            return false;
        }
        if (this.constitution != other.constitution) {
            return false;
        }
        if (this.magic != other.magic) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Stats{" + "strength=" + strength + ", dexterity=" + dexterity + ", charisma=" + charisma + ", constitution=" + constitution + ", magic=" + magic + '}';
    }

    
    
}
