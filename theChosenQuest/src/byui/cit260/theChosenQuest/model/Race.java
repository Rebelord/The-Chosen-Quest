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
public class Race implements Serializable{
    
    // class instance variables
    private String dwarf;
    private String elf;
    private String human;
    private String halfling;

    public Race() {
    }

    public String getDwarf() {
        return dwarf;
    }

    public void setDwarf(String dwarf) {
        this.dwarf = dwarf;
    }

    public String getElf() {
        return elf;
    }

    public void setElf(String elf) {
        this.elf = elf;
    }

    public String getHuman() {
        return human;
    }

    public void setHuman(String human) {
        this.human = human;
    }

    public String getHalfling() {
        return halfling;
    }

    public void setHalfling(String halfling) {
        this.halfling = halfling;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.dwarf);
        hash = 13 * hash + Objects.hashCode(this.elf);
        hash = 13 * hash + Objects.hashCode(this.human);
        hash = 13 * hash + Objects.hashCode(this.halfling);
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
        final Race other = (Race) obj;
        if (!Objects.equals(this.dwarf, other.dwarf)) {
            return false;
        }
        if (!Objects.equals(this.elf, other.elf)) {
            return false;
        }
        if (!Objects.equals(this.human, other.human)) {
            return false;
        }
        if (!Objects.equals(this.halfling, other.halfling)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Race{" + "dwarf=" + dwarf + ", elf=" + elf + ", human=" + human + ", halfling=" + halfling + '}';
    }
    
    
}
