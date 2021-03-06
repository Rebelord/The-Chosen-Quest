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
    private String name;
    private int attack;
    private String description;
    private String type;
    private Boolean equiped;

    public Spells() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getEquiped() {
        return equiped;
    }

    public void setEquiped(Boolean equiped) {
        this.equiped = equiped;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + this.attack;
        hash = 79 * hash + Objects.hashCode(this.description);
        hash = 79 * hash + Objects.hashCode(this.type);
        hash = 79 * hash + Objects.hashCode(this.equiped);
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
        if (this.attack != other.attack) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.equiped, other.equiped)) {
            return false;
        }
        return true;
    }

    public Spells(String name, int attack, String description, String type, Boolean equiped) {
        this.name = name;
        this.attack = attack;
        this.description = description;
        this.type = type;
        this.equiped = equiped;
    }

    @Override
    public String toString() {
        return "Spells{" + "name=" + name + ", attack=" + attack + ", description=" + description + ", type=" + type + ", equiped=" + equiped + '}';
    }

}
