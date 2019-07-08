import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                System.in
                        )
                );

        String inputPeople = reader.readLine();
        String[] tokensPeople = inputPeople.split(";");
        List<Person> people = new ArrayList<>();

        for (String token : tokensPeople) {
            String[] data = token.split("=");

            try {
                Person person = new Person(data[0], Double.parseDouble(data[1]));
                people.add(person);

            } catch (IllegalArgumentException message) {
                System.out.println(message.getMessage());
            }

        }

        String inputProducts = reader.readLine();
        String[] tokensProducts = inputProducts.split(";");
        List<Product> products = new ArrayList<>();

        for (String product : tokensProducts) {
            String[] data = product.split("=");

            try {
                Product product1 = new Product(data[0], Double.parseDouble(data[1]));
                products.add(product1);
            } catch (IllegalArgumentException message) {
                System.out.println(message.getMessage());
            }
        }
    }
}
