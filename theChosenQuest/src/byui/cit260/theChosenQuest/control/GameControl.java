/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.model.Creatures;
import byui.cit260.theChosenQuest.model.Equipment;
import byui.cit260.theChosenQuest.model.Game;
import byui.cit260.theChosenQuest.model.Location;
import byui.cit260.theChosenQuest.model.LocationType;
import static byui.cit260.theChosenQuest.model.LocationType.Shop;
import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.model.Map;
import byui.cit260.theChosenQuest.view.CombatView;
import byui.cit260.theChosenQuest.view.ErrorView;
import byui.cit260.theChosenQuest.view.ShopView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import thechosenquest.TheChosenQuest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zack Durbin
 */
public class GameControl {
    
    public static void saveGame(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(TheChosenQuest.getCurrentGame());
        } catch (Exception e) {
            ErrorView.display("GameControl", e.getMessage());
        }
    }
    
    public static void loadGame(String filePath) {
        Game game = null;
        
        try {
           FileInputStream fis = new FileInputStream(filePath);
           ObjectInputStream ois = new ObjectInputStream(fis);
            
           game = (Game)ois.readObject();
           
           TheChosenQuest.setCurrentGame(game);
           TheChosenQuest.setPlayer(game.getPlayer());
        } catch (Exception e) {
            ErrorView.display("GameControl", e.getMessage());
        }
    }

    public static Player createPlayer(String playersName) {

        if (playersName == null) {
            return null;
        }
        Player player = new Player();
        player.setName(playersName);

        TheChosenQuest.setPlayer(player); // save the player

        return player;
    }

    public static void createNewGame(Player player) {

        Game g = new Game();
        g.setPlayer(player);

        Map gameMap = new Map();
        g.setMap(gameMap);

        populateMapWithCreatures(gameMap);

        player.setLocation(gameMap.getLocation(0, 0));

        TheChosenQuest.setCurrentGame(g);

    }

    public static void populateMapWithCreatures(Map map) {

        List<Creatures> creatures = createCreatureList();
        boolean success = false;

        for (Creatures c : creatures) {

            do {
                int row = (int) (Math.random() * Map.NUM_ROWS);
                int col = (int) (Math.random() * Map.NUM_COLS);

                success = false;

                if (map.getLocation(row, col).getCreatures() == null) {
                    map.getLocation(row, col).setCreatures(c);
                    success = true;
                }

            } while (success == false);

        }
    }

    public static List<Creatures> createCreatureList() {

        List<Creatures> creatureList = new ArrayList<>();

        Creatures blob = new Creatures();
        blob.setName("Ooze");
        blob.setHp(10);
        blob.setAttack(5);
        blob.setDefense(3);
        blob.setGoldDrop(15);
        creatureList.add(blob);

        Creatures wolf = new Creatures();
        wolf.setName("Dire Wolf");
        wolf.setHp(10);
        wolf.setAttack(5);
        wolf.setDefense(4);
        wolf.setGoldDrop(5);
        creatureList.add(wolf);

        Creatures goblin = new Creatures();
        goblin.setName("Bob the Goblin");
        goblin.setHp(5);
        goblin.setAttack(3);
        goblin.setDefense(2);
        goblin.setGoldDrop(10);
        creatureList.add(goblin);

        return creatureList;

    }

    public static void listShopInventory() {
        List<Equipment> equipment = createEquipmentList();

        for (Equipment e : equipment) {
            System.out.println(e.getName());
            System.out.println("$" + e.getCost() + " Gold");
            System.out.println("+" + e.getAttack() + "to attack");
            System.out.println("+" + e.getDefense() + "to defense\n");
        }
    }

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

    public boolean findCreature(Player player) {
        Location location = player.getLocation();
        if (location.getCreatures() != null) {
            CombatView fight = new CombatView(player);
            fight.display();
            location.setCreatures(null);
            return true;
        }

        return false;
    }

    public boolean findShop(Player player) {
        // Grab LocationType and save to variable
        LocationType currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation().getType();
        // Check LocationType for Shop, then Display ShopView
        if (currentLocation == Shop) {
            ShopView shop = new ShopView();
            shop.display();

            return true;
        }

        return false;
    }
}
