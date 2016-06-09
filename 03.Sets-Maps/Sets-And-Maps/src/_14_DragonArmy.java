import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class _14_DragonArmy {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        input.nextLine();
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = input.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = 45;
            int health = 250;
            int armor = 10;

            if (!tokens[2].equals("null")) {
                damage = Integer.parseInt(tokens[2]);
            }
            if (!tokens[3].equals("null")) {
                health = Integer.parseInt(tokens[3]);
            }
            if (!tokens[4].equals("null")) {
                armor = Integer.parseInt(tokens[4]);
            }

            if (!dragons.containsKey(type)){
                dragons.put(type, new TreeMap<>());

                if (!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name, new int[3]);
                }
                dragons.get(type).get(name)[0] = damage;
                dragons.get(type).get(name)[1] = health;
                dragons.get(type).get(name)[2] = armor;
            } else {

                if (!dragons.get(type).containsKey(name)){
                    dragons.get(type).put(name, new int[3]);
                }
                dragons.get(type).get(name)[0] = damage;
                dragons.get(type).get(name)[1] = health;
                dragons.get(type).get(name)[2] = armor;
            }
        }

        for (String dragonType : dragons.keySet()) {

            int sumDamage = 0;
            int sumHealth = 0;
            int sumArmor = 0;

            LinkedHashMap<String, int[]> dragonNames = dragons.get(dragonType)
                    .entrySet()
                    .stream()
                    .sorted((n1, n2) -> n1.getKey().compareTo(n2.getKey()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap<String, int[]>::new));

            for (String s : dragonNames.keySet()) {
                sumDamage += dragonNames.get(s)[0];
                sumHealth += dragonNames.get(s)[1];
                sumArmor += dragonNames.get(s)[2];
            }
            System.out.printf("%s::(%.2f/%.2f/%.2f)", dragonType, ((double)sumDamage / dragonNames.size()), ((double)sumHealth / dragonNames.size()), ((double)sumArmor / dragonNames.size())).println();

            for (String s : dragonNames.keySet()) {
                System.out.printf("-%s -> damage: %d, health: %d, armor: %d", s, dragonNames.get(s)[0], dragonNames.get(s)[1], dragonNames.get(s)[2]).println();
            }
        }
    }
}
