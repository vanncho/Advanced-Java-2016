import java.util.Scanner;

public class _05_AppliedArithmetics {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] numAsStrings = input.nextLine().split("\\s+");
        int[] numbers = new int[numAsStrings.length];

        for (int i = 0; i < numAsStrings.length; i++) {
            int num = Integer.parseInt(numAsStrings[i]);
            numbers[i] = num;
        }

        while (true){
            String command = input.nextLine();

            if (command.equals("end")){
                break;
            }

            switch (command){
                case "add":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] += 1;
                    }
                    break;
                case "subtract":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] -= 1;
                    }
                    break;
                case "multiply":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i] *= 2;
                    }
                    break;
                case "print":
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.printf("%d ", numbers[i]);
                    }
                    System.out.println();
                    break;
            }
        }
    }
}
