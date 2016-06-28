/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;


import byui.cit260.theChosenQuest.model.Equipment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zack Durbin
 */
public class ShopController {
    public static List<Equipment> createEquipmentList() {
        
        List<Equipment> equipmentList = new ArrayList<>();
        
        Equipment longSword = new Equipment();
        longSword.setName("Long Sword");        
        longSword.setAttack(5);
        longSword.setDefense(0);
        longSword.setCost(15);
        equipmentList.add(longSword);
        
        Equipment shortSword = new Equipment();
        shortSword.setName("Short Sword");        
        shortSword.setAttack(4);
        shortSword.setDefense(0);
        shortSword.setCost(10);
        equipmentList.add(shortSword);
        
        Equipment axe = new Equipment();
        axe.setName("Axe");        
        axe.setAttack(8);
        axe.setDefense(0);
        axe.setCost(20);
        equipmentList.add(axe);
        
        Equipment longBow = new Equipment();
        longBow.setName("Long Bow");        
        longBow.setAttack(12);
        longBow.setDefense(0);
        longBow.setCost(30);
        equipmentList.add(longBow);
        
        Equipment shortBow = new Equipment();
        shortBow.setName("Short Bow");        
        shortBow.setAttack(10);
        shortBow.setDefense(0);
        shortBow.setCost(25);
        equipmentList.add(shortBow);
        
        Equipment staff = new Equipment();
        staff.setName("Staff");        
        staff.setAttack(6);
        staff.setDefense(0);
        staff.setCost(15);
        equipmentList.add(staff);
        
        Equipment mace = new Equipment();
        mace.setName("Mace");        
        mace.setAttack(7);
        mace.setDefense(0);
        mace.setCost(18);
        equipmentList.add(mace);
        
        Equipment clothArmor = new Equipment();
        clothArmor.setName("Cloth Armor");        
        clothArmor.setAttack(0);
        clothArmor.setDefense(1);
        clothArmor.setCost(2);
        equipmentList.add(clothArmor);
        
        Equipment leatherArmor = new Equipment();
        leatherArmor.setName("leather Armor");        
        leatherArmor.setAttack(0);
        leatherArmor.setDefense(2);
        leatherArmor.setCost(15);
        equipmentList.add(leatherArmor);
        
        Equipment scaleArmor = new Equipment();
        scaleArmor.setName("Scale Armor");        
        scaleArmor.setAttack(0);
        scaleArmor.setDefense(3);
        scaleArmor.setCost(25);
        equipmentList.add(scaleArmor);
                
        Equipment chainArmor = new Equipment();
        chainArmor.setName("Chain Armor");        
        chainArmor.setAttack(0);
        chainArmor.setDefense(4);
        chainArmor.setCost(35);
        equipmentList.add(chainArmor);
        
        Equipment plateArmor = new Equipment();
        plateArmor.setName("Plate Armor");        
        plateArmor.setAttack(0);
        plateArmor.setDefense(5);
        plateArmor.setCost(45);
        equipmentList.add(plateArmor);
        
        Equipment shield = new Equipment();
        shield.setName("Shield");
        shield.setDefense(1);
        shield.setCost(5);
        equipmentList.add(shield);
        
        
        return equipmentList;
    }
    
    
}
