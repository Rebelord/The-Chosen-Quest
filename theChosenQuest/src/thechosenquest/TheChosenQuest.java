/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thechosenquest;

import byui.cit260.theChosenQuest.model.Player;
import byui.cit260.theChosenQuest.view.StartProgramView;
import byui.cit260.theChosenQuest.model.Game;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author ryandanielwebb
 */
public class TheChosenQuest {
    private static Game currentGame;
    public static Player player;
    
    private static PrintWriter outFile;
    private static BufferedReader inFile;
    
    private static PrintWriter logFile;
    

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        TheChosenQuest.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        TheChosenQuest.player = player;
    }

    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        TheChosenQuest.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        TheChosenQuest.inFile = inFile;
    }

    public static PrintWriter getLogfile() {
        return logFile;
    }

    public static void setLogfile(PrintWriter logFile) {
        TheChosenQuest.logFile = logFile;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // Create StartProgramViewOrig and display the start program view
        StartProgramView startProgramView = null;
        
        try {
            inFile = new BufferedReader (new InputStreamReader(System.in));
            outFile = new PrintWriter(System.out, true);
            String logPath = "log.txt";
            logFile = new PrintWriter(logPath);
            startProgramView = new StartProgramView();
            
            startProgramView.displayStartProgramView();   
        } catch (Exception e) {
            e.printStackTrace();
            startProgramView.displayStartProgramView();        
        } finally {
            try {
                if (inFile != null) {
                    inFile.close();
                }
                if (outFile != null) {
                    outFile.close();
                }
                if (logFile != null) {
                    logFile.close();
                }
            } catch (Exception ex) {
                System.out.println("Error closing files");
            }
        }
    }

    public static PrintWriter getLogFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
