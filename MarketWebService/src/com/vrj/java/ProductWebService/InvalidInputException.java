package com.vrj.java.ProductWebService;

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
