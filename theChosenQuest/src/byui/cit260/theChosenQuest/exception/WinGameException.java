/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.theChosenQuest.exception;

/**
 *
 * @author Zack Durbin
 */
public class WinGameException extends Exception{

    public WinGameException() {
    }

    public WinGameException(String message) {
        super(message);
    }

    public WinGameException(String message, Throwable cause) {
        super(message, cause);
    }

    public WinGameException(Throwable cause) {
        super(cause);
    }

    public WinGameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
