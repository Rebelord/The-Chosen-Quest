/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

/**
 *
 * @author ryandanielwebb
 */
public class GameMenuView {

    void display() {
        System.out.println("\n*** displayMenu stub function called ***");
      // testing the race selection
       
      System.out.println("\n\n*** Testing out the CharacterCreation ***");
       CharacterRace charCreation = new CharacterRace();
       charCreation.displayCharacterCreation();
       
       //testing class selection
       System.out.println("\n testing the class selection.");
        CharacterClass charClass = new CharacterClass();
        charClass.displayCharacterClass();
                
            
       
       //Testing out the NpcView (Uncomment to test)
       System.out.println("\n\n*** Testing out the NpcView ***");
        NpcView npcChat = new NpcView();
        npcChat.displayNpcView();

       //Testing out the MovementView (Uncomment to test)
       System.out.println("\n\n*** Testing out the NpcView ***");
       MovementView moveMe = new MovementView();
        moveMe.displayMovementView();

            
    }
    void characterCreation() {
    
    }
}
