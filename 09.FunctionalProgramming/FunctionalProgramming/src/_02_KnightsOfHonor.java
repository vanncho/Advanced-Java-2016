import java.util.Scanner;
import java.util.function.BiConsumer;

public class _02_KnightsOfHonor {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] names = input.nextLine().split("\\s+");

        BiConsumer<String, String> print = (title, name) -> System.out.printf("%s %s\n", title, name);

        for (String name : names) {
            print.accept("Sir", name);
        }
    }
}
