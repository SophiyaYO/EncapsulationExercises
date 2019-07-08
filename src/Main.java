import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        Map<Person, List<Product>> personProductMap = new LinkedHashMap<>();

        for (String token : tokensPeople) {
            String[] data = token.split("=");

            try {
                Person person = new Person(data[0].trim(), Double.parseDouble(data[1].trim()));
                people.add(person);
                personProductMap.putIfAbsent(person, new ArrayList<>());

            } catch (IllegalArgumentException message) {
                System.out.println(message.getMessage());
            }

        }

        String inputProducts = reader.readLine();
        String[] tokensProducts = inputProducts.split(";");
        List<Product> products = new ArrayList<>();

        for (String product : tokensProducts) {
            String[] arrayProducts = product.split("=");

            try {
                Product product1 = new Product(arrayProducts[0].trim(), Double.parseDouble(arrayProducts[1].trim()));
                products.add(product1);
            } catch (IllegalArgumentException message) {
                System.out.println(message.getMessage());
            }
        }

        String command;
        while (!"ENd".equalsIgnoreCase(command = reader.readLine())) {
            String[] personProduct = command.split("\\s+");
            String personName = personProduct[0];
            String productName = personProduct[1];

            for (Person person : people) {
                if (person.getName().equals(personName)) {
                    for (Product product : products) {
                        if (product.getName().equals(productName)) {
                            int current = person.getListSize();
                            person.buyProduct(product);
                            if (current < person.getListSize()) {
                                personProductMap.get(person).add(product);
                            }
                        }
                    }
                }
            }
        }


        for (Map.Entry<Person, List<Product>> entry : personProductMap.entrySet()) {
            if (entry.getValue().size() == 0) {
                System.out.println(String.format("%s – Nothing bought",
                        entry.getKey().getName()));
            } else {
                System.out.print(entry.getKey().getName() + " - ");

                StringBuilder builder = new StringBuilder();
                for (int product = 0; product < entry.getValue().size(); product++) {
                    if (product == entry.getValue().size() - 1) {
                        builder.append(entry.getValue().get(product).getName());
                        break;
                    }

                    builder.append(entry.getValue().get(product).getName());
                    builder.append(", ");
                }

                System.out.println(builder.toString().trim());

            }
        }


    }
}
