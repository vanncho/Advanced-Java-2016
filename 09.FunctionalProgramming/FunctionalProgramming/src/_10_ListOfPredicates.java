import java.util.Scanner;
import java.util.function.Predicate;

public class _10_ListOfPredicates {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();

        String[] numAsStrings = input.nextLine().split("\\s+");

        for (int i = 1; i <= n; i++) {

            boolean isPredicate = false;

            for (int j = 0; j < numAsStrings.length; j++) {
                int divider = Integer.parseInt(numAsStrings[j]);

                Predicate<Integer> predicate = num -> num % divider == 0;

                if (predicate.test(i)){
                    isPredicate = true;
                } else{
                    isPredicate = false;
                    break;
                }
            }

            if (isPredicate){
                System.out.printf("%s ", i);
            }
        }
    }
}
