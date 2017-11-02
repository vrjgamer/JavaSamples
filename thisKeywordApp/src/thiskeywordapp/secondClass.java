 /*
 * @author VRUSHABH
 */
package thiskeywordapp;

/*
    "this keyword" can also be used to refer to an overloaded constructor.
     This idea can used when we want the variables to be initialized to default values,
     if the user doesn't want to pass any values.
     
Note: 
1. "this keyword" can only be the first statement in Constructor.
2. A constructor can have either this or super keyword but not both.

*/


public class secondClass {
    private int l, w, d;
    
    secondClass(){
        /*Constructor with no arguments
          here when we refer to "this()" as a method with three arguments
          (ie, length = 5, width = 5, depth = 5 as we have them as our default values;)
          its calls the main Constructor and initializes the instance variables.
        */
        this(5, 5, 5);
    }
    
    secondClass(int length){
         /*Constructor with Single arguments
          here when we refer to "this()" as a method with three arguments
          (ie,length which was passed and width = 5, depth = 5 as we have them as our default values;)
          its calls the main Constructor and initializes the instance variables.
        */
         
        this(length, 5, 5);
    }
    
    secondClass(int length, int width){
         /*Constructor with Two arguments
          here when we refer to "this()" as a method with three arguments
          (ie,length, width which are passed and depth = 5 as we have it as our default values;)
          its calls the main Constructor and initializes the instance variables.
        */
         
        this(length, width, 5);
    }
    
    //main Constructor
    secondClass(int length, int width, int depth){
        
         l = length;
         w = width;
         d = depth;
         
    }
    
    public void BuildWell(){
        
        System.out.println(l + " " + w + " " + d);
    }
    
}
