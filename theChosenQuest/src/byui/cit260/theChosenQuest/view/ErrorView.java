/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.view;

import java.io.PrintWriter;
import thechosenquest.TheChosenQuest;

/**
 *
 * @author ryandanielwebb
 */
public class ErrorView {

    private static final PrintWriter errorFile = TheChosenQuest.getOutFile();
    private static final PrintWriter logFile = TheChosenQuest.getLogFile();

    public static void display(String className, String errorMsg) {
        errorFile.println("\n|-----------------------------|"
                        + "\n| ERROR: " + errorMsg
                        + "\n|-----------------------------|");
        
        logFile.println(className + " - " + errorMsg);
    }
}
