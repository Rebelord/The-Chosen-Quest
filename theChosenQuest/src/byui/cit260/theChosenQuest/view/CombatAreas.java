/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Zack Durbin
 */
public class CombatAreas implements Serializable{
    
    //class instance variables
    private String creatures;
    private String traps;
    private String items;

    public CombatAreas() {
    }

    public String getCreatures() {
        return creatures;
    }

    public void setCreatures(String creatures) {
        this.creatures = creatures;
    }

    public String getTraps() {
        return traps;
    }

    public void setTraps(String traps) {
        this.traps = traps;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.creatures);
        hash = 23 * hash + Objects.hashCode(this.traps);
        hash = 23 * hash + Objects.hashCode(this.items);
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
        final CombatAreas other = (CombatAreas) obj;
        if (!Objects.equals(this.creatures, other.creatures)) {
            return false;
        }
        if (!Objects.equals(this.traps, other.traps)) {
            return false;
        }
        if (!Objects.equals(this.items, other.items)) {
            return false;
        }
        return true;
    }
//grrrrrrrrr
    
    @Override
    public String toString() {
        return "CombatAreas{" + "creatures=" + creatures + ", traps=" + traps + ", items=" + items + '}';
    }
    
    
           
}
