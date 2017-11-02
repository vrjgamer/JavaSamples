/*
 * @author VRUSHABH
 */

package stringtokenizerapp;

import java.util.StringTokenizer;

public class StringTokenizerApp {

    public static void main(String[] args) {
      
        /* StringTokenizer is used to split a string into smaller ones on the basis of a seperator
            It take a string and finds the seperator and then divides it at that point creating
            a enum array of string with elements as the part of main string.
                StringTokenizer has 2 constructors:
                1. with single parameter, ie just the string and in this the default delimiter is space
                2. with two parameters, ie the string and second is the set of delimiters.
                         note: u can put more than one delimiter to split the string.
                after calling the constructor we use a while loop with a condition whether 
                Stringtokenizer has any elements left or not using method hasMoreElements() which returns a 
                boolea and we use use method nextElement() to get the element in the element array
        
                for example: 
                        if we have a string as "I want a dog, I want a cat too", and we wanna split this into 
                        two string programmatically, we use 'StringTokenizer' on this string and use ',' as our delimiter
                        the we will get two string one as "I want a dog" and second "I want a cat".
        
        */
        
       
        
        
//        String str1 = "My name is vaidehi";
//        StringTokenizer tokenizer1 = new StringTokenizer(str1);
//        System.out.println("Spliting on basis of default delimiter ie., space");
//           
//        while (tokenizer1.hasMoreElements()) {
//            System.out.println(tokenizer1.nextElement());
//            
//        }
        
//        String str2 = "Hello|world,I|m|vaidehi";
//        StringTokenizer tokenizer2 = new StringTokenizer(str2, ",");
//        System.out.printf("\nSpliting on basis of a custom delimiter here, '|' \n");
//        
//        while (tokenizer2.hasMoreElements()) {
//            System.out.println( tokenizer2.nextElement());
//            
//        }

    
        
//         String str3 = "a,b:c,d|e.f,g";
//        StringTokenizer tokenizer3 = new StringTokenizer(str3, ",:|.");
//        System.out.printf("\nSpliting on basis of multiple delimiters here, '|' , ',' , ':', '.' \n");
//        
//        while (tokenizer3.hasMoreElements()) {
//            System.out.println( tokenizer3.nextElement());
//            
//        }
      
//      String str5 = "my mom my dad cast my bro my cat my dog ";
//        System.out.printf("\nCounting occurence of 'my' in the string = %s\n", str5);
//        CountOccurence(str5, "my");
//        
       
       /*Nowadays, Nobody uses StringTokenizer as it uses enumeration which 
            increases time and space complexity, ie it is slow and uses more space.
            Use split(); instead which much faster and better than tokenizer.
           After splitting it gives back an array of string.
       */
        System.out.printf("\nSplitting using split() method on string");
       int i = 0;
       String str4 = "hello there! who r u?";
       String[] elements = str4.split(" ");
        System.out.println(); 
       while (i <elements.length) {
            System.out.println( elements[i]);
             i++;
        }        
 
    }
          
    public static void CountOccurence(String str, String element){
        int count = 0;
        StringTokenizer stringTokenizer = new StringTokenizer(str);
       while (stringTokenizer.hasMoreTokens()) {
           String str1 = stringTokenizer.nextToken();
           if(str1.equals(element))
               count++;
       }
        System.out.println("The Count of the element '"+ element+"' is: "+ count);
    }
    
    
}
