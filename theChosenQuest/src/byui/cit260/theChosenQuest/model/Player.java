/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ryandanielwebb
 */
public class Player implements Serializable{
    
    // class instance variables
    private String name;
    private List<Equipment> playerEquipment = new ArrayList<>();
    private List<Spells> playerSpells = new ArrayList<>();
    private int characterSheet;
    private String playerRace;
    private String playerClass;
    private int health;
    private int poison;
    private int maxHealth;
    private Location location;
    private Inventory inventory;
    private int str;
    private int dex;
    private int con;
    private int iq;
    private int cha;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Equipment> getPlayerEquipment() {
        return playerEquipment;
    }

    public void setPlayerEquipment(List<Equipment> playerEquipment) {
        this.playerEquipment = playerEquipment;
    }

    public List<Spells> getPlayerSpells() {
        return playerSpells;
    }

    public void setPlayerSpells(List<Spells> playerSpells) {
        this.playerSpells = playerSpells;
    }

    public int getCharacterSheet() {
        return characterSheet;
    }

    public void setCharacterSheet(int characterSheet) {
        this.characterSheet = characterSheet;
    }

    public String getPlayerRace() {
        return playerRace;
    }

    public void setPlayerRace(String playerRace) {
        this.playerRace = playerRace;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public void setPlayerClass(String playerClass) {
        this.playerClass = playerClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getPoison() {
        return poison;
    }

    public void setPoison(int poison) {
        this.poison = poison;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.name);
        hash = 83 * hash + Objects.hashCode(this.playerEquipment);
        hash = 83 * hash + Objects.hashCode(this.playerSpells);
        hash = 83 * hash + this.characterSheet;
        hash = 83 * hash + Objects.hashCode(this.playerRace);
        hash = 83 * hash + Objects.hashCode(this.playerClass);
        hash = 83 * hash + this.health;
        hash = 83 * hash + this.poison;
        hash = 83 * hash + this.maxHealth;
        hash = 83 * hash + Objects.hashCode(this.location);
        hash = 83 * hash + Objects.hashCode(this.inventory);
        hash = 83 * hash + this.str;
        hash = 83 * hash + this.dex;
        hash = 83 * hash + this.con;
        hash = 83 * hash + this.iq;
        hash = 83 * hash + this.cha;
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
        final Player other = (Player) obj;
        if (this.characterSheet != other.characterSheet) {
            return false;
        }
        if (this.health != other.health) {
            return false;
        }
        if (this.poison != other.poison) {
            return false;
        }
        if (this.maxHealth != other.maxHealth) {
            return false;
        }
        if (this.str != other.str) {
            return false;
        }
        if (this.dex != other.dex) {
            return false;
        }
        if (this.con != other.con) {
            return false;
        }
        if (this.iq != other.iq) {
            return false;
        }
        if (this.cha != other.cha) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.playerRace, other.playerRace)) {
            return false;
        }
        if (!Objects.equals(this.playerClass, other.playerClass)) {
            return false;
        }
        if (!Objects.equals(this.playerEquipment, other.playerEquipment)) {
            return false;
        }
        if (!Objects.equals(this.playerSpells, other.playerSpells)) {
            return false;
        }
        if (!Objects.equals(this.location, other.location)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
        return true;
    }

    public Player(String name, int characterSheet, String playerRace, String playerClass, int health, int poison, int maxHealth, Location location, Inventory inventory, int str, int dex, int con, int iq, int cha) {
        this.name = name;
        this.characterSheet = characterSheet;
        this.playerRace = playerRace;
        this.playerClass = playerClass;
        this.health = health;
        this.poison = poison;
        this.maxHealth = maxHealth;
        this.location = location;
        this.inventory = inventory;
        this.str = str;
        this.dex = dex;
        this.con = con;
        this.iq = iq;
        this.cha = cha;
    }

    @Override
    public String toString() {
        return "Player{" + "name=" + name + ", playerEquipment=" + playerEquipment + ", playerSpells=" + playerSpells + ", characterSheet=" + characterSheet + ", playerRace=" + playerRace + ", playerClass=" + playerClass + ", health=" + health + ", poison=" + poison + ", maxHealth=" + maxHealth + ", location=" + location + ", inventory=" + inventory + ", str=" + str + ", dex=" + dex + ", con=" + con + ", iq=" + iq + ", cha=" + cha + '}';
    }

   
   
    }

    
   