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
 * @author Zack Durbin
 */
public class CharacterClass implements Serializable{
    
    // class instance variabels
    private String hunter;
    private String mage;
    private String fighter;
    private String rogue;

    public CharacterClass() {
    }

    public String getHunter() {
        return hunter;
    }

    public void setHunter(String hunter) {
        this.hunter = hunter;
    }

    public String getMage() {
        return mage;
    }

    public void setMage(String mage) {
        this.mage = mage;
    }

    public String getFighter() {
        return fighter;
    }

    public void setFighter(String fighter) {
        this.fighter = fighter;
    }

    public String getRogue() {
        return rogue;
    }

    public void setRogue(String rogue) {
        this.rogue = rogue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.hunter);
        hash = 83 * hash + Objects.hashCode(this.mage);
        hash = 83 * hash + Objects.hashCode(this.fighter);
        hash = 83 * hash + Objects.hashCode(this.rogue);
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
        final CharacterClass other = (CharacterClass) obj;
        if (!Objects.equals(this.hunter, other.hunter)) {
            return false;
        }
        if (!Objects.equals(this.mage, other.mage)) {
            return false;
        }
        if (!Objects.equals(this.fighter, other.fighter)) {
            return false;
        }
        if (!Objects.equals(this.rogue, other.rogue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Class{" + "hunter=" + hunter + ", mage=" + mage + ", fighter=" + fighter + ", rogue=" + rogue + '}';
    }
    
    
}
