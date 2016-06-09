import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class _11_LogsAggregator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        LinkedHashMap<String, Integer> logsAndDurration = new LinkedHashMap<>();
        LinkedHashMap<String, TreeSet<String>> namesAndAddresses = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("\\s+");
            String ipAddress = tokens[0];
            String name = tokens[1];
            int durration = Integer.parseInt(tokens[2]);

            if (!logsAndDurration.containsKey(name)){
                logsAndDurration.put(name, durration);
                namesAndAddresses.put(name, new TreeSet<>());
                namesAndAddresses.get(name).add(ipAddress);
            } else{
                int addDurr = logsAndDurration.get(name) + durration;
                logsAndDurration.put(name, addDurr);
                namesAndAddresses.get(name).add(ipAddress);
            }
        }

        // sort logsAndDurration map by key -> string
        LinkedHashMap<String, Integer> sorted =
                logsAndDurration
                        .entrySet()
                        .stream()
                        .sorted((s1, s2) -> s1.getKey().compareTo(s2.getKey()))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2) -> v1, LinkedHashMap::new));

        // print and sort by ip address
        for (String s : sorted.keySet()) {
            StringBuilder lineToPrint = new StringBuilder();
            lineToPrint.append(s + ": " + sorted.get(s) + " ");

                TreeSet<String> ipAddresses= namesAndAddresses.get(s);
                List<String> ipSort = new ArrayList<String>(ipAddresses);
                Collections.sort(ipSort);

                lineToPrint.append("[");
                for (String s2 : ipSort) {
                    lineToPrint.append(s2 + ", ");
                }
            lineToPrint.setLength(lineToPrint.length() - 2);
            lineToPrint.append("]");
            System.out.println(lineToPrint);
        }
    }
}
