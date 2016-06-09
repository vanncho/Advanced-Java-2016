import sun.reflect.generics.tree.Tree;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _13_SrabskoUnleashed {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);;
        TreeMap<String, TreeMap<String, Integer>> data = new TreeMap<>();

        while (true){

            String line = input.nextLine();
            if (!line.equals("End")){
                String patternString = "(.*) @(.*) (.\\d+) (.\\d+)";
                Pattern pattern = Pattern.compile(patternString);
                Matcher matches = pattern.matcher(line);
                boolean isMatch = matches.matches();

                if (isMatch){
                    String singer = matches.group(1);
                    String venue = matches.group(2);
                    int ticketPrice = Integer.parseInt(matches.group(3));
                    int ticketsCount = Integer.parseInt(matches.group(4));
                    int ticketsAmount = ticketPrice * ticketsCount;

                    if (!data.containsKey(venue)){
                        data.put(venue, new TreeMap<String, Integer>());

                        if (!data.get(venue).containsKey(singer)){
                            data.get(venue).put(singer, ticketsAmount);
                        } else if (data.get(venue).containsKey(singer)){
                            int currTicketAmaunt = data.get(venue).get(singer) + ticketsAmount;
                            data.get(venue).put(singer, currTicketAmaunt);
                        }
                    } else if (data.containsKey(venue)){

                        if (!data.get(venue).containsKey(singer)){
                            data.get(venue).put(singer, ticketsAmount);
                        } else if (data.get(venue).containsKey(singer)){
                            int currTicketAmaunt = data.get(venue).get(singer) + ticketsAmount;
                            data.get(venue).put(singer, currTicketAmaunt);
                        }
                    }
                } else{
                    continue;
                }

            } else {
                break;
            }
        }

        for (String venue : data.keySet()) {

            System.out.println(venue);
            LinkedHashMap<String, Integer> singerAndTicketsAmountSorted = data.get(venue)
                    .entrySet()
                    .stream()
                    .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap<String, Integer>::new));

            for (String singer : singerAndTicketsAmountSorted.keySet()) {
                System.out.printf("#  %s -> %d", singer, singerAndTicketsAmountSorted.get(singer)).println();
            }
        }
    }
}
