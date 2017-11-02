/*
 * @author VRUSHABH
 */
package temp_project;

import java.util.StringTokenizer;


public class Temp_project {

    public static void main(String[] args) {

        String s = "Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday";
        System.out.println(SplitAndReverse(s));
        
    }

    public static int getLength(String str) {
        int length = 0;
        char[] array = str.toCharArray();

        for (char c : array) {
            length++;
        }

        return length;
    }
 
   public static String ReverseString(String str1) {
        char[] main, reverse;
        int length = getLength(str1) - 1;

        main = str1.toCharArray();
        reverse = str1.toCharArray();

        for (char c : main) {
            reverse[length] = c;
            length--;
        }
        return new String(reverse);
    }
   
   public static String SplitAndReverse(String str){
       String returnString = "";
       StringTokenizer tokenizer = new StringTokenizer(str, ",");
       while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            returnString = returnString + " "+ ReverseString(word) +",";
       }

       return returnString;
   }
 
   
}
