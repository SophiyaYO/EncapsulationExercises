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
        String[] tokens = inputPeople.split(";");

        Map<String, Double> peopleAndMoney = new LinkedHashMap<>();
        List<Person> people = new ArrayList<>();

        for (String token : tokens) {
            String[] data = token.split("=");
            try {
                Person person = new Person(data[0], Double.parseDouble(data[1]));

            } catch (IllegalArgumentException message) {
                System.out.println(message.getMessage());
            }

        }

    }
}
