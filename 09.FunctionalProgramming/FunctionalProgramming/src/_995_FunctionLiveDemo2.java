import java.util.HashMap;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class _995_FunctionLiveDemo2 {
    public static void main(String[] args) {
        String[] items = new String[]{"Cheese", "Apple", "Poisonous plant", "Mushroom"};
        HashMap<String, Integer> itemProperties = new HashMap<>();

        itemProperties.put("Cheese", 30);
        itemProperties.put("Apple", 10);
        itemProperties.put("Poisonous plant", -45);
        itemProperties.put("Mushroom", -20);

        Supplier<Integer> dice = () -> new Random().nextInt(items.length);

        Function<String, Integer> getItemProperties = item -> itemProperties.get(item);

        int playerHealth = 100;
        int movesLeft = 5;

        while (movesLeft > 0){
            String item = items[dice.get()];

            playerHealth += getItemProperties.apply(item);

            System.out.printf("%s eaten. Player now has %d health.%n", item, playerHealth);
            movesLeft--;
        }
    }
}
