/*
 *@author VRUSHABH
 */
package superkeywordapp;

public class daughter extends Mom {

    public daughter(String name, String surname, int money) {
        //calling the parent class constructor from subclass.
        super(name, surname, money);
    }

    public void gotMarried(String surname) {
        //referencing public variable of the parent class in the subclass
        super.Surname = surname;
    }

    public void putMyMoney(int money) {
        //using parent class method in subclass
        super.putMoney(money);
    }

    public void getMoneyFromMom() {
        int pocketMoney = super.getMoney();
        System.out.println("My pocket money " + pocketMoney);
    }

}
