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
public class Equipment implements Serializable {

    private String name;
    private int attack;
    private int defense;
    private int cost;
    private String type;
    private Boolean equiped;

    public Equipment() {

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

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
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
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + this.attack;
        hash = 37 * hash + this.defense;
        hash = 37 * hash + this.cost;
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.equiped);
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
        final Equipment other = (Equipment) obj;
        if (this.attack != other.attack) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.cost != other.cost) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
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

    public Equipment(String name, int attack, int defense, int cost, String type, Boolean equiped) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.cost = cost;
        this.type = type;
        this.equiped = equiped;
    }

    @Override
    public String toString() {
        return "Equipment{" + "name=" + name + ", attack=" + attack + ", defense=" + defense + ", cost=" + cost + ", type=" + type + ", equiped=" + equiped + '}';
    }

}
