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
public class Creatures implements Serializable {

    // class instance variables
    private int hp;
    private int attack;
    private int dice;
    private int rolls;
    private int defense;
    private int hit;
    private String name;
    private int goldDrop;

    public Creatures() {
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDice() {
        return dice;
    }

    public void setDice(int dice) {
        this.dice = dice;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
        this.hit = hit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(int goldDrop) {
        this.goldDrop = goldDrop;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.hp;
        hash = 89 * hash + this.attack;
        hash = 89 * hash + this.dice;
        hash = 89 * hash + this.rolls;
        hash = 89 * hash + this.defense;
        hash = 89 * hash + this.hit;
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + this.goldDrop;
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
        final Creatures other = (Creatures) obj;
        if (this.hp != other.hp) {
            return false;
        }
        if (this.attack != other.attack) {
            return false;
        }
        if (this.dice != other.dice) {
            return false;
        }
        if (this.rolls != other.rolls) {
            return false;
        }
        if (this.defense != other.defense) {
            return false;
        }
        if (this.hit != other.hit) {
            return false;
        }
        if (this.goldDrop != other.goldDrop) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    public Creatures(int hp, int attack, int dice, int rolls, int defense, int hit, String name, int goldDrop) {
        this.hp = hp;
        this.attack = attack;
        this.dice = dice;
        this.rolls = rolls;
        this.defense = defense;
        this.hit = hit;
        this.name = name;
        this.goldDrop = goldDrop;
    }

    @Override
    public String toString() {
        return "Creatures{" + "hp=" + hp + ", attack=" + attack + ", dice=" + dice + ", rolls=" + rolls + ", defense=" + defense + ", hit=" + hit + ", name=" + name + ", goldDrop=" + goldDrop + '}';
    }

}
