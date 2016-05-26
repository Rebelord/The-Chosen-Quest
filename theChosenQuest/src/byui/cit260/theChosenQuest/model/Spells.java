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
public class Spells implements Serializable{
    
    // class instance variables
    private String attack;
    private String description;
    private String type;

    public Spells() {
    }

    public String getAttack() {
        return attack;
    }

    public String getDescription() {
        return description;
    }

    public String getType() {
        return type;
    }

    public void setAttack(String attack) {
        this.attack = attack;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.attack);
        hash = 67 * hash + Objects.hashCode(this.description);
        hash = 67 * hash + Objects.hashCode(this.type);
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
        final Spells other = (Spells) obj;
        if (!Objects.equals(this.attack, other.attack)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Spells{" + "attack=" + attack + ", description=" + description + ", type=" + type + '}';
    }
    
           
}
