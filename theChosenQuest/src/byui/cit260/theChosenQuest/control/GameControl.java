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
        dragon.setHp(158);
        dragon.setAttack(8);
        dragon.setDice(12);
        dragon.setRolls(1);
        dragon.setHit(13);
        dragon.setDefense(2);
        dragon.setGoldDrop(1500);
        creatureList.add(dragon);
        
        Creatures spider = new Creatures();
        spider.setName("Spider");
        spider.setHp(26);
        spider.setAttack(3);
        spider.setDice(6);
        spider.setRolls(1);
        spider.setHit(10);
        spider.setDefense(1);
        spider.setGoldDrop(2);
        creatureList.add(spider);
        
        Creatures troll = new Creatures();
        troll.setName("Troll");
        troll.setHp(50);
        troll.setAttack(7);
        troll.setDice(6);
        troll.setRolls(1);
        troll.setHit(10);
        troll.setDefense(3);
        troll.setGoldDrop(10);
        creatureList.add(troll);
        
        Creatures skeleton = new Creatures();
        skeleton.setName("Skeleton");
        skeleton.setHp(10);
        skeleton.setAttack(4);
        skeleton.setDice(6);
        skeleton.setRolls(1);
        skeleton.setHit(8);
        skeleton.setDefense(1);
        skeleton.setGoldDrop(3);
        creatureList.add(skeleton);
        
        Creatures mimic = new Creatures();
        mimic.setName("Mimic");
        mimic.setHp(36);
        mimic.setAttack(7);
        mimic.setDice(8);
        mimic.setRolls(1);
        mimic.setHit(11);
        mimic.setDefense(1);
        mimic.setGoldDrop(15);
        creatureList.add(mimic);
        
        Creatures beholder = new Creatures();
        beholder.setName("Beholder");
        beholder.setHp(60);
        beholder.setAttack(5);
        beholder.setDice(4);
        beholder.setRolls(1);
        beholder.setHit(13);
        beholder.setDefense(1);
        beholder.setGoldDrop(25);
        creatureList.add(beholder);
        
        Creatures lich = new Creatures();
        lich.setName("Lich");
        lich.setHp(54);
        lich.setAttack(6);
        lich.setDice(8);
        lich.setRolls(1);
        lich.setHit(13);
        lich.setDefense(1);
        lich.setGoldDrop(15);
        creatureList.add(lich);
        
        Creatures rat = new Creatures();
        rat.setName("Rat");
        rat.setHp(38);
        rat.setAttack(5);
        rat.setDice(4);
        rat.setRolls(1);
        rat.setHit(7);
        rat.setDefense(1);
        rat.setGoldDrop(1);
        creatureList.add(rat);
        
        Creatures minotaur = new Creatures();
        minotaur.setName("Minotaur");
        minotaur.setHp(53);
        minotaur.setAttack(4);
        minotaur.setDice(10);
        minotaur.setRolls(1);
        minotaur.setHit(11);
        minotaur.setDefense(1);
        minotaur.setGoldDrop(5);
        creatureList.add(minotaur);
        
        Creatures blob = new Creatures();
        blob.setName("Ooze");
        blob.setHp(51);
        blob.setAttack(8);
        blob.setDice(6);
        blob.setRolls(1);
        blob.setHit(14);
        blob.setDefense(3);
        blob.setGoldDrop(10);
        creatureList.add(blob);

        Creatures wolf = new Creatures();
        wolf.setName("Dire Wolf");
        wolf.setHp(38);
        wolf.setAttack(5);
        wolf.setDice(6);
        wolf.setRolls(1);
        wolf.setHit(12);
        wolf.setDefense(3);
        wolf.setGoldDrop(5);
        creatureList.add(wolf);

        Creatures goblin = new Creatures();
        goblin.setName("Hobgoblin Soldier");
        goblin.setHp(24);
        goblin.setAttack(6);
        goblin.setDice(10);
        goblin.setRolls(1);
        goblin.setHit(12);
        goblin.setDefense(3);
        goblin.setGoldDrop(10);
        creatureList.add(goblin);

        return creatureList;

    }

    public static void listShopInventory() {
        List<Equipment> equipment = createEquipmentList();
        Boolean armourList = false;
        int listItem = 1;
        
        // Display Header for Items
        System.out.println("--- Weapons -----------------------------------");
        System.out.println("Item Name\t\tCost\tAttack\tDefense");
        System.out.println("-----------------------------------------------");
        
        // Loop to display shop list.
        for (Equipment e : equipment) {
            
            // Display header for Armour.
            if (e.getType() == "Armour" && armourList != true) {
                System.out.println("--- Armour ------------------------------------");
                System.out.println("Item Name\t\tCost\tAttack\tDefense");
                System.out.println("-----------------------------------------------");
                armourList = true;
            }
            
            // Fix formatting for short item names and display item.
            if (e.getName().length() < 5)
                System.out.println(listItem + ". " + e.getName() + "\t\t\t" + e.getCost() + "G\t+ 1D" + e.getDice() + "\t+" + e.getDefense() + "\n");
            else if (e.getName().length() > 11 && listItem > 9)
                System.out.println(listItem + ". " + e.getName() + "\t" + e.getCost() + "G\t+ 1D" + e.getDice() + "\t+" + e.getDefense() + "\n");
            else
                System.out.println(listItem + ". " + e.getName() + "\t\t" + e.getCost() + "G\t+ 1D" + e.getDice() + "\t+" + e.getDefense() + "\n");
            
            listItem++;
        }
    }
    
    public static void showPlayerEquipment() {
        List<Equipment> equipment = TheChosenQuest.player.getPlayerEquipment();
        
        System.out.println("\n--- Inventory ---------------------------------");
        System.out.println("Item Name\tEquipped\tAttack\tDefense");
        System.out.println("-----------------------------------------------");

        equipment.stream().forEach((e) -> {
            if (e.getName().length() < 7)
                System.out.println(e.getName() + "\t\t" + e.getEquiped() + "\t\t+ 1D" + e.getDice() + "\t+" + e.getDefense());
            else
                System.out.println(e.getName() + "\t" + e.getEquiped() + "\t\t+ 1D" + e.getDice() + "\t+" + e.getDefense());
        });
    }

    public static List<Equipment> createEquipmentList() {

        List<Equipment> equipmentList = new ArrayList<>();

        // all weapon damage is what the dice roll would be (D4,6,8,10) . If we impliment this, we can take out the - defense for a true D&D experience.
        // may make the game more interesting. Something to look into.
        
        Equipment longSword = new Equipment();
        longSword.setName("Long Sword");
        longSword.setType("Weapon");
        longSword.setAttack(2);
        longSword.setDice(8);
        longSword.setRolls(1);
        longSword.setDefense(0);
        longSword.setCost(15);
        longSword.setEquiped(false);
        equipmentList.add(longSword);

        Equipment shortSword = new Equipment();
        shortSword.setName("Short Sword");
        shortSword.setAttack(1);
        shortSword.setDice(6);
        shortSword.setRolls(1);
        shortSword.setDefense(0);
        shortSword.setCost(10);
        shortSword.setType("Weapon");
        shortSword.setEquiped(false);
        equipmentList.add(shortSword);
        
        Equipment dagger = new Equipment();
        dagger.setName("Dagger");
        dagger.setType("Weapon");
        dagger.setAttack(1);
        dagger.setDice(4);
        dagger.setRolls(1);
        dagger.setDefense(0);
        dagger.setCost(5);
        dagger.setType("Weapon");
        dagger.setEquiped(false);
        equipmentList.add(dagger);

        Equipment axe = new Equipment();
        axe.setName("Axe");
        axe.setAttack(2);
        axe.setDice(10);
        axe.setRolls(1);
        axe.setDefense(0);
        axe.setCost(20);
        axe.setType("Weapon");
        axe.setEquiped(false);
        equipmentList.add(axe);

        Equipment longBow = new Equipment();
        longBow.setName("Long Bow");
        longBow.setAttack(1);
        longBow.setDice(10);
        longBow.setRolls(1);
        longBow.setDefense(0);
        longBow.setCost(30);
        longBow.setType("Weapon");
        longBow.setEquiped(false);
        equipmentList.add(longBow);

        Equipment shortBow = new Equipment();
        shortBow.setName("Short Bow");
        shortBow.setAttack(1);
        shortBow.setDice(8);
        shortBow.setRolls(1);
        shortBow.setDefense(0);
        shortBow.setCost(25);
        shortBow.setType("Weapon");
        shortBow.setEquiped(false);
        equipmentList.add(shortBow);

        Equipment staff = new Equipment();
        staff.setName("Staff");
        staff.setAttack(3);
        staff.setDice(8);
        staff.setRolls(1);
        staff.setDefense(0);
        staff.setCost(15);
        staff.setType("Weapon");
        staff.setEquiped(false);
        equipmentList.add(staff);

        Equipment mace = new Equipment();
        mace.setName("Mace");
        mace.setAttack(1);
        mace.setDice(8);
        mace.setRolls(1);
        mace.setDefense(0);
        mace.setCost(18);
        mace.setType("Weapon");
        mace.setEquiped(false);
        equipmentList.add(mace);

        Equipment clothArmour = new Equipment();
        clothArmour.setName("Cloth Armour");
        clothArmour.setAttack(0);
        clothArmour.setDefense(11);
        clothArmour.setCost(2);
        clothArmour.setType("Armour");
        clothArmour.setEquiped(false);
        equipmentList.add(clothArmour);

        Equipment leatherArmour = new Equipment();
        leatherArmour.setName("Leather Armour");
        leatherArmour.setAttack(0);
        leatherArmour.setDefense(12);
        leatherArmour.setCost(15);
        leatherArmour.setType("Armour");
        leatherArmour.setEquiped(false);
        equipmentList.add(leatherArmour);

        Equipment scaleArmour = new Equipment();
        scaleArmour.setName("Scale Armour");
        scaleArmour.setAttack(0);
        scaleArmour.setDefense(13);
        scaleArmour.setCost(25);
        scaleArmour.setType("Armour");
        scaleArmour.setEquiped(false);
        equipmentList.add(scaleArmour);

        Equipment chainArmour = new Equipment();
        chainArmour.setName("Chain Armour");
        chainArmour.setAttack(0);
        chainArmour.setDefense(14);
        chainArmour.setCost(35);
        chainArmour.setType("Armour");
        chainArmour.setEquiped(false);
        equipmentList.add(chainArmour);

        Equipment plateArmor = new Equipment();
        plateArmor.setName("Plate Armour");
        plateArmor.setAttack(0);
        plateArmor.setDefense(15);
        plateArmor.setCost(45);
        plateArmor.setType("Armour");
        plateArmor.setEquiped(false);
        equipmentList.add(plateArmor);

        Equipment shield = new Equipment();
        shield.setName("Shield");
        shield.setDefense(2);
        shield.setCost(5);
        shield.setType("Armour");
        shield.setEquiped(false);
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
    
    public int weaponAttack(Player player) {
        
        // Intialize variables.
        int attack = 0;
        
        // Grab the player's inventory.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        
        // Add attack for each weapon equiped.
        for (Equipment e : playerEquipment) {
            if (e.getEquiped())
                attack += e.getAttack();
        }
            
        return attack;
    }
    
    public int armourDefense(Player player) {
        
        // Intialize variables.
        int defense = 0;
        
        // Grab the player's inventory.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        
        // Add defense for each armour piece equiped.
        for (Equipment e : playerEquipment) {
            if (e.getEquiped())
                defense += e.getDefense();
        }
            
        return defense;
    }
   
    public int weaponDice(Player player) {
        
        // Intialize variables.
        int dice = 0;
        
        // Grab the player's inventory.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        
        // Add defense for each armour piece equiped.
        for (Equipment e : playerEquipment) {
            if (e.getEquiped())
                dice += e.getDice();
        }
            
        return dice;
    }
    
    public int weaponRoll(Player player) {
        
        // Intialize variables.
        int roll = 0;
        
        // Grab the player's inventory.
        List<Equipment> playerEquipment = TheChosenQuest.player.getPlayerEquipment();
        
        // Add defense for each armour piece equiped.
        for (Equipment e : playerEquipment) {
            if (e.getEquiped())
                roll += e.getRolls();
        }
            
        return roll;
    }
}
