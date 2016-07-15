/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import byui.cit260.theChosenQuest.model.Equipment;
import java.util.List;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author Zack Durbin
 */
public class CharacterClass extends View {
    
    public CharacterClass() {
        super("\n"
                +"\n-----------------------------------------------------------"
                +"\n|                  Class Selection                         |"
                +"\n-----------------------------------------------------------"
                +"\n| F - Fighter                                              |"
                +"\n| M - Mage                                                 |"
                +"\n| R - Rouge                                                |"
                +"\n| H - Hunter                                               |"
                +"\n| Q - Return to Race Selection                             |"
                +"\n-----------------------------------------------------------");
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
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + 10);
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth() + 10);
        
        // Give player a weapon.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment longSword = new Equipment();
        longSword.setName("Long Sword");
        longSword.setType("Weapon");
        longSword.setAttack(5);
        longSword.setDefense(0);
        longSword.setCost(15);
        longSword.setEquiped(true);
        
        // Give player some armour.
        Equipment chainmail = new Equipment();
        chainmail.setName("Chainmail");
        chainmail.setType("Armour");
        chainmail.setAttack(0);
        chainmail.setDefense(4);
        chainmail.setCost(35);
        chainmail.setEquiped(true);
        
        Equipment shield = new Equipment();
        shield.setName("Shield");
        shield.setType("Armour");
        chainmail.setAttack(0);
        shield.setDefense(1);
        shield.setCost(5);
        shield.setEquiped(true);

        // Add Equipment to player inventory.
        playerEquipment.add(longSword);
        playerEquipment.add(chainmail);
        playerEquipment.add(shield);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        console.println("You have chosen the way of the Sword. You are the epitome of bladed fury. You are the mighty fighter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void mage() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Mage");
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() - 5);
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth() - 5);
        // Give player a weapon
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment staff = new Equipment();
        staff.setName("Staff");
        staff.setType("Weapon");
        staff.setAttack(6);
        staff.setDefense(0);
        staff.setCost(15);
        staff.setEquiped(true);
        
        // Give player some armour.
        Equipment clothArmor = new Equipment();
        clothArmor.setName("Cloth Armour");
        clothArmor.setType("Armour");
        clothArmor.setAttack(0);
        clothArmor.setDefense(1);
        clothArmor.setCost(2);
        clothArmor.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(staff);
        playerEquipment.add(clothArmor);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        console.println("You have chosen the way of the Mind. Wielder of the sacred arts. You are the brilliant mage.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void rouge() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Rouge");
        
        // Rogue health stays default values.
        
        // Give player some weapons
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment shortSword = new Equipment();
        shortSword.setName("Short Sword");
        shortSword.setType("Weapon");
        shortSword.setAttack(4);
        shortSword.setDefense(0);
        shortSword.setCost(10);
        shortSword.setEquiped(true);
        
        Equipment dagger = new Equipment();
        dagger.setName("Dagger");
        dagger.setType("Weapon");
        dagger.setAttack(4);
        dagger.setDefense(0);
        dagger.setCost(5);
        dagger.setEquiped(true);
        
        // Give player some armour.
        Equipment leatherArmour = new Equipment();
        leatherArmour.setName("Leather Armour");
        leatherArmour.setType("Armour");
        leatherArmour.setAttack(0);
        leatherArmour.setDefense(2);
        leatherArmour.setCost(15);
        leatherArmour.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(shortSword);
        playerEquipment.add(dagger);
        playerEquipment.add(leatherArmour);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        console.println("You have chosen the way of the Shadows. You strike your enemies weak points. You are the crafty rogue.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }

    private void hunter() {
        // Set Player Class
        TheChosenQuest.player.setPlayerClass("Hunter");
        
        // Set Player Health and MaxHealth
        TheChosenQuest.player.setHealth(TheChosenQuest.player.getHealth() + 5);
        TheChosenQuest.player.setMaxHealth(TheChosenQuest.player.getHealth() + 5);
        
        // Give player a weapon.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        Equipment shortBow = new Equipment();
        shortBow.setName("Short Bow");
        shortBow.setType("Weapon");
        shortBow.setAttack(10);
        shortBow.setDefense(0);
        shortBow.setCost(25);
        shortBow.setEquiped(true);
        
        // Give player some armour.
        Equipment scaleArmour = new Equipment();
        scaleArmour.setName("Scale Armour");
        scaleArmour.setType("Armour");
        scaleArmour.setAttack(0);
        scaleArmour.setDefense(3);
        scaleArmour.setCost(25);
        scaleArmour.setEquiped(true);
        
        // Add Equipment to player inventory.
        playerEquipment.add(shortBow);
        playerEquipment.add(scaleArmour);
        TheChosenQuest.player.setPlayerEquipment(playerEquipment);
        
        console.println("You have chosen the way of the Bow. Your arrows fly unerringly with deadly accuracy. You are the nimble hunter.");
        MovementView moveMe = new MovementView();
        moveMe.display();
    }
}
