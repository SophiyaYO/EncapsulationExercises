import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
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
        String[] tokens = inputPeople.split(";");

        Map<String, Double> peopleAndMoney = new LinkedHashMap<>();

        for (String token : tokens) {
            String[] data = token.split("=");
            peopleAndMoney.put(data[0], Double.parseDouble(data[1]));
        }

        System.out.println(Arrays.toString(tokens));
    }
}
