import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _13_OfficeStuff {
    public static void main(String[] args) throws IOException {


        Map<String, LinkedHashMap<String, Integer>> office = new LinkedHashMap<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String line = reader.readLine();
            int numberOfLines = Integer.valueOf(line);

            for (int i = 0; i < numberOfLines; i++) {

                String[] tokens = reader.readLine().split("(\\||\\s\\-\\s)");
                String organization = tokens[1];
                int amount = Integer.valueOf(tokens[2]);
                String product = tokens[3];

                if (!office.containsKey(organization)){
                    office.put(organization, new LinkedHashMap<>());
                    office.get(organization).put(product, amount);
                } else if (office.containsKey(organization)){

                    if (!office.get(organization).containsKey(product)){
                        office.get(organization).put(product, amount);
                    } else if (office.get(organization).containsKey(product)){
                        int currAmount = office.get(organization).get(product) + amount;
                        office.get(organization).put(product, currAmount);

                    }
                }
            }
        }

        LinkedHashMap<String, LinkedHashMap<String, Integer>> sortedOffice = office.entrySet()
                .stream()
                .sorted((org1, org2) -> org1.getKey().compareTo(org2.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap<String, LinkedHashMap<String, Integer>>::new));

        for (String firm : sortedOffice.keySet()) {
            StringBuilder toAppend = new StringBuilder();
            toAppend.append(firm + ": ");

            LinkedHashMap<String, Integer> vals = sortedOffice.get(firm);
            for (String product : vals.keySet()) {
                toAppend.append(product + "-" + vals.get(product) + ", ");
            }
            toAppend.setLength(toAppend.length() - 2);
            System.out.println(toAppend.toString());
        }
    }
}
