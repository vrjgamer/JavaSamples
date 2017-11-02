/*
 * @author VRUSHABH
 */
package cloneable;

public class Student  {
    //while using constructor for copying
//    private String name;
//    private int marks;
    
    //constructor used to clone using constructor
    public Student(Student student) {
        this(student.getName(), student.getMarks());
    }
    
    
    // while using 'assigning variables'   
    String name;
    int marks; 
    
    //default constructor
    public Student(){
        
    }
    
    //paramatarized constructor
    public  Student(String name, int marks){
        this.marks = marks;
        this.name = name;
    }
    
    
    
    public  String getName(){
        return name;
    }

    public int getMarks(){
        return  marks;
    }
    
    public void sayHello(){
        System.out.println("My Name is "+name+" and my marks is: "+marks);
    }
    
}
