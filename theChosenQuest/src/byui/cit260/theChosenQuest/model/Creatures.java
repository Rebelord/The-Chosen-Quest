/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.Serializable;


/**
 *
 * @author Zack Durbin
 */
public class Creatures implements Serializable{
    
    // class instance variables
    private double hp;
    private double attack;
    private double defense;
            private double hit;
    private String name;
    private double goldDrop;

    public Creatures() {
    }

    public double getHp() {
        return hp;
    }

    public void setHp(double hp) {
        this.hp = hp;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public double getDefense() {
        return defense;
    }

    public void setDefense(double defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGoldDrop() {
        return goldDrop;
    }

    public void setGoldDrop(double goldDrop) {
        this.goldDrop = goldDrop;
    }

            public double getHit() {
                return hit;
            }

            public void setHit(double hit) {
                this.hit = hit;
            }
    
    
}
