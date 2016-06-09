import java.util.Scanner;
import java.util.function.Function;

public class _08_FindTheSmallestElement {
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
                int min = Integer.MAX_VALUE;
                int index = 0;

                for (int i = 0; i < ints.length; i++) {
                    if (ints[i] <= min){
                        index = i;
                        min = ints[i];
                    }
                }
                return index;
            }
        };

        System.out.println(function.apply(numbers));
    }
}
