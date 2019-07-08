public class Product {
    private  String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    private void setCost(double cost) {
        if (cost <= 0) {
            validateNumber();
        }
        this.cost = cost;
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

    public double getCost() {
        return this.cost;
    }

    private void validateName() {
        throw new IllegalArgumentException("Name cannot be empty");

    }

    private void validateNumber() {
        throw new IllegalArgumentException("Money cannot be negative");

    }
}
