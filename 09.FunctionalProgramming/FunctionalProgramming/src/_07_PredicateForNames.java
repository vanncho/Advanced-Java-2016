import java.util.Scanner;
import java.util.function.Predicate;

public class _07_PredicateForNames {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        String[] numAsStrings = input.nextLine().split("\\s+");

        Predicate<String> predicate = name -> name.length() <= n;

        for (int i = 0; i < numAsStrings.length; i++) {

            if (predicate.test(numAsStrings[i])){
                System.out.println(numAsStrings[i]);
            }
        }
    }
}
