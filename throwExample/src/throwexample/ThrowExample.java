
package throwexample;

/**
 *
 * @author VRUSHABH
 */
public class ThrowExample {

    public static void main(String[] args) {
        // TODO code application logic here
        
        // link: http://www.javatpoint.com/throw-keyword
        
        /**
            1. "throw"  keyword is used to throw an exception explicitly.
            2.  it is used to throw custom exception.
            3.  checked and unchecked exception (for more info see ExceptionExample)can be thrown.
            4.  throw is followed by an instance example "throw new NULLpointerException("this an error") ".
       */
        
       /*
        Example:
            Suppose, we have a function which will check if  a "child age" is greater than 18 or not and if its not greater than 
            18, we want that it should show it as an error (ie ,an exception  called "ArithmeticException"). else just print "you r an adult!."
        */
       
       /*
               Here we are throwing a custom exception as here we want an error of our choice and on our own condition. 
               
       */
        
       //try this first 
        
       //checkAge(21);
        
        // try this second
        
        //checkAge(15);
        
    }
    
    public static void  checkAge(int age){
        
        if(age < 18){
            throw  new ArithmeticException("you r not an adult!.");
        }else{
            System.out.println("You r an adult!.");
        }
                
    }
    
    
}
