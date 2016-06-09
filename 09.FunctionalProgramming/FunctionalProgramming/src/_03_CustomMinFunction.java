import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _03_CustomMinFunction {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("\\s+");
        int[] numbers = new int[numAsStrings.length];

        for (int i = 0; i < numAsStrings.length; i++) {
            int num = Integer.parseInt(numAsStrings[i]);
            numbers[i] = num;
        }

        Function<int[], Integer> function = new Function<int[], Integer>() {
            @Override
            public Integer apply(int[] ints) {
                int smallest = Integer.MAX_VALUE;
                for (int i = 0; i < numbers.length; i++) {
                    if (numbers[i] < smallest){
                        smallest = numbers[i];
                    }
                }
                return smallest;
            }
        };

        System.out.println(function.apply(numbers));
    }
}
