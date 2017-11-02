
/*
 * @author VRUSHABH
 */
package typesconstructor;

public class ExampleClass1 {
    
    private int number;
    private String name;
    
    /*This class contains no constructor as u can see, but in when we create objects in java or 
    any other OOP (object oriented programming) language, we need to create a new instance of the class
    for each object we create. Therefore, if the programmer doesn't write any consructor  for the class
    the compiler will auto generate a "Default constructor" for the class that takes no parameters.
    this constructor intializes the instance variables to their default values for example :
                            default value of  int is 0 and for string is null 
    thats the reason when we call the printVals for an object of Class ExampleClass1 it prints:
                             name: null number: 0.
    
    */
    
    //method to print instance variable values.
     public void printVals(){
        System.out.println("name: "+this.name +" number: "+this.number);
    }
    
}
