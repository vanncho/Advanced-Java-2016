import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _09_CustomComparator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numAsStrings.length; i++) {

            int num = Integer.parseInt(numAsStrings[i]);
            numbers.add(num);
        }

        numbers.stream().filter(x -> x % 2 == 0).sorted((x, y) -> x.compareTo(y)).forEach(x -> System.out.printf("%s ", x));
        numbers.stream().filter(x -> x % 2 != 0).sorted((x, y) -> x.compareTo(y)).forEach(x -> System.out.printf("%s ", x));
    }
}
