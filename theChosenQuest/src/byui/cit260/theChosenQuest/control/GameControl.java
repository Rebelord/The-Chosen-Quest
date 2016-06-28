/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.control;

import byui.cit260.theChosenQuest.model.Creatures;
import byui.cit260.theChosenQuest.model.Game;
import byui.cit260.theChosenQuest.model.Location;
import static byui.cit260.theChosenQuest.model.LocationType.Shop;
import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.model.Map;
import byui.cit260.theChosenQuest.view.CombatView;
import byui.cit260.theChosenQuest.view.ShopView;
import thechosenquest.TheChosenQuest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zack Durbin
 */
public class GameControl {

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
        
        Map gameMap = new Map ();
        g.setMap(gameMap);
        
        ShopController equipment = new ShopController();
        g.setEquipment(equipment);
        
        populateMapWithCreatures(gameMap);
        
        player.setLocation(gameMap.getLocation(0, 0));
        
        TheChosenQuest.setCurrentGame(g);
        
      
    }
    
    public static void populateMapWithCreatures(Map map) {
        
        List<Creatures> creatures = createCreatureList();
        boolean success = false;
        
        for(Creatures c : creatures) {
            
            do {
                int row = (int)(Math.random() * Map.NUM_ROWS);
                int col = (int)(Math.random() * Map.NUM_COLS);
            
                 success = false;
                
               if(map.getLocation(row, col).getCreatures() == null) {
                   map.getLocation(row, col).setCreatures(c);
                   success = true;
              }
                
            } while(success == false);
            
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
    
    public boolean findCreature(Player player) {
        Location location = player.getLocation();
        if(location.getCreatures() != null) {
            CombatView fight = new CombatView(player);
            fight.display();
            location.setCreatures(null);
            return true;
        }
        
        return false;
    }
     public boolean findShop(Player player) {
        Location location = player.getLocation();
        if(location.getType() == Shop) {
            ShopView shop = new ShopView();
            shop.display();
            
            return true;
        }
        
        return false;
     }
     }