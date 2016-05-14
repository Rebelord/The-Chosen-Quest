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
public class Town implements Serializable{
    
    //class instance variables
    private String npc;
    private String shop;
    private String tavern;
    private String inn;

    public Town() {
    }

    public String getNpc() {
        return npc;
    }

    public void setNpc(String npc) {
        this.npc = npc;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getTavern() {
        return tavern;
    }

    public void setTavern(String tavern) {
        this.tavern = tavern;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.npc);
        hash = 71 * hash + Objects.hashCode(this.shop);
        hash = 71 * hash + Objects.hashCode(this.tavern);
        hash = 71 * hash + Objects.hashCode(this.inn);
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
        final Town other = (Town) obj;
        if (!Objects.equals(this.npc, other.npc)) {
            return false;
        }
        if (!Objects.equals(this.shop, other.shop)) {
            return false;
        }
        if (!Objects.equals(this.tavern, other.tavern)) {
            return false;
        }
        if (!Objects.equals(this.inn, other.inn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Town{" + "npc=" + npc + ", shop=" + shop + ", tavern=" + tavern + ", inn=" + inn + '}';
    }
    
    
}
