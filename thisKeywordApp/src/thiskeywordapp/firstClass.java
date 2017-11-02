/*
 * @author VRUSHABH
 */
package thiskeywordapp;

public class firstClass {
    
    private int var = 5;
    
    public void firstClass(){
        //Constructor
       /* o
        this keyword is used for refering to the current instance varaible 
        it is used when we have local variable and instance variables
        have same name. In this class we have refered to the variable "var"
        in the three methods. 
        */
    }

    public void methodOne() {
        
        /* In the first method "methodOne" "var" refers to 
        the global declaration of "var" and thats why it prints 5.*/
        
        System.out.println("Method ONE Prints variable as: " + var);
        
    }

    public void methodTwo(int var) {
        
        /* In the second method "methodTwo" "var" refers to the local declaration
        of "var" and therefore it prints the value that is passed in the method.
        */
        
        System.out.println("Method TWO Prints variable as: " + var);
    }

    public void methodThree(int var) {
        
        /* In the third method "methodThree" "var" refers to the global declaration
        of "var" and prints 5 again. here when we write "this.var" it takes the value
        of the instance variable.
        */
        
       System.out.println("Method THREE Prints variable as: " + this.var);
    }
     
    
    
    
}
