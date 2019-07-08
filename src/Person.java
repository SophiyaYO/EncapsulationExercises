import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setMoney(double money) {
        if (money <= 0) {
            validationMoney();
        }

        this.money = money;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            validateName();
        }

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void buyProduct(Product product) {
        if (product.getCost() <= this.money) {
            products.add(product);
            this.money -= product.getCost();
        }
    }

    public int getListSize() {
        return this.products.size();
    }

    private void validateName() {
        throw new IllegalArgumentException("Name cannot be empty");
    }

    private void validationMoney() {
        throw new IllegalArgumentException("Money cannot be negative");
    }


}
