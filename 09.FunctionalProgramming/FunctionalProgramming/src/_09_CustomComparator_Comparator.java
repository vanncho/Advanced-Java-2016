import java.util.*;

public class _09_CustomComparator_Comparator {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("\\s+");

        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < numAsStrings.length; i++) {

            int num = Integer.parseInt(numAsStrings[i]);
            numbers.add(num);
        }

        Comparator<Integer> compareIntegers = new Comparator<Integer>() {
            @Override
            public int compare(Integer x, Integer y) {
                if (x % 2 == 0 && y % 2 != 0){
                    return -1;
                } else if (x % 2 != 0 && y % 2 == 0){
                    return 1;
                } else {
                    if (x < y){
                        return -1;
                    } else if (x > y){
                        return 1;
                    }
                    return 0;
                }
            }
        };

        Collections.sort(numbers, compareIntegers);
        //numbers.sort(compareIntegers);
        for (Integer number : numbers) {
            System.out.printf("%s ", number);
        }
    }
}
