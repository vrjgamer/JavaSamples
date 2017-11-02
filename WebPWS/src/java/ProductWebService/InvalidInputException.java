/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductWebService;

/**
 *
 * @author VRUSHABH
 */
public class InvalidInputException extends Exception{
    
    private String errorDetails;

    public InvalidInputException(String errorDetails, String reason) {
        super(reason);
        this.errorDetails = errorDetails;
    }
    
    public String getFaultInfo(){
        return this.errorDetails;
    }
    
    
}
