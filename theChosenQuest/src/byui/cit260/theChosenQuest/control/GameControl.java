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
import byui.cit260.theChosenQuest.model.Spells;
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

        // All stats are from D&D book divided by 2 save setDefense and Dragon HP.
        
        Creatures dragon = new Creatures();
        dragon.setName("Dragon");
        dragon.setHp(200);
        dragon.setAttack(12);
        dragon.setHit(15);
        dragon.setDefense(4);
        dragon.setGoldDrop(1500);
        creatureList.add(dragon);
        
        Creatures spider = new Creatures();
        spider.setName("Spider");
        spider.setHp(27);
        spider.setAttack(6);
        spider.setHit(10);
        spider.setDefense(1);
        spider.setGoldDrop(2);
        creatureList.add(spider);
        
        Creatures troll = new Creatures();
        troll.setName("Troll");
        troll.setHp(50);
        troll.setAttack(8);
        troll.setHit(10);
        troll.setDefense(3);
        troll.setGoldDrop(10);
        creatureList.add(troll);
        
        Creatures skeleton = new Creatures();
        skeleton.setName("Skeleton");
        skeleton.setHp(10);
        skeleton.setAttack(4);
        skeleton.setHit(8);
        skeleton.setDefense(1);
        skeleton.setGoldDrop(3);
        creatureList.add(skeleton);
        
        Creatures mimic = new Creatures();
        mimic.setName("Mimic");
        mimic.setHp(25);
        mimic.setAttack(6);
        mimic.setHit(11);
        mimic.setDefense(1);
        mimic.setGoldDrop(15);
        creatureList.add(mimic);
        
        Creatures beholder = new Creatures();
        beholder.setName("Beholder");
        beholder.setHp(60);
        beholder.setAttack(10);
        beholder.setHit(13);
        beholder.setDefense(1);
        beholder.setGoldDrop(25);
        creatureList.add(beholder);
        
        Creatures lich = new Creatures();
        lich.setName("Lich");
        lich.setHp(54);
        lich.setAttack(8);
        lich.setHit(13);
        lich.setDefense(1);
        lich.setGoldDrop(15);
        creatureList.add(lich);
        
        Creatures rat = new Creatures();
        rat.setName("Rat");
        rat.setHp(19);
        rat.setAttack(4);
        rat.setHit(7);
        rat.setDefense(1);
        rat.setGoldDrop(1);
        creatureList.add(rat);
        
        Creatures minotaur = new Creatures();
        minotaur.setName("Minotaur");
        minotaur.setHp(53);
        minotaur.setAttack(8);
        minotaur.setHit(11);
        minotaur.setDefense(1);
        minotaur.setGoldDrop(5);
        creatureList.add(minotaur);
        
        Creatures blob = new Creatures();
        blob.setName("Ooze");
        blob.setHp(51);
        blob.setAttack(6);
        blob.setHit(14);
        blob.setDefense(3);
        blob.setGoldDrop(10);
        creatureList.add(blob);

        Creatures wolf = new Creatures();
        wolf.setName("Dire Wolf");
        wolf.setHp(26);
        wolf.setAttack(6);
        wolf.setHit(12);
        wolf.setDefense(3);
        wolf.setGoldDrop(5);
        creatureList.add(wolf);

        Creatures goblin = new Creatures();
        goblin.setName("Hobgoblin Soldier");
        goblin.setHp(23);
        goblin.setAttack(8);
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

        // all weapon damage is what the dice roll would be (D4,6,8,10) . If we impliment this, we can take out the - defense for a true D&D experience.
        // may make the game more interesting. Something to look into.
        
        Equipment longSword = new Equipment();
        longSword.setName("Long Sword");
        longSword.setAttack(8); 
        longSword.setDefense(0);
        longSword.setCost(15);
        equipmentList.add(longSword);

        Equipment shortSword = new Equipment();
        shortSword.setName("Short Sword");
        shortSword.setAttack(6);
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
        axe.setAttack(10);
        axe.setDefense(0);
        axe.setCost(20);
        equipmentList.add(axe);

        Equipment longBow = new Equipment();
        longBow.setName("Long Bow");
        longBow.setAttack(10);
        longBow.setDefense(0);
        longBow.setCost(30);
        equipmentList.add(longBow);

        Equipment shortBow = new Equipment();
        shortBow.setName("Short Bow");
        shortBow.setAttack(8);
        shortBow.setDefense(0);
        shortBow.setCost(25);
        equipmentList.add(shortBow);

        Equipment staff = new Equipment();
        staff.setName("Staff");
        staff.setAttack(8);
        staff.setDefense(0);
        staff.setCost(15);
        equipmentList.add(staff);

        Equipment mace = new Equipment();
        mace.setName("Mace");
        mace.setAttack(8);
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
        shield.setDefense(2);
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
    
    public static List<Spells> createSpellsList() {

        List<Spells> spellsList = new ArrayList<>();
    
        Spells fireball = new Spells();
        fireball.setName("Fireball");
        fireball.setAttack(15);
        fireball.setDescription("Hurls a fireball at your enemy.");
        spellsList.add(fireball);
        
        Spells magicMissle = new Spells();
        magicMissle.setName("Magic Missle");
        magicMissle.setAttack(10);
        magicMissle.setDescription("You point your finger at the enemy and an arcane blast hurtles at them.");
        magicMissle.setType("Arcane");
        spellsList.add(magicMissle);
        
        Spells iceSpike = new Spells();
        iceSpike.setName("Ice Spike");
        iceSpike.setAttack(20);
        iceSpike.setDescription("The ground below your foe freezes before a spike shoots up from the ground impaling it.");
        iceSpike.setType("Ice");
        spellsList.add(iceSpike);
        
        Spells earthquake = new Spells();
        earthquake.setName("Earthquake");
        earthquake.setAttack(20);
        earthquake.setDescription("The ground shakes and collapses under your foe.");
        earthquake.setType("Earth");
        spellsList.add(earthquake);
        
        Spells gust = new Spells();
        gust.setName("Gust");
        gust.setAttack(8);
        gust.setDescription("The four winds surround your enemy and lifts them off the ground before dropping them back to the earth.");
        gust.setType("Wind");
        spellsList.add(gust);
        
        
        
        return spellsList;
    }    
}
