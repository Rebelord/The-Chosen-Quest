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
public class InputErrorException extends Exception {

    public InputErrorException() {
    }

    public InputErrorException(String message) {
        super(message);
    }

    public InputErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputErrorException(Throwable cause) {
        super(cause);
    }

    public InputErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
