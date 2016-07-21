/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.model.Equipment;
import java.util.List;
import thechosenquest.TheChosenQuest;
import byui.cit260.theChosenQuest.model.Inventory;
import byui.cit260.theChosenQuest.model.Spells;

/**
 *
 * @author Zack Durbin
 */
public class CharacterClass extends View {
    
    public CharacterClass() {
        super("\n"
                +"\n|----------------------------------------------------------|"
                +"\n|                  Class Selection                         |"
                +"\n|----------------------------------------------------------|"
                +"\n| F - Fighter                                              |"
                +"\n| M - Mage                                                 |"
                +"\n| R - Rouge                                                |"
                +"\n| H - Hunter                                               |"
                +"\n| Q - Return to Race Selection                             |"
                +"\n|----------------------------------------------------------|");
    }
    
    @Override
    public boolean doAction(String menuOption) {
        menuOption = menuOption.toUpperCase(); // COnvert choice to Uppercase.
    
        switch (menuOption) {
            case "F": // Choose to play as a fighter.
                this.fighter();
                break;
            case "M": // Choose to play as a Mage.
                this.mage();
                break;
            case "R": // Chose to play as a Rouge.
                this.rouge();
                break;
            case "H": //  Choose to play as a Hunter.
                this.hunter();
                break;
            default:
                console.println("\n*** Fat Finger Error *** Please try again!");
                break;
        }
        
        return false;
    }

    private void fighter() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Fighter");
        
