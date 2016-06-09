import java.util.Random;
import java.util.function.Supplier;

public class _991_SupplierLiveDemo {
    public static void main(String[] args) {

        String[] player = new String[]{"Ivan", "Pesho", "Gosho", "Tosho"};

        Supplier<Integer> dice = () -> new Random().nextInt(12);

        for (String name : player) {
            System.out.printf("%s rolled %d!%n", name, dice.get());
        }
    }
}
