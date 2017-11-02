/*
 * @author VRUSHABH
 */
package cloneable;

public class Teacher extends Cloneable{
    
    private String Name;
    private String Subject;
    
    //Clone using Cloneable
    /*when we extend Cloneable Class we need to create a clone method to clone object
        this methods calls the clone method of the super class by 'super.clone();'
        and if the class which doesn't supports cloning then it throws an error called 
        CloneNotSuppotedException so we need to catch that exception, inorder to decide what to do when 
        such case happens, so we surround it with a try and catch
    
        so what happens is 
        
        when we say :
         try{
         do something   and if u get an error, catch it and do the necessary procedure in catch clause
        }catch(What class of exception is thrown e){
            if u get an error do this.
        }
        
        here what we do is try cloning the object but if its not able to clone it, ie not support it
        it will throw error or exception and we print clone not supported and give back the same object back
    
        */
    public  Teacher teacherclone() {
        try {
            // here we need to typecast it cuz super.clone() returns a type of Object class 
            //which is a general object so we need to type cast it to out return type , ie Teacher.
            return (Teacher) super.clone();
        } catch (CloneNotSupportedException e) {
            return this;
        }
    }

    //default constructor
    /*constructor that initializes all instance variables to their default values. 
        ie, null or 0 value
    Note: A default constructor is created automatically even if u don't create it in the class
            so if u don't have a constructor in ur class, and u say Teacher t = new Teacher();
            it will automatically make a default constructor while compiling it.
    */
    public Teacher(){
        
    }
    
    
    //paramaterized constructor
    /*
        paramaterized constructors are created by the user to initailize the instance variables to some values
        that are passed as arguments to the constructor.
    */
    public Teacher(String Name, String Subject) {
            this.Name = Name;
            this.Subject = Subject;
    }
    
     public void sayHello(){
        System.out.println("My Name is "+Name+" and I teach "+ Subject);
    }
    
}
