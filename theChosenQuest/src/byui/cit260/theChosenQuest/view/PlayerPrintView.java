/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author ryandanielwebb
 */
public class PlayerPrintView {
    public static void saveGame(String filePath) {
        try {
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject("       Player Info");
            oos.writeObject(TheChosenQuest.getPlayer());
        } catch (Exception e) {
            ErrorView.display("PlayerPrintView", e.getMessage());
        }
    }
}
