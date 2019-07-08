public class Product {
    private  String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName();
        this.setCost();
    }

    private void setCost() {
        if (cost < 0) {
            validateNumber();
        }
    }

    private void setName() {
        if (name.trim().isEmpty()) {
            validateName();
        }
    }

    private void validateName() {
        throw new IllegalArgumentException("Name cannot be empty");

    }

    private void validateNumber() {
        throw new IllegalArgumentException("Cost cannot be negative");

    }


}
