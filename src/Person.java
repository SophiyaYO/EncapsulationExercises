import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private  double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money) {
        if (money < 0) {
            validationMoney();
        }
        this.money = money;
    }

    private void setName(String name) {

    }

    private void validationMoney() {
        throw new IllegalArgumentException("Money cannot be negative");
    }


}
