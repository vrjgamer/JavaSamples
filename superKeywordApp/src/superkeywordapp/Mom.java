/*
 * @author VRUSHABH
 */
package superkeywordapp;

public class Mom {

    String Surname;

    private int Money;
    private String Name;

    public Mom(String name, String surname, int money) {
        this.Money = money;
        this.Name = name;
        this.Surname = surname;
    }

    public void SayHello() {
        System.out.println("Hello I m " + this.Name + " " + this.Surname);
    }

    public String getName() {
        return Name;
    }

    public int getMoney() {
        return Money;
    }

    private void setName(String name) {
        this.Name = name;
    }

    private void setMoney(int money) {
        this.Money = money;
    }

    public int putMoney(int money) {
        return (this.Money = this.Money + money);
    }

}
