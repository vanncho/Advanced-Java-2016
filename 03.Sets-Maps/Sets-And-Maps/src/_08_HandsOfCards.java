import java.util.*;

public class _08_HandsOfCards {
    public static void main(String[] args) {

        Scanner console = new Scanner(System.in);

        LinkedHashMap<String, TreeSet<String>> player = new LinkedHashMap<>();

        while (true) {

            String line = console.nextLine().trim();
            if (line.equals("JOKER")){
                break;
            }

            String[] playerInfo = line.split("[:,] ");
            String name = playerInfo[0];

            if (!player.containsKey(name)) {
                {
                    player.put(name, new TreeSet<String>());
                }
            }

            for (int i = 1; i < playerInfo.length; i++) {
                String currCard = playerInfo[i];
                player.get(name).add(currCard);
            }
        }

        for (String s : player.keySet()) {
            TreeSet<String> playerHand = player.get(s);
            int val = calculateValueFromCurrentCard(playerHand);
            System.out.println(s + ": " + val);
        }
    }

    private static int calculateValueFromCurrentCard(TreeSet<String> playerHand) {
        int sum = 0;
        List<Character> multipliers = new ArrayList<>(Arrays.asList(' ', 'C', 'D', 'H', 'S'));
        List<Character> powers = new ArrayList<>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', '1', 'J', 'Q', 'K', 'A'));

        for (String hand : playerHand) {
            int power = powers.indexOf(hand.charAt(0)) + 2;
            int multiply = multipliers.indexOf(hand.charAt(hand.length() - 1));

            sum += power * multiply;
        }
        return sum;
    }
}
