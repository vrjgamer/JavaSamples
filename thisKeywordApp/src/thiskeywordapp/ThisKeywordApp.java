/*
 * @author VRUSHABH
 */
package thiskeywordapp;


public class ThisKeywordApp {

    public static void main(String[] args) {
//        firstClass f = new firstClass();
//        f.methodOne();
//        f.methodTwo(40);
//        f.methodThree(50);
    

          System.out.printf("\nCalled No argument Constructor here\n");
          secondClass d = new secondClass();
          d.BuildWell();
          System.out.printf("\nCalled Single argument Constructor here\n");
          secondClass e = new secondClass(10);
          e.BuildWell();
          System.out.printf("\nCalled Two argument Constructor here\n");
          secondClass g = new secondClass(11, 8);
          g.BuildWell();
          System.out.printf("\nCalled Three argument Constructor here\n");
          secondClass r = new secondClass(14, 10, 5);
          r.BuildWell();
        
    }
     
    
    /*
        this can also be used for refering to method within the same class not that important.
        but the thing is:   calling methodOne() and this.methodOne()   is the same thing.
    */
}
