/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import java.io.Serializable;

/**
 *
 * @author Zack Durbin
 */
public class Combat implements Serializable{
    
    // class instance variables
    private int attackPower;
    private int defensePower;
    private int attackRoll;
    private int defenseRoll;
    private int fleeRoll;

    public Combat() {
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public void setDefensePower(int defensePower) {
        this.defensePower = defensePower;
    }

    public int getAttackRoll() {
        return attackRoll;
    }

    public void setAttackRoll(int attackRoll) {
        this.attackRoll = attackRoll;
    }

    public int getDefenseRoll() {
        return defenseRoll;
    }

    public void setDefenseRoll(int defenseRoll) {
        this.defenseRoll = defenseRoll;
    }

    public int getFleeRoll() {
        return fleeRoll;
    }

    public void setFleeRoll(int fleeRoll) {
        this.fleeRoll = fleeRoll;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + this.attackPower;
        hash = 11 * hash + this.defensePower;
        hash = 11 * hash + this.attackRoll;
        hash = 11 * hash + this.defenseRoll;
        hash = 11 * hash + this.fleeRoll;
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
        final Combat other = (Combat) obj;
        if (this.attackPower != other.attackPower) {
            return false;
        }
        if (this.defensePower != other.defensePower) {
            return false;
        }
        if (this.attackRoll != other.attackRoll) {
            return false;
        }
        if (this.defenseRoll != other.defenseRoll) {
            return false;
        }
        if (this.fleeRoll != other.fleeRoll) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Combat{" + "attackPower=" + attackPower + ", defensePower=" + defensePower + ", attackRoll=" + attackRoll + ", defenseRoll=" + defenseRoll + ", fleeRoll=" + fleeRoll + '}';
    }
    
    
}
