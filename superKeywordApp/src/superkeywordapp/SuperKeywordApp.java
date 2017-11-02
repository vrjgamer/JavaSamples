/*
 * @author VRUSHABH
 */
package superkeywordapp;

public class SuperKeywordApp {

    public static void main(String[] args) {

        Mom mom = new Mom("Neha", "thakur", 1000);
        daughter child = new daughter("shena", "thakur", 200);

        System.out.println("Mom:");
        mom.SayHello();
        System.out.println("Daughter:");
        child.SayHello();

        System.out.println("Daughter: I want money.");
        child.getMoneyFromMom();

        System.out.println("Daughter: I got married.");
        child.gotMarried("sharma");
        child.SayHello();
    }

}
