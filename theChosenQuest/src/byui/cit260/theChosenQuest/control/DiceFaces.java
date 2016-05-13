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
public class DiceFaces implements Serializable{
    
    // class instance variables
    private int twentySided;
    private int tenSided;
    private int eightSided;
    private int sixSided;

    public DiceFaces() {
    }

    public int getTwentySided() {
        return twentySided;
    }

    public void setTwentySided(int twentySided) {
        this.twentySided = twentySided;
    }

    public int getTenSided() {
        return tenSided;
    }

    public void setTenSided(int tenSided) {
        this.tenSided = tenSided;
    }

    public int getEightSided() {
        return eightSided;
    }

    public void setEightSided(int eightSided) {
        this.eightSided = eightSided;
    }

    public int getSixSided() {
        return sixSided;
    }

    public void setSixSided(int sixSided) {
        this.sixSided = sixSided;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.twentySided;
        hash = 89 * hash + this.tenSided;
        hash = 89 * hash + this.eightSided;
        hash = 89 * hash + this.sixSided;
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
        final DiceFaces other = (DiceFaces) obj;
        if (this.twentySided != other.twentySided) {
            return false;
        }
        if (this.tenSided != other.tenSided) {
            return false;
        }
        if (this.eightSided != other.eightSided) {
            return false;
        }
        if (this.sixSided != other.sixSided) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DiceFaces{" + "twentySided=" + twentySided + ", tenSided=" + tenSided + ", eightSided=" + eightSided + ", sixSided=" + sixSided + '}';
    }
    
    
}
