import java.util.*;
import java.util.stream.Collectors;

public class _10_PopulationCounter {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();
        TreeMap<String, Long> countryAndPopulation = new TreeMap<>();

        while (true) {
            String line = input.nextLine();

            if (line.equals("report")) {
                break;
            }

            String[] tokens = line.split("\\|");
            String town = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);

            if (!data.containsKey(country)) {
                data.put(country, new LinkedHashMap<String, Long>());
                data.get(country).put(town, population);
                countryAndPopulation.put(country, population);
            } else {
                data.get(country).put(town, population);
                long sum = countryAndPopulation.get(country) + population;
                countryAndPopulation.put(country, sum);
            }
        }

        LinkedHashMap<String, Long> sortedCountryByTotalPopulation =
                countryAndPopulation
                .entrySet()
                .stream()
                .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap<String, Long>::new));

        for (String country : sortedCountryByTotalPopulation.keySet()) {
            System.out.printf("%s (total population: %d)", country, sortedCountryByTotalPopulation.get(country)).println();

            for (String city : data.keySet()) {
                LinkedHashMap<String, Long> sortedCountryInfo = data
                        .get(country)
                        .entrySet()
                        .stream()
                        .sorted((v1, v2) -> v2.getValue().compareTo(v1.getValue()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (c1, c2) -> c1, LinkedHashMap<String, Long>::new));

                for (String s : sortedCountryInfo.keySet()) {
                    System.out.printf("=>%s: %d", s, sortedCountryInfo.get(s)).println();
                }
                break;
            }
        }
    }
}
