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
        String inputProducts = reader.readLine();
        String[] tokensProducts = inputProducts.split(";");
        List<Product> products = new ArrayList<>();
        Map<Person, List<Product>> personProductMap = new LinkedHashMap<>();

        try {
            for (String token : tokensPeople) {
                String[] data = token.split("=");

                Person person = new Person(data[0].trim(),
                        Double.parseDouble(data[1].trim()));

                personProductMap.putIfAbsent(person, new ArrayList<>());

            }

            for (String product : tokensProducts) {
                String[] arrayProducts = product.split("=");

                Product product1 = new Product(arrayProducts[0].trim(), Double.parseDouble(arrayProducts[1].trim()));
                products.add(product1);

            }

            String command;
            while (!"ENd".equalsIgnoreCase(command = reader.readLine())) {
                String[] personProduct = command.split("\\s+");
                String personName = personProduct[0].trim();
                String productName = personProduct[1].trim();

                for (Map.Entry<Person, List<Product>> kv : personProductMap.entrySet()) {
                    if (kv.getKey().getName().equals(personName)) {

                        for (Product product : products) {
                            if (product.getName().equals(productName)) {
                                int current = kv.getKey().getListSize();
                                kv.getKey().buyProduct(product);

                                checkPersonProductsCount(personProductMap, kv.getKey(), product, current);

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
                    StringBuilder builder = new StringBuilder();
                    for (int product = 0; product < entry.getValue().size(); product++) {
                        if (product == entry.getValue().size() - 1) {
                            builder.append(entry.getValue().get(product).getName());
                            break;
                        }

                        builder.append(entry.getValue().get(product).getName());
                        builder.append(", ");
                    }

                    System.out.println(entry.getKey().getName() +
                            " - " +
                            builder.toString().trim());

                }
            }
        } catch (IllegalArgumentException message) {
            System.out.println(message.getMessage());
        }

    }

    private static void checkPersonProductsCount(Map<Person, List<Product>> personProductMap, Person person, Product product, int current) {
        if (current < person.getListSize()) {
            personProductMap.get(person).add(product);
            printBoughtOrNot(person, product, "%s bought %s");

        } else {
            printBoughtOrNot(person, product, "%s can't afford %s");
        }
    }

    private static void printBoughtOrNot(Person person, Product product, String text) {
        System.out.println(String.format(
                text,
                person.getName(),
                product.getName()
        ));
    }
}
