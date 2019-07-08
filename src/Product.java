public class Product {
    private  String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName();
    }

    private void setName() {
        if (name.trim().isEmpty()) {
            validateName();
        }
    }

    private void validateName() {
        throw new IllegalArgumentException("Name cannot be empty");

    }


}
