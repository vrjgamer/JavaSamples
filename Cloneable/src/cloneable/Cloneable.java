/*
 * @author VRUSHABH
 */
package cloneable;


public class Cloneable {

    public static void main(String[] args) {
        
            Student s = new Student("RAJ", 85);
            s.sayHello();
        
        //Using Constructor
            Student p = new Student(s);
            p.sayHello();
       
        
        //By Assignig Values
            Student r = new Student();
            r.marks = s.marks;
            r.name = s.name;
            r.sayHello();
       
        //using cloneable class
            Teacher t = new Teacher("Vaidehi", "Maths");
            t.sayHello();
            
            Teacher copy;  
            copy  = t.teacherclone();
            copy.sayHello();
            
            
    }
    
}
