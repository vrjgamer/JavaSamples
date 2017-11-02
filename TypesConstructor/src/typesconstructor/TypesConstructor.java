/*
 * @author VRUSHABH
 */
package typesconstructor;

public class TypesConstructor {

    public static void main(String[] args) {
        
        ExampleClass1 exampleClass1 = new ExampleClass1();
        System.out.printf("ExampleClass1 contains no Constructor: \n so compiler generates a default constructor for the class\n which takes no parameters\n\n");
        exampleClass1.printVals();
        
        ExampleClass2 exampleClass21 = new ExampleClass2();
        System.out.printf("\nExampleClass2 contains a Constructor with no parameters \nwhich is basically default Constructor: \n\n");
        exampleClass21.printVals();
        
        ExampleClass2 exampleClass22 = new ExampleClass2("varun", 96);
        System.out.println("\nExampleClass2 contains a Construuctor with parameters\n which is called as paramaterized constructor \nas it takes parameters: \n\n");

        exampleClass22.printVals();
        
    }
    
}
