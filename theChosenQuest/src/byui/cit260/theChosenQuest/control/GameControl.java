/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.exception.WinGameException;
import byui.cit260.theChosenQuest.model.Creatures;
import byui.cit260.theChosenQuest.model.Equipment;
import byui.cit260.theChosenQuest.model.Game;
import byui.cit260.theChosenQuest.model.Location;
import byui.cit260.theChosenQuest.model.LocationType;
import static byui.cit260.theChosenQuest.model.LocationType.Encampment;
import static byui.cit260.theChosenQuest.model.LocationType.Shop;
import static byui.cit260.theChosenQuest.model.LocationType.Tavern;
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
                
                // Make sure there aren't creatures at Taverns or Shops.
                while (map.getLocation(row, col).getType() == Shop || map.getLocation(row, col).getType() == Tavern){
                    row = (int) (Math.random() * Map.NUM_ROWS);
                    col = (int) (Math.random() * Map.NUM_COLS);
                }

                if (map.getLocation(row, col).getCreatures() == null) {
                    map.getLocation(row, col).setCreatures(c);
                    success = true;
                }

            } while (success == false);

        }
    }

    public static List<Creatures> createCreatureList() {

        List<Creatures> creatureList = new ArrayList<>();

        Creatures dragon = new Creatures();
        dragon.setName("Dragon");
        dragon.setHp(100);
        dragon.setAttack(15);
        dragon.setHit(15);
        dragon.setDefense(6);
        dragon.setGoldDrop(150);
        creatureList.add(dragon);
        
        Creatures spider = new Creatures();
        spider.setName("Spider");
        spider.setHp(25);
        spider.setAttack(6);
        spider.setHit(11);
        spider.setDefense(1);
        spider.setGoldDrop(1);
        creatureList.add(spider);
        
        Creatures troll = new Creatures();
        troll.setName("Troll");
        troll.setHp(20);
        troll.setAttack(8);
        troll.setHit(13);
        troll.setDefense(3);
        troll.setGoldDrop(10);
        creatureList.add(troll);
        
        Creatures skeleton = new Creatures();
        skeleton.setName("skeleton");
        skeleton.setHp(30);
        skeleton.setAttack(5);
        skeleton.setHit(11);
        skeleton.setDefense(1);
        skeleton.setGoldDrop(1);
        creatureList.add(skeleton);
        
        Creatures mimic = new Creatures();
        mimic.setName("Skeleton");
        mimic.setHp(25);
        mimic.setAttack(6);
        mimic.setHit(11);
        mimic.setDefense(1);
        mimic.setGoldDrop(1);
        creatureList.add(mimic);
        
        Creatures beholder = new Creatures();
        beholder.setName("Beholder");
        beholder.setHp(25);
        beholder.setAttack(6);
        beholder.setHit(11);
        beholder.setDefense(1);
        beholder.setGoldDrop(1);
        creatureList.add(beholder);
        
        Creatures lich = new Creatures();
        lich.setName("Lich");
        lich.setHp(25);
        lich.setAttack(6);
        lich.setHit(11);
        lich.setDefense(1);
        lich.setGoldDrop(1);
        creatureList.add(lich);
        
        Creatures rat = new Creatures();
        rat.setName("Rat");
        rat.setHp(25);
        rat.setAttack(6);
        rat.setHit(11);
        rat.setDefense(1);
        rat.setGoldDrop(1);
        creatureList.add(rat);
        
        Creatures minotaur = new Creatures();
        minotaur.setName("Minotaur");
        minotaur.setHp(25);
        minotaur.setAttack(6);
        minotaur.setHit(11);
        minotaur.setDefense(1);
        minotaur.setGoldDrop(1);
        creatureList.add(minotaur);
        
        Creatures blob = new Creatures();
        blob.setName("Ooze");
        blob.setHp(10);
        blob.setAttack(5);
        blob.setHit(12);
        blob.setDefense(3);
        blob.setGoldDrop(15);
        creatureList.add(blob);

        Creatures wolf = new Creatures();
        wolf.setName("Dire Wolf");
        wolf.setHp(15);
        wolf.setAttack(5);
        wolf.setHit(12);
        wolf.setDefense(4);
        wolf.setGoldDrop(5);
        creatureList.add(wolf);

        Creatures goblin = new Creatures();
        goblin.setName("Hobgoblin Soldier");
        goblin.setHp(47);
        goblin.setAttack(7);
        goblin.setHit(12);
        goblin.setDefense(3);
        goblin.setGoldDrop(10);
        creatureList.add(goblin);

        return creatureList;

    }

    public static void listShopInventory() {
        List<Equipment> equipment = createEquipmentList();

        for (Equipment e : equipment) {
            System.out.println(e.getName());
            System.out.println("$" + e.getCost() + " Gold");
            System.out.println("+" + e.getAttack() + " to attack");
            System.out.println("+" + e.getDefense() + " to defense\n");
        }
    }
    
    public static void showPlayerEquipment() {
        List<Equipment> equipment = TheChosenQuest.player.getPlayerEquipment();

        for (Equipment e : equipment) {
            System.out.println(e.getName());
            System.out.println("+" + e.getAttack() + " to attack");
            System.out.println("+" + e.getDefense() + " to defense");
            if (e.getEquiped() == true)
                System.out.println("Equipped\n");
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
        
        Equipment dagger = new Equipment();
        dagger.setName("Dagger");
        dagger.setType("Weapon");
        dagger.setAttack(4);
        dagger.setDefense(0);
        dagger.setCost(5);
        equipmentList.add(dagger);

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
        clothArmor.setName("Cloth Armour");
        clothArmor.setAttack(0);
        clothArmor.setDefense(1);
        clothArmor.setCost(2);
        equipmentList.add(clothArmor);

        Equipment leatherArmour = new Equipment();
        leatherArmour.setName("Leather Armor");
        leatherArmour.setAttack(0);
        leatherArmour.setDefense(2);
        leatherArmour.setCost(15);
        equipmentList.add(leatherArmour);

        Equipment scaleArmor = new Equipment();
        scaleArmor.setName("Scale Armour");
        scaleArmor.setAttack(0);
        scaleArmor.setDefense(3);
        scaleArmor.setCost(25);
        equipmentList.add(scaleArmor);

        Equipment chainArmor = new Equipment();
        chainArmor.setName("Chain Armour");
        chainArmor.setAttack(0);
        chainArmor.setDefense(4);
        chainArmor.setCost(35);
        equipmentList.add(chainArmor);

        Equipment plateArmor = new Equipment();
        plateArmor.setName("Plate Armour");
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
            return true;
        }
        return false;
    }
    
    public void removeCreature(Player player) {
        Location location = player.getLocation();
        if (location.getCreatures() != null)
            location.setCreatures(null);
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
    
    public boolean findRestStop(Player player) {
        // Grab LocationType and save to variable
        LocationType currentLocation = TheChosenQuest.getCurrentGame().getPlayer().getLocation().getType();
        // Check LocationType for Shop, then Display ShopView
        return currentLocation == Encampment || currentLocation == Tavern;
    }
    
    public void dragonCheck(Player player) throws WinGameException {
        if (player.getLocation().getCreatures().getName() == "Dragon")
            throw new WinGameException("Dragon Dead!");      
    }
}