        // Set Player Stats
        TheChosenQuest.player.setStr(TheChosenQuest.player.getStr() + 5);
        TheChosenQuest.player.setDex(TheChosenQuest.player.getDex() + 0);
        TheChosenQuest.player.setIq(TheChosenQuest.player.getIq() + 2);
        TheChosenQuest.player.setCon(TheChosenQuest.player.getCon() + 50);
        TheChosenQuest.player.setCha(TheChosenQuest.player.getCha() + 1);
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + TheChosenQuest.player.getCon());
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth());
        
       
        // Give player a weapon.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment longSword = new Equipment();
        longSword.setName("Long Sword");
        longSword.setType("Weapon");
        longSword.setAttack(2);
        longSword.setDice(8);
        longSword.setRolls(1);
        longSword.setDefense(0);
        longSword.setCost(15);
        longSword.setEquiped(true);
        
        // Give player some armour.
        Equipment chainmail = new Equipment();
        chainmail.setName("Chainmail");
        chainmail.setType("Armour");
        chainmail.setAttack(0);
        chainmail.setDefense(14);
        chainmail.setCost(35);
        chainmail.setEquiped(true);
        
        Equipment shield = new Equipment();
        shield.setName("Shield");
        shield.setType("Armour");
        shield.setAttack(0);
        shield.setDefense(1);
        shield.setCost(5);
        shield.setEquiped(true);

        // Add Equipment to player.
        playerEquipment.add(longSword);
        playerEquipment.add(chainmail);
        playerEquipment.add(shield);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        // Setup player inventory.
        Inventory inventory = new Inventory();
        inventory.setGold(15);
        TheChosenQuest.player.setInventory(inventory);
        
        console.println("You have chosen the way of the Sword. You are the epitome of bladed fury. You are the mighty fighter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void mage() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Mage");
        
        // Set Player Stats
        TheChosenQuest.player.setStr(TheChosenQuest.player.getStr() + 1);
        TheChosenQuest.player.setDex(TheChosenQuest.player.getDex() + 3);
        TheChosenQuest.player.setIq(TheChosenQuest.player.getIq() + 5);
        TheChosenQuest.player.setCon(TheChosenQuest.player.getCon() + 10);
        TheChosenQuest.player.setCha(TheChosenQuest.player.getCha() + 2);
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + TheChosenQuest.player.getCon());
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth());
        
        
        // Give player a weapon
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment staff = new Equipment();
        staff.setName("Staff");
        staff.setAttack(3);
        staff.setDice(8);
        staff.setRolls(1);
        staff.setDefense(0);
        staff.setCost(15);
        staff.setType("Weapon");
        staff.setEquiped(true);
        
        // Give player some armour.
        Equipment clothArmor = new Equipment();
        clothArmor.setName("Cloth Armour");
        clothArmor.setType("Armour");
        clothArmor.setAttack(0);
        clothArmor.setDefense(11);
        clothArmor.setCost(2);
        clothArmor.setEquiped(true);
        
        // Give the mage some spells
        Spells fireball = new Spells();
        fireball.setName("Fireball");
        fireball.setAttack(15);
        fireball.setDescription("Hurls a fireball at your enemy.");
        fireball.setEquiped(true);
        
        Spells magicMissle = new Spells();
        magicMissle.setName("Magic Missle");
        magicMissle.setAttack(10);
        magicMissle.setDescription("You point your finger at the enemy and an arcane blast hurtles at them.");
        magicMissle.setType("Arcane");
        magicMissle.setEquiped(true);
        
        Spells iceSpike = new Spells();
        iceSpike.setName("Ice Spike");
        iceSpike.setAttack(20);
        iceSpike.setDescription("The ground below your foe freezes before a spike shoots up from the ground impaling it.");
        iceSpike.setType("Ice");
        iceSpike.setEquiped(true);
        
        Spells earthquake = new Spells();
        earthquake.setName("Earthquake");
        earthquake.setAttack(20);
        earthquake.setDescription("The ground shakes and collapses under your foe.");
        earthquake.setType("Earth");
        earthquake.setEquiped(true);
        
        Spells gust = new Spells();
        gust.setName("Gust");
        gust.setAttack(8);
        gust.setDescription("The four winds surround your enemy and lifts them off the ground before dropping them back to the earth.");
        gust.setType("Wind");
        gust.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(staff);
        playerEquipment.add(clothArmor);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        // Setup player inventory.
        Inventory inventory = new Inventory();
        inventory.setGold(25);
        TheChosenQuest.player.setInventory(inventory);
        
        
        
        console.println("You have chosen the way of the Mind. Wielder of the sacred arts. You are the brilliant mage.");
        MovementView moveMe = new MovementView();
        moveMe.display();
        
        
    }

    private void rouge() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Rouge");
        
        // Set Player Stats
        TheChosenQuest.player.setStr(TheChosenQuest.player.getStr() + 3);
        TheChosenQuest.player.setDex(TheChosenQuest.player.getDex() + 5);
        TheChosenQuest.player.setIq(TheChosenQuest.player.getIq() + 0);
        TheChosenQuest.player.setCon(TheChosenQuest.player.getCon() + 20);
        TheChosenQuest.player.setCha(TheChosenQuest.player.getCha() + 3);
        
        // Rogue health stays default values. Increased for game balance.
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + TheChosenQuest.player.getCon());
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth());
       
        
        // Give player some weapons
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment shortSword = new Equipment();
        shortSword.setName("Short Sword");
        shortSword.setAttack(1);
        shortSword.setDice(6);
        shortSword.setRolls(1);
        shortSword.setDefense(0);
        shortSword.setCost(10);
        shortSword.setType("Weapon");
        shortSword.setEquiped(true);
        
        Equipment dagger = new Equipment();
        dagger.setName("Dagger");
        dagger.setType("Weapon");
        dagger.setAttack(1);
        dagger.setDice(4);
        dagger.setRolls(1);
        dagger.setDefense(0);
        dagger.setCost(5);
        dagger.setType("Weapon");
        dagger.setEquiped(true);
        
        // Give player some armour.
        Equipment leatherArmour = new Equipment();
        leatherArmour.setName("Leather Armour");
        leatherArmour.setType("Armour");
        leatherArmour.setAttack(0);
        leatherArmour.setDefense(12);
        leatherArmour.setCost(15);
        leatherArmour.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(shortSword);
        playerEquipment.add(dagger);
        playerEquipment.add(leatherArmour);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        // Setup player inventory.
        Inventory inventory = new Inventory();
        inventory.setGold(40);
        TheChosenQuest.player.setInventory(inventory);
        
        console.println("You have chosen the way of the Shadows. You strike your enemies weak points. You are the crafty rogue.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void hunter() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Hunter");
        
        // Set Player Stats
        TheChosenQuest.player.setStr(TheChosenQuest.player.getStr() + 3);
        TheChosenQuest.player.setDex(TheChosenQuest.player.getDex() + 2);
        TheChosenQuest.player.setIq(TheChosenQuest.player.getIq() + 1);
        TheChosenQuest.player.setCon(TheChosenQuest.player.getCon() + 30);
        TheChosenQuest.player.setCha(TheChosenQuest.player.getCha() + 0);
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + TheChosenQuest.player.getCon());
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth());
  
        
        
        // Give player a weapon.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment shortBow = new Equipment();
        shortBow.setName("Short Bow");
        shortBow.setAttack(1);
        shortBow.setDice(8);
        shortBow.setRolls(1);
        shortBow.setDefense(0);
        shortBow.setCost(25);
        shortBow.setType("Weapon");
        shortBow.setEquiped(true);
        
        // Give player some armour.
        Equipment scaleArmour = new Equipment();
        scaleArmour.setName("Scale Armour");
        scaleArmour.setType("Armour");
        scaleArmour.setAttack(0);
        scaleArmour.setDefense(13);
        scaleArmour.setCost(25);
        scaleArmour.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(shortBow);
        playerEquipment.add(scaleArmour);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        // Setup player inventory.
        Inventory inventory = new Inventory();
        inventory.setGold(10);
        TheChosenQuest.player.setInventory(inventory);
        
        console.println("You have chosen the way of the Bow. Your arrows fly unerringly with deadly accuracy. You are the nimble hunter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
